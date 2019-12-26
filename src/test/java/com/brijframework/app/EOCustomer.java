package org.brijframework.app;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.brijframework.atn.svcs.Request;
import org.brijframework.atn.ui.UILookup;
import org.brijframework.atn.ui.UITable;
import org.brijframework.base.Person;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.beans.collection.MapBean;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.db.processor.DBDataProcessor;
import org.brijframework.hr.EOAppRole;
import org.brijframework.hr.EOCustRole;
import org.brijframework.hr.EOCustUser;
import org.brijframework.hr.EORole;
import org.brijframework.hr.UIRole;
import org.brijframework.lookup.EOAddress;
import org.brijframework.util.objects.DateUtil;

@Entity
@DBEntity(isGlobal=true)
@UITable(id = "EOCustomer_01",
rowFieldIDs = { "customerID", "customerType", "registeredOnDate", "firstName", "midName", "lastName", "age" }, 
mdlFieldIDs = { "customerID", "customerType", "registeredOnDate", "firstName", "midName", "lastName","age" })
@UILookup(displayKey = "customerID")
public class EOCustomer extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String customerID;
	public String customerType;
	public Date registeredOnDate;
	
	@OneToMany(mappedBy = "eoCustomer")
	public Set<EOAddress> addressArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoCustomer")
	public Set<EOCustUser> eoCustUserArray = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "eoCustomer")
	public Set<EOCustRole> eoCustRoleArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoCustomer")
	public Set<EOCustApp> eoCustAppArray = new LinkedHashSet<>(); // Distinct apps purchased by customer
	
	@OneToMany(mappedBy = "eoCustomer")
	public Set<EOCustConcept>  eoCustConceptArray=new LinkedHashSet<>();

	public ListBean<EOCustApp> custAppForRole(EORole eoRole) {
		ListBean<EOCustApp> custApps = new ListBean<>();
		for (EOCustApp app : this.eoCustAppArray) {
			if (app.isAccessed(eoRole)) {
				custApps.addUnique(app, "uniqueID");
			}
		}
		return custApps;
	}

	@Request
	public MapBean<String , Object> addCustApp(Map<String, Object> map) {
		EOAppMain appMain = this.getObject(EOAppMain.class, this.longValue(map.get("eoAppID")));
		EOCustApp eoCustApp = DBDataProcessor.getProcessor().addObject(EOCustApp.class, new MapBean<>("eoCustomer~eoAppMain~createdAt", this, appMain, DateUtil.currentSqlDate()));
		EOAppRole eoAppRole=appMain.appRoleForRole(EORole.roleObject(UIRole.OWNER));
		return new MapBean<>("appID~menuID",eoCustApp.uniqueID,eoAppRole.appMenuID);
	}

	@Request
	public ListBean<EOCustApp> userCustApp(MapBean<String, Object> map) {
		EOCustRole eoCustRole = this.find(EOCustRole.class, "uniqueID", map.longValue("roleID"));
		if (eoCustRole != null) {
			return this.custAppForRole(eoCustRole.eoRole);
		}
		return null;
	}

	public static void main(String[] args) {
		EOCustomer customer = DBDataProcessor.getProcessor().getObject(EOCustomer.class, 517);
		ListBean<EOCustApp> eoCustApps = customer.userCustApp(new MapBean<>("roleID", 502));
		System.out.println(eoCustApps.printFullGraph());
	}

	public void initInventory() {
		EOCustConcept eoCustConcept=this.addToRel("eoCustConceptArray", new MapBean<String, Object>("eoCustomer",this));
		eoCustConcept.addToRel("eoInvApp", new MapBean<>());
	}
}
