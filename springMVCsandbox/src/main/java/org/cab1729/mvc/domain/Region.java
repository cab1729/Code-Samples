package org.cab1729.mvc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the REGIONS database table.
 * 
 */
@Entity
@Table(name="REGIONS")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="REGION_ID")
	private long regionId;

	@Column(name="REGION_NAME")
	private String regionName;

	//bi-directional many-to-one association to Country
	@OneToMany(mappedBy="region")
	private Set<Country> countries;

    public Region() {
    }

	public long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Set<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}
	
}