package com.brijframework.application.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="APP_FEATURE")
public class EOAppFeature implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DISPLAY_ORDER")
	private double displayOrder;
	
	@Column(name="VIEW_DETAIL")
	private String viewDetail;
	
	@OneToMany(mappedBy="appFeature")
	private List<EOAppEdition> appEditions;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(double displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getViewDetail() {
		return viewDetail;
	}

	public void setViewDetail(String viewDetail) {
		this.viewDetail = viewDetail;
	}

	public List<EOAppEdition> getAppEditions() {
		return appEditions;
	}

	public void setAppEditions(List<EOAppEdition> appEditions) {
		this.appEditions = appEditions;
	}
	
	
}
