package org.brijframework.store.inventory;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.brijframework.atn.ui.UILookup;
import org.brijframework.atn.ui.UIRelField;
import org.brijframework.atn.ui.UITable;
import org.brijframework.beans.DataBean;


@Entity
@UITable(id="EOProductDetails_001",
mdlFieldIDs={"batchID","manufacturer","MRP","expDate","mfrDate","unitPrice","quantityPerUnit","unitsInStock","unitsInOrder","eoProduct"},
rowFieldIDs={"batchID","manufacturer","expDate","mfrDate","unitPrice","quantityPerUnit","unitsInStock","unitsInOrder"})
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"productID"})})
@UILookup(description="manufacturer",displayKey="batchID", uitype="lookup", id="EOProductDetail",name="unitPrice")
public class EOProductDetail extends DataBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String productDetailID;
	public long batchID;
	public double MRP;
	public String manufacturer;
	public Date expDate;
	public Date mfrDate;
	public double unitPrice; 
	public double quantityPerUnit;
	public long unitsInStock; 
	public long unitsInOrder;
	public String Type;
	
	@ManyToOne
	@JoinColumn(name="productID")
	@UIRelField(displayKey="description")
	public EOProduct eoProduct;
	
}