package com.brijframework.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APP_DETAIL")
public class EOAppDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="DISPLAY_ORDER")
	private double displayOrder;
	
	@Column(name="INTERNAL_HOST")
	private String internalHost;
	
	@Column(name="EXTERNAL_HOST")
	private String externalHost;
	
	@Column(name="INTERNAL_PORT")
	private String internalPort;
	
	@Column(name="EXTERNAL_PORT")
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
