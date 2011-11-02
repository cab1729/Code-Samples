package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("countriesHome")
public class CountriesHome extends EntityHome<Countries> {

	@In(create = true)
	RegionsHome regionsHome;

	public void setCountriesCountryId(String id) {
		setId(id);
	}

	public String getCountriesCountryId() {
		return (String) getId();
	}

	@Override
	protected Countries createInstance() {
		Countries countries = new Countries();
		return countries;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Regions regions = regionsHome.getDefinedInstance();
		if (regions != null) {
			getInstance().setRegions(regions);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Countries getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Locations> getLocationses() {
		return getInstance() == null ? null : new ArrayList<Locations>(
				getInstance().getLocationses());
	}

}
