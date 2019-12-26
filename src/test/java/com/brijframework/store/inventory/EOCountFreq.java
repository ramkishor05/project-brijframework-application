package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.beans.DataBean;

@Entity
public class EOCountFreq extends DataBean{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="InvAppID", nullable=false)
	public EOInvApp eoInvApp;
	
	public String typeID;
	public String name;
	public String description;
	public float displayOrder;
	
}
