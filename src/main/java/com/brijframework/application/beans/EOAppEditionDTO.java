package com.brijframework.application.beans;

import java.util.List;

public class EOAppEditionDTO {

	private long id;

	public double displayOrder;

	public String description;

	public double monthlyRate;

	public int startPayDay;

	public boolean trail;

	public double version;

	private boolean status;

	private List<EOAppFeatureDTO> appFeatureList;

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

	public List<EOAppFeatureDTO> getAppFeatureList() {
		return appFeatureList;
	}

	public void setAppFeatureList(List<EOAppFeatureDTO> appFeatureList) {
		this.appFeatureList = appFeatureList;
	}

}
