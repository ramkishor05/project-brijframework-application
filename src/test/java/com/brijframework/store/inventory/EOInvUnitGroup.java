package org.brijframework.store.inventory;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.brijframework.beans.DataBean;

@Entity
public class EOInvUnitGroup extends DataBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String typeID;
	public String shortDesc;
	public String longDesc;
	public String friendlyName;
	
	@ManyToOne
	@JoinColumn(name="InvAppID")
    public EOInvApp eoInvApp;
	
	
	@OneToMany(mappedBy="eoUnitGroup")
	public Set<EOInvUnit> eoUnitArray=new LinkedHashSet<>();
}