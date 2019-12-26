package org.brijframework.store.ordering;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.brijframework.atn.ui.UIRelField;
import org.brijframework.beans.DataBean;
import org.brijframework.store.inventory.EOProductDetail;
@Entity
public class EOCart extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int quantity=1;
	public double quantityPerUnit;
	public Date seletedDate;
	public boolean isChecked;
	public double totalAamount;
	
	@OneToOne
	@UIRelField(displayKey="name")
	public EOCoupan eoCoupan;
	
	@OneToOne
	public EOProductDetail eoProductDetail;
}
