package org.brijframework.lookup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.app.EOCustomer;
import org.brijframework.atn.ui.UILookup;
import org.brijframework.beans.DataBean;
import org.brijframework.store.crm.EOEmployee;
import org.brijframework.store.crm.EOOrganization;
import org.brijframework.store.crm.EOSupplier;

@Entity
@UILookup(description = "address", displayKey = "addressLine1", uitype = "lookup", id = "EOAddress", name = "address")
public class EOAddress extends DataBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int addressID;
	public String addressLine1;
	public String addressLine2;
	public String postAddress;
	public String postCode;
	public String landMark;

	@ManyToOne
	@JoinColumn(name = "cityID")
	public EOCity eoCity;
	
	@ManyToOne
	@JoinColumn(name = "customerID")
	public EOCustomer eoCustomer;
	
	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	public EOEmployee eoEmployee;
	
	@ManyToOne
	@JoinColumn(name = "OrganizationID")
	public EOOrganization eoOrganization;
	
	@ManyToOne
	@JoinColumn(name = "SupplierID")
	public EOSupplier eoSupplier;
	
}
