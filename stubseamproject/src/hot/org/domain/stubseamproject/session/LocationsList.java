package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("locationsList")
public class LocationsList extends EntityQuery<Locations> {

	private static final String EJBQL = "select locations from Locations locations";

	private static final String[] RESTRICTIONS = {
			"lower(locations.streetAddress) like lower(concat(#{locationsList.locations.streetAddress},'%'))",
			"lower(locations.postalCode) like lower(concat(#{locationsList.locations.postalCode},'%'))",
			"lower(locations.city) like lower(concat(#{locationsList.locations.city},'%'))",
			"lower(locations.stateProvince) like lower(concat(#{locationsList.locations.stateProvince},'%'))", };

	private Locations locations = new Locations();

	public LocationsList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Locations getLocations() {
		return locations;
	}
}
