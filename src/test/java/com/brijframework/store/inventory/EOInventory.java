package org.brijframework.store.inventory;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.brijframework.beans.DataBean;

@Entity
public class EOInventory extends DataBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Date busiDate;
	public boolean isPosted;
	public double totalCost; // in cents
	public double totalSales; // Total sales in cents
	public double theoreticalCost; // Theoretical Food Cost in cents
	public double totalInvValue; // in cents
	public long numWarnings;
	public boolean isDirty; // set this to dirty if delivery / menu mix is added / updated / deleted

	@OneToOne
	@JoinColumn(name = "EOOpeningInvID", nullable = true)
	public EOInventory openingInv;
	
}
