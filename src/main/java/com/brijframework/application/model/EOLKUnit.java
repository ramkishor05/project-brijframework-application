package com.brijframework.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EOLKUnit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	private String typeId;
	private String shortDesc;
	private String longDesc;
	private String friendlyName;

	@ManyToOne
	@JoinColumn(name = "UNIT_GROUP_ID")
	private EOLKUnitGroup unitGroup;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
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

	@Override
	public String toString() {
		return "EOLKUnit [id=" + id + ", typeId=" + typeId + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", friendlyName=" + friendlyName + ", unitGroup=" + unitGroup + "]";
	}

	
}
