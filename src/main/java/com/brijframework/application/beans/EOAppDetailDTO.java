package com.brijframework.application.beans;

public class EOAppDetailDTO {

	private long id;
	private double displayOrder;
	private String internalHost;
	private String externalHost;
	private String internalPort;
	private String externalPort;

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

	public String getInternalHost() {
		return internalHost;
	}

	public void setInternalHost(String internalHost) {
		this.internalHost = internalHost;
	}

	public String getExternalHost() {
		return externalHost;
	}

	public void setExternalHost(String externalHost) {
		this.externalHost = externalHost;
	}

	public String getInternalPort() {
		return internalPort;
	}

	public void setInternalPort(String internalPort) {
		this.internalPort = internalPort;
	}

	public String getExternalPort() {
		return externalPort;
	}

	public void setExternalPort(String externalPort) {
		this.externalPort = externalPort;
	}

}
