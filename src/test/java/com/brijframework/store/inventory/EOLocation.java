package org.brijframework.store.inventory;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.brijframework.beans.DataBean;

@Entity
public class EOLocation extends DataBean{
   
	
	private static final long serialVersionUID = 1L;
	
	public String idenNo;
	public float displayOrder;
	public String name;
	
	@ManyToOne
	@JoinColumn(name="InvAppID",nullable=false)
    public EOInvApp eoInvApp;
	
	@ManyToOne
	@JoinColumn(name="StorageID",nullable=false)
	public EOStorage eoStorage;
	
	@OneToMany(mappedBy="eoLocation")
	public Set<EOIngrLocation> eoIngrLocations=new LinkedHashSet<>();
	
	@OneToMany(mappedBy="eoLocation")
	public Set<EOPrepLocation> eoPrepLocations=new LinkedHashSet<>();
	
	@OneToMany(mappedBy="eoLocation")
	public Set<EOProdLocation> eoProdLocations=new LinkedHashSet<>();
    
}
