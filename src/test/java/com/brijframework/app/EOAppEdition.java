package org.brijframework.app;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;
@Entity
public class EOAppEdition extends DataBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double displayOrder;
	public String description;
	public double monthlyRate; 
	public int  startPayDay;
	public boolean isFreeEdition;
	public double version;
}
