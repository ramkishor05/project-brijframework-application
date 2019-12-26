package org.brijframework.controller;

import java.util.Map;

import org.brijframework.app.EOCustomer;
import org.brijframework.app.beans.Messager;
import org.brijframework.atn.svcs.Controller;
import org.brijframework.atn.svcs.Request;
import org.brijframework.atn.ui.UIAction;
import org.brijframework.atn.ui.UISection;
import org.brijframework.atn.ui.UISectionGroup;
import org.brijframework.beans.collection.MapBean;
import org.brijframework.constants.RequestAccess;
import org.brijframework.constants.TypeID;
import org.brijframework.db.processor.DBDataProcessor;
import org.brijframework.hr.EOCustRole;
import org.brijframework.hr.EOCustUser;
import org.brijframework.util.objects.ValidationUtil;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.web.beans.LoginBean;

@UISectionGroup(id = "UserController", sections = {
		@UISection(id = "UserController_login", name = "Brij Market Login", discreption = "Login for use my app", fieldIDs = {
				"EOUser_username", "EOUser_password", "EOUser_rememberme" }, actionIDs = { "UserController_login",
						"UserController_forgotPassword", "UserController_signuplink" }),
		@UISection(id = "UserController_signup", name = "Brij Market Registration", discreption = "Registration for use my app", fieldIDs = {
				"EOUser_firstName", "EOUser_username",
				"EOUser_password" }, actionIDs = { "UserController_signup", "UserController_loginLink" }) })

@Controller
public class UserController extends LoginBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Request(access = { RequestAccess.PERMISSION })
	@UIAction(typeID = TypeID.SUBMIT, label = "Login")
	public Object login(Map<String, Object> map) {
		EOCustUser user = InstanceUtil.getInstance(EOCustUser.class, map);
		return this.doLogin(user);
	}

	@Request(access = RequestAccess.PERMISSION)
	@UIAction(typeID = TypeID.LINK, label = "signup")
	public Object signupLink(Map<String, Object> map) {
		return "";
	}

	@Request(access = RequestAccess.PERMISSION)
	@UIAction(typeID = TypeID.LINK, label = "login")
	public Object loginLink(Map<String, Object> map) {
		return "";
	}

	@Request(access = RequestAccess.PERMISSION)
	@UIAction(typeID = TypeID.SUBMIT, label = "Sign up")
	public Object signup(Map<String, Object> map) {
		if (!ValidationUtil.isValidObject(map)) {
			Messager.infoMessage("Please user init ");
			return this.finalRespose();
		}
		String firstName = (String) map.remove("firstName");
		String lastName = (String) map.remove("lastName");
		EOCustUser user = InstanceUtil.getInstance(EOCustUser.class, map);
		if (this.isExitsObject(user)) {
			Messager.infoMessage("User allready exists");
			return this.finalRespose();
		}
		MapBean<String, Object> bean = new MapBean<>("firstName~lastName", firstName, lastName);
		EOCustomer customer = DBDataProcessor.getProcessor().addObject(EOCustomer.class, bean);
		user.eoCustomer = customer;
		user.eoCustRole = DBDataProcessor.getProcessor().findObject(EOCustRole.class, "custRoleID", EOCustRole.OWER_ROLE);
		this.doSignup(user);
		return this.finalRespose();
	}

	@Override
	public Map<String, Object> sucessRespose() {
		MapBean<String, Object> bean = new MapBean<String, Object>();
		if (ValidationUtil.isValidObject(this.sessionUser)) {
			bean.setProperty("roleID", this.sessionUser.role().roleID());
			bean.setProperty("user", this.sessionUser);
		}
		bean.setProperty("redirectURL", "/userLanding");
		return bean;
	}

	@Override
	public Map<String, Object> errorRespose() {
		return new MapBean<String, Object>("redirectURL", "/");
	}

	@Override
	public Map<String, Object> seletedObject() {
		MapBean<String, Object> bean = new MapBean<>();
		if (this.sessionUser != null) {
			bean.setProperty("userID", this.sessionUser.userID());
			bean.setProperty("sessionID", this.sessionUser.getSessionID());
			if (this.sessionUser.role() != null) {
				bean.setProperty("roleID", this.sessionUser.role().roleID());
			}
			if (this.sessionUser instanceof EOCustUser) {
				EOCustUser eoCustUser = (EOCustUser) this.sessionUser;
				bean.setProperty("customerID", eoCustUser.eoCustomer.getUniqueID());
				bean.setProperty("roleID", eoCustUser.eoCustRole.roleID());
			}
		}
		return bean;
	}

}
