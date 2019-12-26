package org.brijframework.hr;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.brijframework.app.EOCustomer;
import org.brijframework.atn.auth.Session;
import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.svcs.Request;
import org.brijframework.atn.ui.UIAction;
import org.brijframework.atn.ui.UIField;
import org.brijframework.beans.DataBean;
import org.brijframework.constants.RequestAccess;
import org.brijframework.constants.TypeID;
import org.brijframework.user.Role;
import org.brijframework.user.SessionUser;

@Entity
@Session(validator = "validPassword", interval = 2.0, validateKeys = { "username", "password" }, redirectURL = "/landing", uniqueKeys = { "username" })
public class EOUser extends DataBean implements SessionUser {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@UIField(id = "EOUser_username", label = "Email ID", typeID = TypeID.EMAIL, isRequired = true, message = "Email must be fill")
	public String username;

	@UIField(id = "EOUser_password", label = "Password", typeID = TypeID.PASSWORD, isRequired = true, message = "Password must be fill")
	public String password;

	@UIField(id = "EOUser_rememberme", label = "Remember me", typeID = TypeID.SWITCH, isDisabled = true, message = "Rememberme must be set")
	public boolean rememberme;

	public String sessionID;

	@OneToOne
	@JoinColumn(name = "UserRole")
	@Properties
	public EORole eoRole;
	
	@OneToOne
	@JoinColumn(name = "UserDetail")
	public EOUserDetail eoUserDetail;

	@OneToOne
	@JoinColumn(name = "UserInfo")
	public EOUserInfo eoUserInfo;

	@ManyToOne
	@JoinColumn(name = "CustomerID")
	public EOCustomer eoCustomer;

	@Request(access = RequestAccess.API)
	@UIAction(typeID = TypeID.LINK, label = "forgot password")
	public Object forgotPassword(Map<?, ?> map) {
		return null;
	}

	@Override
	public Object userID() {
		return this.uniqueID;
	}

	@Override
	public Role role() {
		return this.eoRole;
	}

	@Override
	public boolean validPassword(Object password, Object... arg) {
		return false;
	}

	@Override
	public Object getPassword() {
		return this.password;
	}

	@Override
	public Object setPassword(Object params) {
		return null;
	}

	@Override
	public String userInfo() {
		return null;
	}

	@Override
	public Object getSessionID() {
		return this.sessionID;
	}

	@Override
	public Object setSessionID(Object sessionID) {
		this.sessionID = new String("" + sessionID);
		return this.sessionID;
	}
}
