package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.UIGraph;
import org.brijframework.store.inventory.EOCountFreq;
import org.brijframework.store.inventory.EOPrepCountFreq;

@UIGraph
public class UIPrepCountFreq extends UICountFreq{
	private static final long serialVersionUID = 1L;

	public long eoPrep;
	public long eoCountFreq;
	

	public UIPrepCountFreq(EOCountFreq eoCountFreq) {
		super(eoCountFreq);
	}
	
	public void setIngr(EOPrepCountFreq countFreq) {
		this.uniqueID=countFreq.uniqueID;
		this.eoPrep=countFreq.eoPrep.uniqueID;
		this.eoCountFreq=countFreq.uniqueID;
	}
}