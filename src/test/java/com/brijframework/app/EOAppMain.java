package org.brijframework.app;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.svcs.Request;
import org.brijframework.base.IAppMain;
import org.brijframework.beans.DataBean;
import org.brijframework.constants.RequestAccess;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.hr.EOAppRole;
import org.brijframework.hr.EORole;

@Entity
@DBEntity
public class EOAppMain extends DataBean implements IAppMain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String INVERTORY="INVERTORY_APP";
	
	
	public String appID;
	public String appName;
	public String appLogo;
	public String appURL;

	@Properties
	@OneToOne
	public EOAppDetail appDetail;
	@Properties
	@OneToOne
	public EOAppEdition appEdition;
	@Properties
	@OneToOne
	public EOAppFeature appFeature;

	@OneToMany(mappedBy = "eoAppMain", fetch = FetchType.EAGER)
	@Properties
	public Set<EOAppRole> eoAppRoleArray = new LinkedHashSet<>();

	@Override
	@Request(access = RequestAccess.DIRECT)
	public List<?> getAllObject() {
		return super.getAllObject();
	}

	public EOAppRole appRoleForRole(EORole eoRole) {
		for (EOAppRole appRole : this.eoAppRoleArray) {
			if (appRole.eoRole.uniqueID == eoRole.uniqueID) {
				return appRole;
			}
		}
		return null;
	}
	
	public boolean isInventory(){
		return INVERTORY.equals(this.appID);
	}
}
