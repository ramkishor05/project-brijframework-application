package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.EOCategory;
import org.brijframework.store.inventory.EOCategoryGroup;

@UIGraph
public class UICategoryGroup extends ModelBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Object uniqueID;
	public String categoryID;
	public String name;
	public String description;
	public String typeID;
	
	@Properties
	public ListBean<UICategory> categoryArray=new ListBean<>();
	
	private EOCategoryGroup categoryGroup;
	
	public UICategoryGroup(EOCategoryGroup categoryGroup) {
		this.categoryGroup=categoryGroup;
		this.fillData();
	}
	
	public void fillData(){
		this.uniqueID=this.categoryGroup.uniqueID;
		this.categoryID=this.categoryGroup.categoryID;
		this.name=this.categoryGroup.name;
		this.description=this.categoryGroup.description;
		this.typeID=this.categoryGroup.typeID;
		for(EOCategory eoCategory:this.categoryGroup.eoCategoryArray){
			categoryArray.add(new UICategory(eoCategory));
		}
	}
}
