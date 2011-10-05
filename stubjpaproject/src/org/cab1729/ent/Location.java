package org.cab1729.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="LOCATION_ID")
	private long locationId;

	private String city;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy="location")
	private Set<Department> departments;

	//bi-directional many-to-one association to Country
    @ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

    public Location() {
    }

	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
	
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}