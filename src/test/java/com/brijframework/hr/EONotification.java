package org.brijframework.hr;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.beans.DataBean;

@Entity
public class EONotification extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="CustUserID")
	public EOCustUser eoCustUser;
	
	@ManyToOne
	@JoinColumn(name="AppUserID")
	public EOAppUser eoAppUser;
}
