package org.brijframework.store.ordering;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

import org.brijframework.atn.ui.UITable;
import org.brijframework.beans.DataBean;
@Entity
@UITable(id="EOOrderHistory_001",rowFieldIDs= {"eoOrder","orderHisID","orderHisDate"})
public class EOOrderHistory extends DataBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String orderHisID;
	public Date orderHisDate;
	
	@Lob
	public EOOrder eoOrder;
}
