package org.brijframework.store.crm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.brijframework.atn.ui.UILookup;
import org.brijframework.atn.ui.UITable;
import org.brijframework.beans.DataBean;
import org.brijframework.lookup.EOAddress;

@Entity
@UILookup(displayKey = "orgName")
@UITable(id="EOOrganization_01" ,rowFieldIDs={"orgID","title","orgName","licen","orgType"},
mdlFieldIDs={"orgID","title","orgName","licen","orgType"})
public class EOOrganization extends DataBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String orgID;
	public String title;
	public String orgName;
	public String licen;
	public String orgType;

	@OneToMany(mappedBy = "eoOrganization")
	public Set<EOAddress> addressArray = new HashSet<>();
}
