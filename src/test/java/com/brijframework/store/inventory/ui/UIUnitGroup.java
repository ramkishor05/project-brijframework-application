package org.brijframework.store.inventory.ui;

import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.bean.UIGraph;
import org.brijframework.beans.ModelBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.EOInvUnit;
import org.brijframework.store.inventory.EOInvUnitGroup;

@UIGraph
public class UIUnitGroup extends ModelBean {

	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String typeID;
	public String shortDesc;
	public String longDesc;
	public String friendlyName;

	@Properties
	public ListBean<UIRptUnit> unitArray = new ListBean<>();

	EOInvUnitGroup invUnitGroup;

	public UIUnitGroup(EOInvUnitGroup invUnitGroup) {
		this.invUnitGroup = invUnitGroup;
		this.fillData();
	}

	private void fillData() {
		this.loadObject(invUnitGroup);
		for (EOInvUnit eoInvUnit : invUnitGroup.eoUnitArray)
			this.unitArray.add(new UIRptUnit(eoInvUnit));
	}
}

class UIRptUnit extends ModelBean {
	private static final long serialVersionUID = 1L;
	public long uniqueID;
	public String typeID;
	public String shortDesc;
	public String longDesc;
	public String friendlyName;

	EOInvUnit eoInvUnit;
	public UIRptUnit(EOInvUnit eoInvUnit) {
		this.eoInvUnit = eoInvUnit;
		this.fillData();
	}

	private void fillData() {
		this.loadObject(eoInvUnit);
	}
}