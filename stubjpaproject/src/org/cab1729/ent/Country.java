package org.cab1729.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the COUNTRIES database table.
 * 
 */
@Entity
@Table(name="COUNTRIES")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="COUNTRY_ID")
	private String countryId;

	@Column(name="COUNTRY_NAME")
	private String countryName;

	//bi-directional many-to-one association to Region
    @ManyToOne
	@JoinColumn(name="REGION_ID")
	private Region region;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="country")
	private Set<Location> locations;

    public Country() {
    }

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	public Set<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	
}