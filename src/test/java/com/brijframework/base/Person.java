package org.brijframework.base;

import java.sql.Date;

import javax.persistence.MappedSuperclass;

import org.brijframework.atn.ui.UIField;
import org.brijframework.beans.DataBean;
import org.brijframework.constants.TypeID;

@MappedSuperclass
public abstract class Person extends DataBean{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@UIField(message = "firstName", typeID = TypeID.TEXT)
	public String firstName;
	@UIField(message = "firstName", typeID = TypeID.TEXT)
    public String midName;
	@UIField(message = "firstName", typeID = TypeID.TEXT)
    public String lastName;
	@UIField(message = "firstName", typeID = TypeID.NUMBER)
    public int age;
	@UIField(message = "dob", typeID = TypeID.DATE)
    public Date dob;
	@UIField(message = "gender", typeID = TypeID.TEXT)
    public String gender;
}
