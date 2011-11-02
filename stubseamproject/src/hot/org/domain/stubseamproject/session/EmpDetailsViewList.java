package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("empDetailsViewList")
public class EmpDetailsViewList extends EntityQuery<EmpDetailsView> {

	private static final String EJBQL = "select empDetailsView from EmpDetailsView empDetailsView";

	private static final String[] RESTRICTIONS = {
			"lower(empDetailsView.id.jobId) like lower(concat(#{empDetailsViewList.empDetailsView.id.jobId},'%'))",
			"lower(empDetailsView.id.countryId) like lower(concat(#{empDetailsViewList.empDetailsView.id.countryId},'%'))",
			"lower(empDetailsView.id.firstName) like lower(concat(#{empDetailsViewList.empDetailsView.id.firstName},'%'))",
			"lower(empDetailsView.id.lastName) like lower(concat(#{empDetailsViewList.empDetailsView.id.lastName},'%'))",
			"lower(empDetailsView.id.departmentName) like lower(concat(#{empDetailsViewList.empDetailsView.id.departmentName},'%'))",
			"lower(empDetailsView.id.jobTitle) like lower(concat(#{empDetailsViewList.empDetailsView.id.jobTitle},'%'))",
			"lower(empDetailsView.id.city) like lower(concat(#{empDetailsViewList.empDetailsView.id.city},'%'))",
			"lower(empDetailsView.id.stateProvince) like lower(concat(#{empDetailsViewList.empDetailsView.id.stateProvince},'%'))",
			"lower(empDetailsView.id.countryName) like lower(concat(#{empDetailsViewList.empDetailsView.id.countryName},'%'))",
			"lower(empDetailsView.id.regionName) like lower(concat(#{empDetailsViewList.empDetailsView.id.regionName},'%'))", };

	private EmpDetailsView empDetailsView;

	public EmpDetailsViewList() {
		empDetailsView = new EmpDetailsView();
		empDetailsView.setId(new EmpDetailsViewId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public EmpDetailsView getEmpDetailsView() {
		return empDetailsView;
	}
}
