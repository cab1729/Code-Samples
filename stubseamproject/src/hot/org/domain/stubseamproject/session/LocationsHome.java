package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("locationsHome")
public class LocationsHome extends EntityHome<Locations> {

	@In(create = true)
	CountriesHome countriesHome;

	public void setLocationsLocationId(Short id) {
		setId(id);
	}

	public Short getLocationsLocationId() {
		return (Short) getId();
	}

	@Override
	protected Locations createInstance() {
		Locations locations = new Locations();
		return locations;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Countries countries = countriesHome.getDefinedInstance();
		if (countries != null) {
			getInstance().setCountries(countries);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Locations getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Departments> getDepartmentses() {
		return getInstance() == null ? null : new ArrayList<Departments>(
				getInstance().getDepartmentses());
	}

}
