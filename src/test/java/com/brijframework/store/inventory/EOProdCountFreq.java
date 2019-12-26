package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.brijframework.beans.DataBean;

@Entity
public class EOProdCountFreq extends DataBean{

	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name="ProductID")
	public EOProduct  eoProduct;
	@OneToOne
	@JoinColumn(name="CountFreqID")
	public EOCountFreq eoCountFreq;
}
