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

import org.brijframework.beans.DataBean;
@Entity
public  class EOState extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String stateID;
	public String stateName;
	public String stateCode;
	
	@OneToMany(mappedBy="eoState", fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	public Set<EOCity> cityArray=new LinkedHashSet<>();
	
	@ManyToOne
	@JoinColumn(name="CountryID")
	public EOCountry eoCountry;
}
