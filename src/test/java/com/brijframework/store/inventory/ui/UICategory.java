package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.store.inventory.EOCategory;

@UIGraph
public  class UICategory extends ModelBean {

	

	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String categoryID;
	public String name;
	public String description;
	public String typeID;
	
	public String categoryGroup;
	public long eoCategoryGroup;
	

	private EOCategory eoCategory;
	public UICategory(EOCategory eoCategory) {
		this.eoCategory=eoCategory;
		this.fillData();
	}
	
	private void fillData() {
		this.uniqueID=this.eoCategory.uniqueID;
		this.categoryID=this.eoCategory.categoryID;
		this.name=this.eoCategory.name;
		this.description=this.eoCategory.description;
		this.typeID=this.eoCategory.typeID;
		if(this.eoCategory.eoCategoryGroup!=null){
			this.eoCategoryGroup=this.eoCategory.eoCategoryGroup.uniqueID;
			this.categoryGroup=this.eoCategory.eoCategoryGroup.name;
		}
	}
	
}
