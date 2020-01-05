package com.brijframework.application.beans;

public class EOAppFeatureDTO {

	private long id;
	private String description;
	private double displayOrder;
	private String viewDetail;
	private long appEditionId;
	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getAppEditionId() {
		return appEditionId;
	}

	public void setAppEditionId(long appEditionId) {
		this.appEditionId = appEditionId;
	}
	
	

}
