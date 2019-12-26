package org.brijframework.hr;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.brijframework.beans.DataBean;
import org.brijframework.hr.EONotification;

@Entity
public class EOAppUser extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="eoAppUser")
	public Set<EONotification> eoNotificationArray=new LinkedHashSet<>();
}
