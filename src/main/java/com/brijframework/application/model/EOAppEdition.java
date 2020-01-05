package com.brijframework.application.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_EDITION")
public class EOAppEdition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "DISPLAY_ORDER")
	public double displayOrder;

	@Column(name = "DESCRIPTION")
	public String description;

	@Column(name = "RATE")
	public double monthlyRate;

	@Column(name = "PAY_DAY")
	public int startPayDay;

	@Column(name = "TRAIL")
	public boolean trail;

	@Column(name = "VERSION")
	public double version;

	@Column(name = "STATUS")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "APPLICATION_ID")
	private EOApplication application;

	@OneToMany(mappedBy = "appEdition")
	private List<EOAppFeature> appFeatureList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(double displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public int getStartPayDay() {
		return startPayDay;
	}

	public void setStartPayDay(int startPayDay) {
		this.startPayDay = startPayDay;
	}

	public boolean isTrail() {
		return trail;
	}

	public void setTrail(boolean trail) {
		this.trail = trail;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public EOApplication getApplication() {
		return application;
	}

	public void setApplication(EOApplication application) {
		this.application = application;
	}

	public List<EOAppFeature> getAppFeatureList() {
		return appFeatureList;
	}

	public void setAppFeatureList(List<EOAppFeature> appFeatureList) {
		this.appFeatureList = appFeatureList;
	}

}
