package org.brijframework.store.inventory;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;

@Entity
public class EOImgDetail extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String type;
	public String url;
	public byte[] detail;
	
}
