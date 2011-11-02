package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.util.Date;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("jobHistoryHome")
public class JobHistoryHome extends EntityHome<JobHistory> {

	@In(create = true)
	EmployeesHome employeesHome;
	@In(create = true)
	JobsHome jobsHome;
	@In(create = true)
	DepartmentsHome departmentsHome;

	public void setJobHistoryId(JobHistoryId id) {
		setId(id);
	}

	public JobHistoryId getJobHistoryId() {
		return (JobHistoryId) getId();
	}

	public JobHistoryHome() {
		setJobHistoryId(new JobHistoryId());
	}

	@Override
	public boolean isIdDefined() {
		if (getJobHistoryId().getEmployeeId() == 0)
			return false;
		if (getJobHistoryId().getStartDate() == null)
			return false;
		return true;
	}

	@Override
	protected JobHistory createInstance() {
		JobHistory jobHistory = new JobHistory();
		jobHistory.setId(new JobHistoryId());
		return jobHistory;
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
		if (getInstance().getEmployees() == null)
			return false;
		if (getInstance().getJobs() == null)
			return false;
		return true;
	}

	public JobHistory getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
