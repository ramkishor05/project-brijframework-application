package org.brijframework.lookup;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;
import org.brijframework.db.annotation.DBEntity;

@Entity
@DBEntity(isGlobal=true)
public class EOLKCountFreq extends DataBean{

	private static final long serialVersionUID = 1L;
	
	public String typeID;
	public String name;
	public String description;
}
