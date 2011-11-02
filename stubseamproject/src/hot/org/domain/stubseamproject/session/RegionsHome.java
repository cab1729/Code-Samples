package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("regionsHome")
public class RegionsHome extends EntityHome<Regions> {

	public void setRegionsRegionId(BigDecimal id) {
		setId(id);
	}

	public BigDecimal getRegionsRegionId() {
		return (BigDecimal) getId();
	}

	@Override
	protected Regions createInstance() {
		Regions regions = new Regions();
		return regions;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Regions getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Countries> getCountrieses() {
		return getInstance() == null ? null : new ArrayList<Countries>(
				getInstance().getCountrieses());
	}

}
