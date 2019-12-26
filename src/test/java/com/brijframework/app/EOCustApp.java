package org.brijframework.app;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.svcs.Request;
import org.brijframework.beans.DataBean;
import org.brijframework.beans.collection.MapBean;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.hr.EOAppRole;
import org.brijframework.hr.EORole;

@Entity
@Table(name = "EOCustApp", indexes = { @Index(name = "EOCustApp_Idx_cust_app", columnList = "EOCustomerID, EOAppMainID", unique = true),
		@Index(name = "EOCustApp_Idx_app", columnList = "EOAppMainID", unique = false) })
@DBEntity(isGlobal=true)
public class EOCustApp extends DataBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Timestamp createdAt;

	@Properties
	@ManyToOne
	@JoinColumn(name = "EOCustomerID", nullable = false)
	public EOCustomer eoCustomer;
	
	@Properties
	@ManyToOne
	@JoinColumn(name = "EOAppMainID", nullable = false)
	public EOAppMain eoAppMain;
	
	public boolean isAccessed(EORole eoRole) {
		for (EOAppRole appRole : this.eoAppMain.eoAppRoleArray) {
			if (eoRole.position >= appRole.eoRole.position) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public <T> T postCreate() {
		if(this.eoAppMain.isInventory()){
			this.eoCustomer.initInventory();
		}
		return null;
	}
	
	@Request
	public MapBean<String, Object> getSelectForApp(){
		MapBean<String, Object>  mapBean=new MapBean<>();
		if(this.eoAppMain.isInventory()){
			EOCustConcept eoCustConcept=this.find(EOCustConcept.class, "eoCustomer", this.eoCustomer);
			mapBean.put("appMain",eoCustConcept.eoInvApp.getUniqueID());
		}
		return mapBean;
	}
}
