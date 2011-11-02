package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("jobsHome")
public class JobsHome extends EntityHome<Jobs> {

	public void setJobsJobId(String id) {
		setId(id);
	}

	public String getJobsJobId() {
		return (String) getId();
	}

	@Override
	protected Jobs createInstance() {
		Jobs jobs = new Jobs();
		return jobs;
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

	public Jobs getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Employees> getEmployeeses() {
		return getInstance() == null ? null : new ArrayList<Employees>(
				getInstance().getEmployeeses());
	}

	public List<JobHistory> getJobHistories() {
		return getInstance() == null ? null : new ArrayList<JobHistory>(
				getInstance().getJobHistories());
	}

}
