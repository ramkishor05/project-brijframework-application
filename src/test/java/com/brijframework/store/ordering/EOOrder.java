package org.brijframework.store.ordering;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.brijframework.atn.ui.UILookup;
import org.brijframework.atn.ui.UIRelField;
import org.brijframework.beans.DataBean;
import org.brijframework.store.inventory.EOProduct;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"orderID"}))
@UILookup(displayKey="orderID")
public class EOOrder extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String orderID;
	public Date orderDate;
	public Date requiredDate;
	public Date shoppingDate;
	public long unitPrice;
	public long quantity;
	public long discount;
	public long price;
	
	@OneToOne
	@UIRelField(displayKey="name")
	public EOCoupan eoCoupan;
	
	@OneToOne
	@UIRelField(displayKey="name")
	@JoinColumn(name="ProductID")
	public EOProduct eoProduct;
}
