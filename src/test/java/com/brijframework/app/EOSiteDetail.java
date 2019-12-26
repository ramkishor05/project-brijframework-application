package org.brijframework.app;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.brijframework.beans.DetailBean;
import org.brijframework.db.annotation.DBEntity;
@Entity
@DBEntity(isGlobal=true)
public class EOSiteDetail extends DetailBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
	public Integer extension;
	@Transient
	public String timezone;
	@Transient
	public int rangeRadius;
	@Transient
	public Timestamp lastAccessedAt;
}
