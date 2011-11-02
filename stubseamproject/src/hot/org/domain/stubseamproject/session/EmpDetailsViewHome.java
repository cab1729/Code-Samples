package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.math.BigDecimal;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("empDetailsViewHome")
public class EmpDetailsViewHome extends EntityHome<EmpDetailsView> {

	public void setEmpDetailsViewId(EmpDetailsViewId id) {
		setId(id);
	}

	public EmpDetailsViewId getEmpDetailsViewId() {
		return (EmpDetailsViewId) getId();
	}

	public EmpDetailsViewHome() {
		setEmpDetailsViewId(new EmpDetailsViewId());
	}

	@Override
	public boolean isIdDefined() {
		if (getEmpDetailsViewId().getEmployeeId() == 0)
			return false;
		if (getEmpDetailsViewId().getJobId() == null
				|| "".equals(getEmpDetailsViewId().getJobId()))
			return false;
		if (getEmpDetailsViewId().getManagerId() == null)
			return false;
		if (getEmpDetailsViewId().getDepartmentId() == null)
			return false;
		if (getEmpDetailsViewId().getLocationId() == null)
			return false;
		if (getEmpDetailsViewId().getCountryId() == null
				|| "".equals(getEmpDetailsViewId().getCountryId()))
			return false;
		if (getEmpDetailsViewId().getFirstName() == null
				|| "".equals(getEmpDetailsViewId().getFirstName()))
			return false;
		if (getEmpDetailsViewId().getLastName() == null
				|| "".equals(getEmpDetailsViewId().getLastName()))
			return false;
		if (getEmpDetailsViewId().getSalary() == null)
			return false;
		if (getEmpDetailsViewId().getCommissionPct() == null)
			return false;
		if (getEmpDetailsViewId().getDepartmentName() == null
				|| "".equals(getEmpDetailsViewId().getDepartmentName()))
			return false;
		if (getEmpDetailsViewId().getJobTitle() == null
				|| "".equals(getEmpDetailsViewId().getJobTitle()))
			return false;
		if (getEmpDetailsViewId().getCity() == null
				|| "".equals(getEmpDetailsViewId().getCity()))
			return false;
		if (getEmpDetailsViewId().getStateProvince() == null
				|| "".equals(getEmpDetailsViewId().getStateProvince()))
			return false;
		if (getEmpDetailsViewId().getCountryName() == null
				|| "".equals(getEmpDetailsViewId().getCountryName()))
			return false;
		if (getEmpDetailsViewId().getRegionName() == null
				|| "".equals(getEmpDetailsViewId().getRegionName()))
			return false;
		return true;
	}

	@Override
	protected EmpDetailsView createInstance() {
		EmpDetailsView empDetailsView = new EmpDetailsView();
		empDetailsView.setId(new EmpDetailsViewId());
		return empDetailsView;
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

	public EmpDetailsView getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
