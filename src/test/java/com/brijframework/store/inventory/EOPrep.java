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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idenNo"})})
public class EOPrep extends EOItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public double qnt;
	
	@ManyToOne
	@JoinColumn(name="InvAppID")
    public EOInvApp eoInvApp;
	
	@OneToOne
	@JoinColumn(name="imgID",nullable=true)
	public EOImgDetail eoImgDetail;
	
	@OneToMany(mappedBy="eoPrep")
	public Set<EOPrepLocation> eoPrepLocationArray=new LinkedHashSet<>();
	
	@OneToMany(mappedBy="eoPrep")
	public Set<EOPrepCountFreq> eoPrepCountFreqArray=new LinkedHashSet<>();
	
	@OneToMany(mappedBy="eoPrep")
	public Set<EORecipe> eoRecipeArray=new LinkedHashSet<>();

	public String logURL(){
		   return this.eoImgDetail!=null ?this.eoImgDetail.url:"";
		}
		
	
}
