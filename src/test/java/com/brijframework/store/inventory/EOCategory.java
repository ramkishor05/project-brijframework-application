package org.brijframework.store.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.atn.ui.UITable;
import org.brijframework.beans.DataBean;

@Entity
@UITable(id="EOCategoryGroup",
	addFieldIDs={"categoryID","name","typeID","description","categoryGroup"},
	rowFieldIDs={"categoryID","name","typeID","description","categoryGroup"},
	mdlFieldIDs={"categoryID","name","typeID","description","categoryGroup"}
)
public  class EOCategory extends DataBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String categoryID;
	public String name;
	public String description;
	public String typeID;

	@ManyToOne
	@JoinColumn(name="InvAppID",nullable=false)
    public EOInvApp eoInvApp;
	
	@ManyToOne
	@JoinColumn(name = "CategoryGroupID",nullable=false)
	public EOCategoryGroup eoCategoryGroup;
	
}
