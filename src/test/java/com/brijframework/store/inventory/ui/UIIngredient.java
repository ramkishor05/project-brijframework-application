package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.EOIngr;
import org.brijframework.store.inventory.EOIngrCountFreq;
import org.brijframework.store.inventory.EOIngrLocation;

@UIGraph
public class UIIngredient extends ModelBean{
	
	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String idenNo;
	public String name;
	public  String logoUrl;
	public String description;
	
	public long eoCategory;	
	public long eoBaseUnit;
	public long eoRptUnit;
	public long eoImgDetail;
	
	@Properties
	public ListBean<UILocation> locationArray=new ListBean<>();
	
	@Properties
	public ListBean<UICountFreq> countFreqArray=new ListBean<>();
	
	private EOIngr eoIngr;
	
	public UIIngredient(EOIngr eoIngr) {
		this.eoIngr=eoIngr;
		this.fillData();
	}

	private void fillData() {
		this.uniqueID=this.eoIngr.uniqueID;
		this.idenNo=this.eoIngr.idenNo;
		this.name=this.eoIngr.name;
		this.description=this.eoIngr.description;
		this.logoUrl=this.eoIngr.logURL();
		if(this.eoIngr.eoCategory!=null)
		this.eoCategory=this.eoIngr.eoCategory.uniqueID;
		if(this.eoIngr.eoBaseUnit!=null)
		this.eoBaseUnit=this.eoIngr.eoBaseUnit.uniqueID;
		if(this.eoIngr.eoRptUnit!=null)
		this.eoRptUnit=this.eoIngr.eoRptUnit.uniqueID;
		if(this.eoIngr.eoImgDetail!=null)
		this.eoImgDetail=this.eoIngr.eoImgDetail.uniqueID;
	}
	
	public void fillDetail(){
		for(EOIngrCountFreq eoCountFreq:this.eoIngr.eoIngrCountFreqArray){
			UIIngrCountFreq countFreq=new UIIngrCountFreq(eoCountFreq.eoCountFreq);
			countFreq.setIngr(eoCountFreq);
			countFreqArray.add(countFreq);
		}
		for(EOIngrLocation eoIngrLocation:this.eoIngr.eoIngrLocationArray){
			UIIngrLocation location=new UIIngrLocation(eoIngrLocation.eoLocation);
			location.setIngr(eoIngrLocation);
			locationArray.add(location);
		}
	}
	
}

