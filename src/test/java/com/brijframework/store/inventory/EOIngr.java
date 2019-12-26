package org.brijframework.store.inventory;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.brijframework.atn.svcs.Request;
import org.brijframework.store.inventory.ui.UIIngredient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idenNo"})})
public class EOIngr extends EOItem{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="InvAppID",nullable=false)
    public EOInvApp eoInvApp;
	
	@OneToOne
	@JoinColumn(name="imgID",nullable=true)
	public EOImgDetail eoImgDetail;
	
	@OneToOne
	@JoinColumn(name="BaseUnitID",nullable=true)
	public EOInvUnit eoBaseUnit;
	
	@OneToOne
	@JoinColumn(name="RptUnitID",nullable=true)
	public EOInvUnit eoRptUnit;
	
	@OneToOne
	@JoinColumn(name="CategoryID",nullable=false)
	public EOCategory eoCategory;		
	
	@OneToMany(mappedBy="eoIngr")
	public Set<EOIngrLocation> eoIngrLocationArray=new LinkedHashSet<>();
	
	@OneToMany(mappedBy="eoIngr")
	public Set<EOIngrCountFreq> eoIngrCountFreqArray=new LinkedHashSet<>();
	
	public String logURL(){
	   return this.eoImgDetail!=null ?this.eoImgDetail.url:"";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T preCreate() {
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T preDelete() {
		return (T) this;
	}
	
	@Request
	public UIIngredient ingredient(){
		UIIngredient ingredient=new UIIngredient(this);
		ingredient.fillDetail();
		return ingredient;
	}

	
}
