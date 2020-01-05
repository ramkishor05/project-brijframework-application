package com.brijframework.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ROLE")
public class EOAppRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "APP_ROLE_ID", nullable = false)
	private String appRoleId;

	@Column(name = "APP_ROLE_NAME", nullable = false)
	private String appRoleName;

	@Column(name = "APP_MENU_ID", nullable = false)
	private String appMenuId; // Default MenuId for all editions if not overwritten

	@Column(name = "STATUS")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "APP_ID", nullable = false)
	private EOApplication application;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAppRoleId() {
		return appRoleId;
	}

	public void setAppRoleId(String appRoleId) {
		this.appRoleId = appRoleId;
	}

	public String getAppRoleName() {
		return appRoleName;
	}

	public void setAppRoleName(String appRoleName) {
		this.appRoleName = appRoleName;
	}

	public String getAppMenuId() {
		return appMenuId;
	}

	public void setAppMenuId(String appMenuId) {
		this.appMenuId = appMenuId;
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

}
