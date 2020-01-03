package com.brijframework.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EOLKUnitConversion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	private Double baseQnt;
	
	private Double rptQnt;
	
	private String typeId;
	
	@OneToOne
	@JoinColumn(name = "BASE_UNIT_ID", nullable = false)
	private EOLKUnit baseUnit;
	
	@OneToOne
	@JoinColumn(name = "RPT_UNIT_ID", nullable = false)
	private EOLKUnit rptUnit;

	public Double getBaseQnt() {
		return baseQnt;
	}

	public void setBaseQnt(Double baseQnt) {
		this.baseQnt = baseQnt;
	}

	public Double getRptQnt() {
		return rptQnt;
	}

	public void setRptQnt(Double rptQnt) {
		this.rptQnt = rptQnt;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public EOLKUnit getBaseUnit() {
		return baseUnit;
	}

	public void setBaseUnit(EOLKUnit baseUnit) {
		this.baseUnit = baseUnit;
	}

	public EOLKUnit getRptUnit() {
		return rptUnit;
	}

	public void setRptUnit(EOLKUnit rptUnit) {
		this.rptUnit = rptUnit;
	}
	
	
}
