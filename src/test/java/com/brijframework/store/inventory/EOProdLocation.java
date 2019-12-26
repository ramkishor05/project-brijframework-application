package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.beans.DataBean;

@Entity
public class EOProdLocation extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	public float displayOrder;
	@ManyToOne
	@JoinColumn(name="ProductID")
	public EOProduct eoProduct;
	
	@ManyToOne
	@JoinColumn(name="LocationID")
	public EOLocation eoLocation;
	
}