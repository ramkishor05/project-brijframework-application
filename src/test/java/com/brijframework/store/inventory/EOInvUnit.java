package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.beans.DataBean;

@Entity
public class EOInvUnit extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String typeID;
	public String shortDesc;
	public String longDesc;
	public String friendlyName;
		
	@ManyToOne
	@JoinColumn(name="EOUnitGroupID")
	public EOInvUnitGroup  eoUnitGroup;
}
