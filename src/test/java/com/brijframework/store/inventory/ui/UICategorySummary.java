package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.EOCategory;
import org.brijframework.store.inventory.EOCategoryGroup;
import org.brijframework.store.inventory.EOInvApp;

@UIGraph
public class UICategorySummary {

	@Properties
	public ListBean<UICategoryGroup> categoryGroups=new ListBean<>();
	
	@Properties
	public ListBean<UICategory> categoryList=new ListBean<>();
	
	private EOInvApp eoInvApp;
	public UICategorySummary(EOInvApp eoInvApp) {
		this.eoInvApp=eoInvApp;
		this.fillData();
	}
	
	private void fillData() {
		for(EOCategory eoCategory:eoInvApp.eoCategoryArray){
			categoryList.add(new UICategory(eoCategory));
		}
		for(EOCategoryGroup eoCategory:eoInvApp.eoCategoryGroupArray){
			categoryGroups.add(new UICategoryGroup(eoCategory));
		}
	}
}
