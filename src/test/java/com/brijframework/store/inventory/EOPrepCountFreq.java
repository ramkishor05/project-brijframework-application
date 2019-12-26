package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.brijframework.beans.DataBean;

@Entity
public class EOPrepCountFreq extends DataBean{

	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name="PrepID")
	public EOPrep  eoPrep;
	@OneToOne
	@JoinColumn(name="CountFreqID")
	public EOCountFreq eoCountFreq;
}
