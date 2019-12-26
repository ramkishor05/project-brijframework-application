package org.brijframework.hr;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.brijframework.beans.DetailBean;
import org.brijframework.user.UserDetail;

@Entity
public class EOUserDetail extends DetailBean implements UserDetail{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String userID;
	@Transient
	public boolean isAdmin;
	@Transient
	public boolean isManager;
	@Transient
	public boolean isUser;
	@Transient
	public boolean isSupplier;
	@Transient
	public boolean isOwener;
	@Transient
	public boolean isTeam;
	@Transient
	public String recoverID;
	@Transient
	public String securityCode;
	@Transient
	public Boolean isRemember;
	@Transient
	public Timestamp loggedInTime;
	@Transient
	public Timestamp lastAccessTime;
	@Transient
	public String remoteAddress;
	@Transient
	public String remoteHost;
	
	@Override
	public Timestamp getLoggedInTime() {
		return loggedInTime;
	}
	@Override
	public void setLoggedInTime(Timestamp loggedInTime) {
		this.loggedInTime = loggedInTime;
	}
	@Override
	public Timestamp getLastAccessTime() {
		return lastAccessTime;
	}
	@Override
	public void setLastAccessTime(Timestamp lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	@Override
	public String getRemoteAddress() {
		return remoteAddress;
	}
	@Override
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
	@Override
	public String getRemoteHost() {
		return remoteHost;
	}
	@Override
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	
	
}
