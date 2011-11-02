package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("countriesList")
public class CountriesList extends EntityQuery<Countries> {

	private static final String EJBQL = "select countries from Countries countries";

	private static final String[] RESTRICTIONS = {
			"lower(countries.countryId) like lower(concat(#{countriesList.countries.countryId},'%'))",
			"lower(countries.countryName) like lower(concat(#{countriesList.countries.countryName},'%'))", };

	private Countries countries = new Countries();

	public CountriesList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Countries getCountries() {
		return countries;
	}
}
