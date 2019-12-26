package org.brijframework.lookup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.brijframework.atn.ui.UILookup;
import org.brijframework.atn.ui.UITable;
import org.brijframework.beans.DataBean;

@Entity
@UITable(id="EODepartment")
@UILookup(displayKey="deptName")
public  class EODepartment extends DataBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String deptID;
	public String deptName;
}
