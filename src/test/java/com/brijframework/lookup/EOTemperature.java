package org.brijframework.lookup;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;

@Entity
public class EOTemperature extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String tempFormat; // temperature format
	public String nameFormat; // nameFormat
	
}
