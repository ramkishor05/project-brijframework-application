package org.brijframework.store.ordering;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.brijframework.beans.DataBean;
import org.brijframework.store.inventory.EOProduct;

@Entity
public class EOSale extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name="Order")
	public EOOrder eoOrder;
	
	@OneToOne
	@JoinColumn(name="ProductID")
	public EOProduct eoProduct;
	
	@OneToMany
	public Set<EOCoupan> eoCoupanArray=new LinkedHashSet<>();
}
