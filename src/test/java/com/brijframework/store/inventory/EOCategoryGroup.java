package org.brijframework.store.inventory;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.brijframework.atn.svcs.Request;
import org.brijframework.atn.ui.UILookup;
import org.brijframework.atn.ui.UITable;
import org.brijframework.beans.DataBean;
import org.brijframework.store.inventory.ui.UICategory;

@Entity
@UITable(id="EOCategoryGroup",
addFieldIDs={"categoryID","name","typeID","description"},
rowFieldIDs={"categoryID","name","typeID","description"},
mdlFieldIDs={"categoryID","name","typeID","description"}
)
@UILookup(description="Categories",displayKey="description", uitype="lookup", id="EOCategories",name="category")
public class EOCategoryGroup extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String categoryID;
	public String name;
	public String description;
	public String typeID;
	
	@ManyToOne
	@JoinColumn(name="InvAppID",nullable=false)
    public EOInvApp eoInvApp;
	
	@OneToMany(mappedBy="eoCategoryGroup")
	public Set<EOCategory> eoCategoryArray=new LinkedHashSet<>();
	
	@Request
	public UICategory addCategory(Map<String,Object> map){
		map.put("eoCategoryGroup", this);
		map.put("eoInvApp", eoInvApp);
		EOCategory eoCategory= this.addToRel("eoCategoryArray", map);
		return new UICategory(eoCategory);
	}
}
