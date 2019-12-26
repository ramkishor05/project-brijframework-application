package org.brijframework.hr;

import javax.persistence.Entity;

import org.brijframework.base.Person;
import org.brijframework.util.objects.ValidationUtil;
@Entity
public class EOUserInfo extends Person{

	/**
	 * 
	 */
	public String userID;
	
	private static final long serialVersionUID = 1L;
    public String fullName() {
    	String name="";
    	name+=this.firstName;
    	if(ValidationUtil.isValidObject(this.midName))
    	name+=" "+this.midName;
    	if(ValidationUtil.isValidObject(this.lastName))
    	name+=" "+this.lastName;
    	return name; 
    }
}
