package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.EOCountFreq;
import org.brijframework.store.inventory.EOInvApp;
import org.brijframework.store.inventory.EOPrep;
import org.brijframework.store.inventory.EOStorage;

@UIGraph
public class UIPrepSummary extends ModelBean{

	private static final long serialVersionUID = 1L;
	
	@Properties
	public ListBean<UIPreparation> prepList=new ListBean<>();
	
	@Properties
	public ListBean<UIStorage> storageList=new ListBean<>();
	
	@Properties
	public ListBean<UICountFreq> countFreqList = new ListBean<>();

	private EOInvApp eoInvApp;
	public UIPrepSummary(EOInvApp eoInvApp) {
		this.eoInvApp=eoInvApp;
		this.fillData();
	}
	
	private void fillData() {
		for(EOPrep eoPrep:eoInvApp.eoPrepArray){
			prepList.add(new UIPreparation(eoPrep));
		}
		for (EOStorage eoStorage : eoInvApp.eoStorageArray) {
			UIStorage storage=new UIStorage(eoStorage);
			storage.loadLocations();
			storageList.add(storage);
		}
		for (EOCountFreq eoCountFreq : eoInvApp.eoCountFreqArray) {
			countFreqList.add(new UICountFreq(eoCountFreq));
		}
	}

}
