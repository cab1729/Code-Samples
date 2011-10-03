package org.cab1729.mvc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JOB_HISTORY database table.
 * 
 */
@Entity
@Table(name="JOB_HISTORY")
public class JobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobHistoryPK id;

    @Temporal( TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	//bi-directional many-to-one association to Department
    @ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Job
    @ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

    public JobHistory() {
    }

	public JobHistoryPK getId() {
		return this.id;
	}

	public void setId(JobHistoryPK id) {
		this.id = id;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
}