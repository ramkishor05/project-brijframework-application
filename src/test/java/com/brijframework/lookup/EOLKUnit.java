package org.brijframework.lookup;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.beans.DataBean;
import org.brijframework.db.annotation.DBEntity;

@Entity
@DBEntity(isGlobal=true)
public class EOLKUnit extends DataBean{
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
	public EOLKUnitGroup  eoUnitGroup;

}
