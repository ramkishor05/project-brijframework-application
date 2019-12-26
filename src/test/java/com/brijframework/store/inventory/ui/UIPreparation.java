package org.brijframework.store.inventory.ui;

import org.brijframework.beans.ModelBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.EOPrep;

public class UIPreparation extends ModelBean{

	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String idenNo;
	public String name;
	public  String logoUrl;
	public String description;
	public double qnt;
	public long eoImgDetail;

	
	public ListBean<UILocation> locationArray=new ListBean<>();
	
	private EOPrep eoPrep;
	
	public UIPreparation(EOPrep eoPrep) {
		this.eoPrep=eoPrep;
		this.fillData();
	}
	
	private void fillData() {
		this.uniqueID=this.eoPrep.uniqueID;
		this.idenNo=this.eoPrep.idenNo;
		this.name=this.eoPrep.name;
		this.description=this.eoPrep.description;
		this.logoUrl=this.eoPrep.logURL();
		if(this.eoPrep.eoImgDetail!=null)
		this.eoImgDetail=this.eoPrep.eoImgDetail.uniqueID;
	}
	
}
