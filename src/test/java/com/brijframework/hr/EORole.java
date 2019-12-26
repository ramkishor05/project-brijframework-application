package org.brijframework.hr;

import javax.persistence.Entity;

import org.brijframework.beans.DataBean;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.db.processor.DBDataProcessor;
import org.brijframework.user.Role;

@Entity
@DBEntity(isGlobal=true)
public class EORole extends DataBean implements Role{

	private static final long serialVersionUID = 1L;
	
    public int position;
	public String roleName;
	public String roleID;
	
	@Override
	public boolean canDoAction(String actionID) {
		return false;
	}

	@Override
	public Object roleID() {
		return roleID;
	}

	public static EORole roleObject(UIRole uiRole){
		return	DBDataProcessor.getProcessor().findObject(EORole.class, "roleID", uiRole.toString());
	}
	
}

