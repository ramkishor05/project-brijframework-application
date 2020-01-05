package com.brijframework.application.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_INFO")
public class EOApplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String INVERTORY = "INVERTORY_APP";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "APP_ID")
	private String appId;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "APP_LOGO")
	private String appLogo;

	@Column(name = "APP_URL")
	private String appURL;

	@Column(name = "STATUS")
	private boolean status;

	@OneToOne
	@JoinColumn(name="APPDETAIL_ID")
	private EOAppDetail appDetail;

	@OneToMany(mappedBy = "application")
	private List<EOAppRole> appRoleList;

	@OneToMany(mappedBy = "application")
	private List<EOAppEdition> appEditionList;
	
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

	public EOAppDetail getAppDetail() {
		return appDetail;
	}

	public void setAppDetail(EOAppDetail appDetail) {
		this.appDetail = appDetail;
	}

	public List<EOAppRole> getAppRoleList() {
		return appRoleList;
	}

	public void setAppRoleList(List<EOAppRole> appRoleList) {
		this.appRoleList = appRoleList;
	}

	public List<EOAppEdition> getAppEditionList() {
		return appEditionList;
	}

	public void setAppEditionList(List<EOAppEdition> appEditionList) {
		this.appEditionList = appEditionList;
	}

	public EOAppRole appRoleForRole(String roleId) {
		for (EOAppRole appRole : this.appRoleList) {
			if (appRole.getAppRoleId().equals(roleId)) {
				return appRole;
			}
		}
		return null;
	}

	public boolean isInventory() {
		return INVERTORY.equals(this.appId);
	}
}
