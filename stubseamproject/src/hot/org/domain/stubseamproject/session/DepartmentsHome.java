package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("departmentsHome")
public class DepartmentsHome extends EntityHome<Departments> {

	@In(create = true)
	EmployeesHome employeesHome;
	@In(create = true)
	LocationsHome locationsHome;

	public void setDepartmentsDepartmentId(Short id) {
		setId(id);
	}

	public Short getDepartmentsDepartmentId() {
		return (Short) getId();
	}

	@Override
	protected Departments createInstance() {
		Departments departments = new Departments();
		return departments;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Employees employees = employeesHome.getDefinedInstance();
		if (employees != null) {
			getInstance().setEmployees(employees);
		}
		Locations locations = locationsHome.getDefinedInstance();
		if (locations != null) {
			getInstance().setLocations(locations);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Departments getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<JobHistory> getJobHistories() {
		return getInstance() == null ? null : new ArrayList<JobHistory>(
				getInstance().getJobHistories());
	}

	public List<Employees> getEmployeeses() {
		return getInstance() == null ? null : new ArrayList<Employees>(
				getInstance().getEmployeeses());
	}

}
