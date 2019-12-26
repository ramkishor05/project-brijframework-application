package org.brijframework.hr;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.brijframework.app.EOAppMain;
import org.brijframework.app.EOCustomer;
import org.brijframework.atn.svcs.Request;
import org.brijframework.beans.DataBean;
import org.brijframework.beans.collection.MapBean;
import org.brijframework.constants.CFC;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.db.processor.DBDataProcessor;
import org.brijframework.user.Role;
import org.brijframework.web.container.WebMetaContainer;
import org.brijframework.web.meta.views.UIMenuMeta;

@Entity
@DBEntity(isGlobal=true)
public class EOCustRole extends DataBean implements Role {
	/**
	 * 
	 */
	public static final String OWER_ROLE = "OWNER";
	private static final long serialVersionUID = 1L;
	public String custRoleID;
	public String description;
	public boolean isCustomRole;
	public boolean isReadOnlyAccess;
	public boolean allowMobileLogin;

	@ManyToOne
	@JoinColumn(name = "EORoleID", nullable = false)
	public EORole eoRole;
	
	@ManyToOne
	@JoinColumn(name = "EOCustomerID")
	public EOCustomer eoCustomer;

	@OneToMany(mappedBy = "eoCustRole")
	public Set<EOCustUser> eoCustUserArray = new LinkedHashSet<>();

	@Override
	public Object roleID() {
		return this.uniqueID;
	}

	@Override
	public boolean canDoAction(String actionID) {
		return false;
	}

	@Request
	public UIMenuMeta menuForUser(MapBean<String, Object> map) {
		EOAppMain eoAppMain = DBDataProcessor.getProcessor().findObject(EOAppMain.class, "uniqueID", map.longValue("appID"));
		EOAppRole appRole = eoAppMain.appRoleForRole(this.eoRole);
		if (appRole == null) {
			return null;
		}
		UIMenuMeta menuMeta = WebMetaContainer.getContainer().getObject(CFC.MENU_HASH, appRole.appMenuID);
		return menuMeta;
	}

	public static void main(String[] args) {
		EOCustRole custRole = DBDataProcessor.getProcessor().getObject(EOCustRole.class, 26);
		UIMenuMeta menuMeta = custRole.menuForUser(new MapBean<>("appID", 4));
		System.out.println(menuMeta.map());
	}
}
