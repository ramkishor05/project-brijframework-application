package org.brijframework.store.ordering;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.beans.DataBean;
@Entity
public class EOCoupan extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public String coupanID;
    public String name;
    public String despription;
    
    @ManyToOne
    @JoinColumn(name="SaleID")
    public  EOSale eoSale;
}
