package org.brijframework.lookup;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.brijframework.beans.DataBean;

@Entity
public class EOCountry extends DataBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String countryID;
	public String countryCode;
	public String countryName;
	public String shortName;
	
	@OneToOne
	@JoinColumn(name = "EOLangID", nullable = true)
	public EOLKLanguage eoLanguage;
	
	@OneToOne
	@JoinColumn(name = "EOCurrencyID", nullable = true)
	public EOCurrency  eoCurrency;
	
	@OneToOne
	@JoinColumn(name = "EOTempID", nullable = true)
	public EOTemperature eoTemperature;
	
	@ManyToOne
	@JoinColumn(name = "EOUnitGroupID", nullable = true)
	public EOLKUnitGroup eoUnitGroup; // Country uses which unit group

	
	@OneToMany(mappedBy="eoCountry" , cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	public  Set<EOState> stateArray=new LinkedHashSet<>();
}
