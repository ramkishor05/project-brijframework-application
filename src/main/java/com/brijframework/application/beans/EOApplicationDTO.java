package com.brijframework.application.beans;

import java.util.List;

public class EOApplicationDTO {

	private Long id;

	private String appId;

	private String appName;

	private String appLogo;

	private String appURL;

	private boolean status;

	private EOAppDetailDTO appDetail;

	private List<EOAppRoleDTO> appRoleList;

	private List<EOAppEditionDTO> appEditionList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppLogo() {
		return appLogo;
	}

	public void setAppLogo(String appLogo) {
		this.appLogo = appLogo;
	}

	public String getAppURL() {
		return appURL;
	}

	public void setAppURL(String appURL) {
		this.appURL = appURL;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public EOAppDetailDTO getAppDetail() {
		return appDetail;
	}

	public void setAppDetail(EOAppDetailDTO appDetail) {
		this.appDetail = appDetail;
	}

	public List<EOAppRoleDTO> getAppRoleList() {
		return appRoleList;
	}

	public void setAppRoleList(List<EOAppRoleDTO> appRoleList) {
		this.appRoleList = appRoleList;
	}

	public List<EOAppEditionDTO> getAppEditionList() {
		return appEditionList;
	}

	public void setAppEditionList(List<EOAppEditionDTO> appEditionList) {
		this.appEditionList = appEditionList;
	}

}
