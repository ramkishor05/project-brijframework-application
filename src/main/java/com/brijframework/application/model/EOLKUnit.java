package com.brijframework.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EOLKUnit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeID;
	private String shortDesc;
	private String longDesc;
	private String friendlyName;

	@ManyToOne
	@JoinColumn(name = "UNIT_GROUP_ID")
	private EOLKUnitGroup unitGroup;

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public EOLKUnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(EOLKUnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}

}
