package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.store.inventory.EOProduct;

@UIGraph
public class UIProduct extends ModelBean{

	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String idenNo;
	public String name;
	public String logoUrl;
	public String description;
	public long eoImgDetail;
	
	private EOProduct eoProduct;
	public UIProduct(EOProduct eoProduct) {
		this.eoProduct=eoProduct;
		this.fillData();
	}
	private void fillData() {
		this.uniqueID=this.eoProduct.uniqueID;
		this.idenNo=this.eoProduct.idenNo;
		this.name=this.eoProduct.name;
		this.description=this.eoProduct.description;
		this.logoUrl=this.eoProduct.logURL();
		if(this.eoProduct.eoImgDetail!=null)
		this.eoImgDetail=this.eoProduct.eoImgDetail.uniqueID;
	}
}
