package org.brijframework.hr;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.brijframework.app.EOCustomer;
import org.brijframework.atn.auth.Session;
import org.brijframework.atn.bean.Properties;
import org.brijframework.atn.ui.UIField;
import org.brijframework.beans.DataBean;
import org.brijframework.constants.TypeID;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.user.Role;
import org.brijframework.user.SessionUser;

@Entity
@DBEntity(isGlobal=true)
@Session(validator = "validPassword", interval = 60.0, validateKeys = { "username", "password" }, redirectURL = "/landing", uniqueKeys = { "username" })
public class EOCustUser extends DataBean implements SessionUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@UIField(id = "EOCustUser_username", label = "Email ID", typeID = TypeID.EMAIL, isRequired = true, message = "Email must be fill")
	public String username;

	@UIField(id = "EOCustUser_password", label = "Password", typeID = TypeID.PASSWORD, isRequired = true, message = "Password must be fill")
	public String password;

	@UIField(id = "EOCustUser_rememberme", label = "Remember me", typeID = TypeID.SWITCH, isDisabled = true, message = "Rememberme must be set")
	public boolean rememberme;

	public String sessionID;

	@ManyToOne
	@JoinColumn(name = "CustRoleID")
	@Properties
	public EOCustRole eoCustRole;

	@ManyToOne
	@Properties
	@JoinColumn(name = "CustomerID")
	public EOCustomer eoCustomer;

	@OneToMany(mappedBy = "eoCustUser")
	public Set<EONotification> eoNotificationArray = new LinkedHashSet<>();

	@Override
	public Role role() {
		return this.eoCustRole;
	}

	@Override
	public boolean validPassword(Object password, Object... oobj) {
		return false;
	}

	@Override
	public Object setPassword(Object password) {
		return null;
	}

	@Override
	public Object getPassword() {
		return null;
	}

	@Override
	public String userInfo() {
		return null;
	}

	@Override
	public Object userID() {
		return this.uniqueID;
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
