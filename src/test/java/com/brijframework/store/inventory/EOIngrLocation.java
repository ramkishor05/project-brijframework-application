package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brijframework.beans.DataBean;

@Entity
@Table
public class EOIngrLocation extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	public float displayOrder;
	@ManyToOne
	@JoinColumn(name="IngrID")
	public EOIngr eoIngr;
	
	@ManyToOne
	@JoinColumn(name="LocationID")
	public EOLocation eoLocation;
	
}

