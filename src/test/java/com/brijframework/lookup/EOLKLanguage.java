package org.brijframework.lookup;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;

@Entity
public class EOLKLanguage extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String langID;
	public String langCode;
	public String discription;
}
