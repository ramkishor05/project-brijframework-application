package org.brijframework.app;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.brijframework.atn.bean.Properties;
import org.brijframework.beans.DataBean;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.store.inventory.EOInvApp;

@Entity
@DBEntity(isGlobal=true)
public class EOCustConcept extends DataBean{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "EOCustomerID", nullable = false)
	public EOCustomer eoCustomer;
      
	@OneToMany(mappedBy="eoCustConcept")
	public Set<EOSiteMain> eoSiteArray=new LinkedHashSet<>();
	
	@Properties
	@OneToOne
	public EOInvApp eoInvApp;
	
}
