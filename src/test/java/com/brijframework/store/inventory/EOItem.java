package org.brijframework.store.inventory;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.brijframework.beans.DataBean;

@MappedSuperclass
public abstract class EOItem extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public String idenNo;
	public String name;
	private String logoUrl;
	public String description;
	
	public void setLogoUrl(String logoUrl){
		this.logoUrl=logoUrl;
	}
	public String getLogoUrl() {
		return this.logoUrl;
	}
	
	@Lob
	public String instructions;
	public float unitCost; // in cents - can be 1.25 cents as this is average
	
}
