package org.cab1729.mvc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the JOBS database table.
 * 
 */
@Entity
@Table(name="JOBS")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="JOB_ID")
	private String jobId;

	@Column(name="JOB_TITLE")
	private String jobTitle;

	@Column(name="MAX_SALARY")
	private BigDecimal maxSalary;

	@Column(name="MIN_SALARY")
	private BigDecimal minSalary;

	//bi-directional many-to-one association to JobHistory
	@OneToMany(mappedBy="job")
	private Set<JobHistory> jobHistories;

    public Job() {
    }

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	public BigDecimal getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public Set<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(Set<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}
	
}