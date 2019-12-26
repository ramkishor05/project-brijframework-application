package org.brijframework.lookup;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.brijframework.beans.DataBean;
@Entity
public class EOCity extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String cityID;
	public String cityName;
	public String cityCode;
	
	@OneToMany(mappedBy="eoCity", fetch=FetchType.LAZY, cascade=javax.persistence.CascadeType.MERGE)
	public Set<EOAddress> addressArray=new LinkedHashSet<>();
	
	@ManyToOne
	@JoinColumn( name="StateID")
	public EOState eoState;
}
