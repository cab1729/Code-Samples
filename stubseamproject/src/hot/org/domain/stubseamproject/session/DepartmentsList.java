package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("departmentsList")
public class DepartmentsList extends EntityQuery<Departments> {

	private static final String EJBQL = "select departments from Departments departments";

	private static final String[] RESTRICTIONS = { "lower(departments.departmentName) like lower(concat(#{departmentsList.departments.departmentName},'%'))", };

	private Departments departments = new Departments();

	public DepartmentsList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Departments getDepartments() {
		return departments;
	}
}
