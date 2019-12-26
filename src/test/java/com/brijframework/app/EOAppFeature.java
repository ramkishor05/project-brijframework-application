package org.brijframework.app;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;
@Entity
public class EOAppFeature extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String description;
	public double displayOrder;
	public String viewDetail;
}
