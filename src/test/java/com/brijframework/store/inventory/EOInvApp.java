package org.brijframework.store.inventory;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.brijframework.atn.svcs.Request;
import org.brijframework.base.IAppMain;
import org.brijframework.beans.DataBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.beans.collection.MapBean;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.db.processor.DBDataProcessor;
import org.brijframework.lookup.EOLKCountFreq;
import org.brijframework.lookup.EOLKUnit;
import org.brijframework.lookup.EOLKUnitGroup;
import org.brijframework.store.inventory.ui.UICategory;
import org.brijframework.store.inventory.ui.UICategoryGroup;
import org.brijframework.store.inventory.ui.UICategorySummary;
import org.brijframework.store.inventory.ui.UICountFreq;
import org.brijframework.store.inventory.ui.UIIngrSummary;
import org.brijframework.store.inventory.ui.UIIngredient;
import org.brijframework.store.inventory.ui.UIPrepSummary;
import org.brijframework.store.inventory.ui.UIPreparation;
import org.brijframework.store.inventory.ui.UIProduct;
import org.brijframework.store.inventory.ui.UIProductSummary;
import org.brijframework.store.inventory.ui.UIStorage;

@Entity
@DBEntity(isGlobal = true)
public class EOInvApp extends DataBean implements IAppMain {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T postCreate() {
		super.postCreate();
		List<EOLKCountFreq> eolkCountFreqs = (List<EOLKCountFreq>) DBDataProcessor.getProcessor()
				.getAllObject(EOLKCountFreq.class);
		for (EOLKCountFreq eolkCountFreq : eolkCountFreqs) {
			MapBean<String, Object> map = new MapBean<>(eolkCountFreq.objectMap());
			map.put("eoInvApp", this);
			this.addToRel("eoCountFreqArray", map);
		}
		List<EOLKUnitGroup> eolkUnitGroups = (List<EOLKUnitGroup>) DBDataProcessor.getProcessor().getAllObject(EOLKUnitGroup.class);
		for (EOLKUnitGroup eolkUnitGroup : eolkUnitGroups) {
			EOInvUnitGroup eoInvUnitGroup = this.addToRel("eoUnitGroupArray", eolkUnitGroup.objectMapWithKeys("typeID~shortDesc~longDesc~friendlyName"));
			for (EOLKUnit eolkUnit : eolkUnitGroup.eoUnitArray) {
				eoInvUnitGroup.addToRel("eoUnitArray", eolkUnit.objectMapWithKeys("typeID~shortDesc~longDesc~friendlyName"));
			}
		}
		return (T) this;
	}

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOCountFreq> eoCountFreqArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOInvUnitGroup> eoUnitGroupArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOProduct> eoProductArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOIngr> eoIngrArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOPrep> eoPrepArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOCategory> eoCategoryArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOCategoryGroup> eoCategoryGroupArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOStorage> eoStorageArray = new LinkedHashSet<>();

	@OneToMany(mappedBy = "eoInvApp")
	public Set<EOLocation> eoLocationArray = new LinkedHashSet<>();

	@Request
	public UIStorage addStorage(Map<String, Object> map) {
		map.put("eoInvApp", this);
		EOStorage eoStorage = this.addToRel("eoStorageArray", map);
		return new UIStorage(eoStorage);
	}

	@Request
	public ListBean<UIStorage> storages() {
		ListBean<UIStorage> storages = new ListBean<>();
		for (EOStorage eoStorage : this.eoStorageArray) {
			storages.add(new UIStorage(eoStorage));
		}
		return storages;
	}

	@Request
	public UICountFreq addFreq(Map<String, Object> map) {
		map.put("eoInvApp", this);
		EOCountFreq eoCountFreq = this.addToRel("eoCountFreqArray", map);
		return new UICountFreq(eoCountFreq);
	}

	@Request
	public ListBean<UICountFreq> countFreqs() {
		ListBean<UICountFreq> countFreqs = new ListBean<>();
		for (EOCountFreq eoCountFreq : this.eoCountFreqArray) {
			countFreqs.add(new UICountFreq(eoCountFreq));
		}
		return countFreqs;
	}

	@Request
	public UICategoryGroup addCategoryGroup(Map<String, Object> map) {
		EOCategoryGroup categoryGroup = this.addToRel("eoCategoryGroupArray", map);
		return new UICategoryGroup(categoryGroup);
	}

	@Request
	public ListBean<UICategoryGroup> categoryGroups() {
		ListBean<UICategoryGroup> categoryGroups = new ListBean<>();
		for (EOCategoryGroup eoCategoryGroup : this.eoCategoryGroupArray) {
			categoryGroups.add(new UICategoryGroup(eoCategoryGroup));
		}
		return categoryGroups;
	}

	@Request
	public UICategorySummary categorySummary() {
		return new UICategorySummary(this);
	}

	@Request
	public UICategory addCategory(Map<String, Object> map) {
		EOCategory categoryGroup = this.addToRel("eoCategoryArray", map);
		return new UICategory(categoryGroup);
	}

	@Request
	public UIIngrSummary ingrSummary() {
		return new UIIngrSummary(this);
	}

	@Request
	public UIIngredient addIngr(Map<String, Object> map) {
		EOIngr eoIngr = this.addToRel("eoIngrArray", map);
		return new UIIngredient(eoIngr);
	}

	
	@Request
	public UIPrepSummary prepSummary() {
		return new UIPrepSummary(this);
	}

	@Request
	public UIPreparation addPrep(Map<String, Object> map) {
		EOPrep eoIngr = this.addToRel("eoPrepArray", map);
		return new UIPreparation(eoIngr);
	}

	@Request
	public UIProductSummary productSummary() {
		return new UIProductSummary(this);
	}

	@Request
	public UIProduct addProduct(Map<String, Object> map) {
		EOProduct eoProduct = this.addToRel("eoProductArray", map);
		return new UIProduct(eoProduct);
	}

	public static void main(String[] args) {
	    MapBean<String, Object> map = new MapBean<>("uniqueID~name~idenNo~isActive~eoCategory",468,"buns","1212",false,75);
		ListBean<Map<String,Object>> countFreq=new ListBean<>();
		countFreq.add(new MapBean<>("uniqueID_ADD~eoCountFreq~isActive",0,46,false));
		countFreq.add(new MapBean<>("uniqueID_UPDATE~eoCountFreq~isActive",515,46,false));
		//countFreq.add(new MapBean<>("uniqueID_DELETE~eoCountFreq~isActive",524,46,true));
		map.put("eoIngrCountFreqArray",countFreq );
	    ListBean<Map<String,Object>>  Location=new ListBean<>();
		Location.add(new MapBean<>("uniqueID_ADD~eoLocation",0,78));
		map.put("eoIngrLocationArray",Location );
		System.out.println(map);
		EOInvApp eoInvApp = DBDataProcessor.getProcessor().findObject(EOInvApp.class, "uniqueID", 45);
		eoInvApp.updateToRel("eoIngrArray", map);
	/*	EOIngr eoIngr=DataProcessor.getProcessor().findObject(EOIngr.class, "uniqueID", 468);
		System.out.println(eoIngr);
		RelCollection collection=RelCollection.getCollection(eoIngr, "eoIngrCountFreqArray", countFreq);*/
	}
}
