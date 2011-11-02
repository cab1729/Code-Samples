package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("jobsList")
public class JobsList extends EntityQuery<Jobs> {

	private static final String EJBQL = "select jobs from Jobs jobs";

	private static final String[] RESTRICTIONS = {
			"lower(jobs.jobId) like lower(concat(#{jobsList.jobs.jobId},'%'))",
			"lower(jobs.jobTitle) like lower(concat(#{jobsList.jobs.jobTitle},'%'))", };

	private Jobs jobs = new Jobs();

	public JobsList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Jobs getJobs() {
		return jobs;
	}
}
