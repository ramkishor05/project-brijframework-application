package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.EOLocation;
import org.brijframework.store.inventory.EOStorage;

@UIGraph
public class UIStorage extends ModelBean{

	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String id;
	public float displayOrder;
	public String name;
	public boolean isActive;

	private EOStorage eoStorage;
	
	@Properties
	public ListBean<UILocation> locationList=new  ListBean<>();

	public UIStorage(EOStorage eoStorage) {
		this.eoStorage=eoStorage;
		this.fillData();
	}

	private void fillData() {
		this.uniqueID=eoStorage.uniqueID;
		this.id=eoStorage.id;
		this.displayOrder=eoStorage.displayOrder;
		this.name=eoStorage.name;
		this.isActive=eoStorage.isActive;
	}
	
	public void loadLocations(){
		for(EOLocation eoLocation:this.eoStorage.eoLocationArray){
			locationList.add(new UILocation(eoLocation));
		}
	}
}
