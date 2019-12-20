package com.brijframework.application.entities;

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
@Table(name="APP_ROLE")
public class EOAppRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name = "APP_ROLE_ID", nullable = false)
	private String appRoleID;
    
    @Column(name = "APP_ROLE_NAME", nullable = false)
    private String appRoleName;
    
    @Column(name = "APP_MENU_ID", nullable = false)
    private String appMenuID; // Default MenuId for all editions if not overwritten
    
	@ManyToOne
	@JoinColumn(name = "APP_ID", nullable = false)
	private EOApplication application;

	public String getAppRoleID() {
		return appRoleID;
	}

	public void setAppRoleID(String appRoleID) {
		this.appRoleID = appRoleID;
	}

	public String getAppRoleName() {
		return appRoleName;
	}

	public void setAppRoleName(String appRoleName) {
		this.appRoleName = appRoleName;
	}

	public String getAppMenuID() {
		return appMenuID;
	}

	public void setAppMenuID(String appMenuID) {
		this.appMenuID = appMenuID;
	}

	public EOApplication getApplication() {
		return application;
	}

	public void setApplication(EOApplication application) {
		this.application = application;
	}
	
	
	
}
