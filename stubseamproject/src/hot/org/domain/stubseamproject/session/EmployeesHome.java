package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("employeesHome")
public class EmployeesHome extends EntityHome<Employees> {

	@In(create = true)
	JobsHome jobsHome;
	@In(create = true)
	DepartmentsHome departmentsHome;
	@In(create = true)
	EmployeesHome employeesHome;

	public void setEmployeesEmployeeId(Integer id) {
		setId(id);
	}

	public Integer getEmployeesEmployeeId() {
		return (Integer) getId();
	}

	@Override
	protected Employees createInstance() {
		Employees employees = new Employees();
		return employees;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Jobs jobs = jobsHome.getDefinedInstance();
		if (jobs != null) {
			getInstance().setJobs(jobs);
		}
		Departments departments = departmentsHome.getDefinedInstance();
		if (departments != null) {
			getInstance().setDepartments(departments);
		}
	}

	public boolean isWired() {
		if (getInstance().getJobs() == null)
			return false;
		return true;
	}

	public Employees getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Employees> getEmployeeses() {
		return getInstance() == null ? null : new ArrayList<Employees>(
				getInstance().getEmployeeses());
	}

	public List<Departments> getDepartmentses() {
		return getInstance() == null ? null : new ArrayList<Departments>(
				getInstance().getDepartmentses());
	}

	public List<JobHistory> getJobHistories() {
		return getInstance() == null ? null : new ArrayList<JobHistory>(
				getInstance().getJobHistories());
	}

}
