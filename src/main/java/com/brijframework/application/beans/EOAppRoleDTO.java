package com.brijframework.application.beans;

public class EOAppRoleDTO {

	private long id;

	private String appRoleId;

	private String appRoleName;

	private String appMenuId;

	private long applicationId;
	
	private boolean status;

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

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
