package org.brijframework.lookup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.brijframework.beans.DataBean;
@Entity
public class EOLKLocation  extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String locationID;
	
}
