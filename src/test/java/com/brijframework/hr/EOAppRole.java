package org.brijframework.hr;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.app.EOAppMain;
import org.brijframework.beans.DataBean;
import org.brijframework.util.objects.ValidationUtil;
import org.brijframework.web.meta.views.UIMenuMeta;
import org.brijframework.web.processor.UIMetaProcessor;


@Entity
public class EOAppRole extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public String appRoleID;
    
    public String appRoleName;
    
    public String appMenuID; // Default MenuId for all editions if not overwritten
    
    @ManyToOne
	@JoinColumn(name = "EORoleID", nullable = false)
	public EORole eoRole;

	@ManyToOne
	@JoinColumn(name = "EOAppMainID", nullable = false)
	public EOAppMain eoAppMain;
	
	
	public List<UIMenuMeta> menuArray() {
		UIMenuMeta menuMeta=UIMetaProcessor.getProcessor().getMenuMeta(appMenuID);
		if(!ValidationUtil.isValidObject(menuMeta)) {
			return new ArrayList<>();
					
		}
		return menuMeta.menuItemArray;
	}

}
