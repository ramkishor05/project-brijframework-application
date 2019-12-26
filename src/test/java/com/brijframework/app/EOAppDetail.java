package org.brijframework.app;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;
import org.brijframework.db.annotation.DBColField;
@Entity
public class EOAppDetail extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@DBColField(displayFormat="" )
	public double displayOrder;
	public String internalHost;
	public String externalHost;
	public String internalPort;
	public String externalPort;
}
