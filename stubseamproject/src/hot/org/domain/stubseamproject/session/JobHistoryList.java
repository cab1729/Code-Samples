package org.domain.stubseamproject.session;

import org.domain.stubseamproject.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("jobHistoryList")
public class JobHistoryList extends EntityQuery<JobHistory> {

	private static final String EJBQL = "select jobHistory from JobHistory jobHistory";

	private static final String[] RESTRICTIONS = {};

	private JobHistory jobHistory;

	public JobHistoryList() {
		jobHistory = new JobHistory();
		jobHistory.setId(new JobHistoryId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public JobHistory getJobHistory() {
		return jobHistory;
	}
}
