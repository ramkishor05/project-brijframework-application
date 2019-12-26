package com.brijframework.application.entities;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private EOAppDetail appDetail;

	@OneToOne
	private EOAppEdition appEdition;

	@OneToMany(mappedBy = "application", fetch = FetchType.EAGER)
	private Set<EOAppRole> appRoleArray = new LinkedHashSet<>();

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appID) {
		this.appId = appID;
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

	public EOAppEdition getAppEdition() {
		return appEdition;
	}

	public void setAppEdition(EOAppEdition appEdition) {
		this.appEdition = appEdition;
	}

	public Set<EOAppRole> getAppRoleArray() {
		return appRoleArray;
	}

	public void setAppRoleArray(Set<EOAppRole> appRoleArray) {
		this.appRoleArray = appRoleArray;
	}

	public EOAppRole appRoleForRole(String roleId) {
		for (EOAppRole appRole : this.appRoleArray) {
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
