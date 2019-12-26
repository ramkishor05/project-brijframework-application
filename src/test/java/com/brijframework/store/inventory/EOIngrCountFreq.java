package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.brijframework.beans.DataBean;
@Entity
public class EOIngrCountFreq extends DataBean{

	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name="IngrID")
	public EOIngr  eoIngr;
	@OneToOne
	@JoinColumn(name="CountFreqID")
	public EOCountFreq eoCountFreq;
}


