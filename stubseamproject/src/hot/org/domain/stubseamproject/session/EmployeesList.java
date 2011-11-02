package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("employeesList")
public class EmployeesList extends EntityQuery<Employees> {

	private static final String EJBQL = "select employees from Employees employees";

	private static final String[] RESTRICTIONS = {
			"lower(employees.firstName) like lower(concat(#{employeesList.employees.firstName},'%'))",
			"lower(employees.lastName) like lower(concat(#{employeesList.employees.lastName},'%'))",
			"lower(employees.email) like lower(concat(#{employeesList.employees.email},'%'))",
			"lower(employees.phoneNumber) like lower(concat(#{employeesList.employees.phoneNumber},'%'))", };

	private Employees employees = new Employees();

	public EmployeesList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Employees getEmployees() {
		return employees;
	}
}
