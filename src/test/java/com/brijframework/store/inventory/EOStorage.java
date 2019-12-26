package org.brijframework.store.inventory;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.brijframework.atn.svcs.Request;
import org.brijframework.beans.DataBean;
import org.brijframework.beans.collection.ListBean;
import org.brijframework.store.inventory.ui.UILocation;

@Entity
public class EOStorage extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     
	public String id;
	public float displayOrder;
	public String name;
	
	@ManyToOne
	@JoinColumn(name="InvAppID",nullable=false)
    public EOInvApp eoInvApp;
	
	@OneToMany(mappedBy="eoStorage")
	public Set<EOLocation> eoLocationArray=new LinkedHashSet<>();
	
	@Request
	public UILocation addLocation(Map<String,Object> map){
		map.put("eoStorage", this);
		map.put("eoInvApp", this.eoInvApp);
		EOLocation eoLocation= this.addToRel("eoLocationArray", map);
		return new UILocation(eoLocation);
	}
	
	@Request
	public ListBean<UILocation> getLocations(){
		ListBean<UILocation> locations=new ListBean<>();
		for(EOLocation eoLocation: eoLocationArray){
			locations.add(new UILocation(eoLocation));
		}
		return locations;
	} 
}
