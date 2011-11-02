package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("regionsList")
public class RegionsList extends EntityQuery<Regions> {

	private static final String EJBQL = "select regions from Regions regions";

	private static final String[] RESTRICTIONS = { "lower(regions.regionName) like lower(concat(#{regionsList.regions.regionName},'%'))", };

	private Regions regions = new Regions();

	public RegionsList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Regions getRegions() {
		return regions;
	}
}
