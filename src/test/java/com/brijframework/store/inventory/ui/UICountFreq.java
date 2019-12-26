package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.store.inventory.EOCountFreq;

@UIGraph
public class UICountFreq extends ModelBean{

	private static final long serialVersionUID = 1L;
	
	public long uniqueID;
	public String typeID;
	public String name;
	public String description;
	public boolean isActive;
	public float displayOrder;
	
	private EOCountFreq countFreq;
	public UICountFreq(EOCountFreq eoCountFreq) {
		this.countFreq=eoCountFreq;
		this.fillData();
	}

	private void fillData() {
		this.uniqueID=this.countFreq.uniqueID;
		this.name=this.countFreq.name;
		this.description=this.countFreq.description;
		this.typeID=this.countFreq.typeID;
		this.isActive=this.countFreq.isActive;
		this.displayOrder=this.countFreq.displayOrder;
	}

	
}
