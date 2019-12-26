package org.brijframework.app;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.brijframework.beans.DataBean;
import org.brijframework.db.annotation.DBEntity;
import org.brijframework.db.annotation.DBUniqueKeys;
import org.brijframework.lookup.EOAddress;
import org.brijframework.web.container.WebMetaContainer;

@Entity
@DBEntity(isGlobal=true,uniques={@DBUniqueKeys(id="name",columnNames="name")})
public class EOSiteMain extends DataBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String description;
	public String name;

	@ManyToOne
	@JoinColumn(name = "EOAddressID")
	public EOAddress eoAddress;

	@ManyToOne
	@JoinColumn(name = "EOSiteDetailID")
	public EOSiteDetail siteDetail;

	@ManyToOne
	@JoinColumn(name = "EOCustConceptID")
	public EOCustConcept eoCustConcept;

	public static void main(String[] args) {
		//WebApplication application = WebApplication.getApplication();
		/*String pageParams = "{\"actionMap\":{\"requestID\":\"ComponentContainer_metaData\",isMetaData:true}}";
		System.out.println(pageParams);
		System.out.println(new WebAuthenticationService().postRequest(pageParams));*/
		WebMetaContainer.getContainer();
		//System.out.println(new UITableMeta(EOSiteMain.class).printFullGraph());
		//System.out.println(DataProcessor.getProcessor().getAllObject(EOCustUser.class));
		//System.out.println(ModelBuilder.getBuilder(ComponentContainer.getContainer().getCache()).printGraph());
	}
	
}
