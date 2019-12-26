package org.brijframework.lookup;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;

@Entity
public class EOCurrency extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String crnID;
	public String crnCode;
	public String discription;
}
