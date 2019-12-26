package org.brijframework.lookup;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.brijframework.beans.DataBean;
import org.brijframework.db.annotation.DBEntity;

@Entity
@DBEntity(isGlobal=true)
public class EOLKUnitGroup extends DataBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String typeID;
	public String shortDesc;
	public String longDesc;
	public String friendlyName;
	
	@OneToMany(mappedBy="eoUnitGroup")
	public Set<EOLKUnit> eoUnitArray=new LinkedHashSet<>();
	
}
