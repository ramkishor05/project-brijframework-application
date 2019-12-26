package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.store.inventory.EOLocation;

@UIGraph
public class UILocation extends ModelBean{

	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String idenNo;
	public float displayOrder;
	public String name;
	public boolean isActive;
	public long eoStorage;
	
	private EOLocation eoLocation;
	
	public UILocation(EOLocation eoLocation) {
		this.eoLocation=eoLocation;
		this.fillData();
	}
	private void fillData() {
		this.uniqueID=eoLocation.uniqueID;
		this.idenNo=eoLocation.idenNo;
		this.displayOrder=eoLocation.displayOrder;
		this.name=eoLocation.name;
		this.isActive=eoLocation.isActive;
		this.eoStorage=this.eoLocation.eoStorage.uniqueID;
	}
}