package org.domain.stubseamproject.entity;

// Generated Oct 7, 2011 3:55:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.NotNull;

/**
 * JobHistory generated by hbm2java
 */
@Entity
@Table(name = "JOB_HISTORY")
public class JobHistory implements java.io.Serializable {

	private JobHistoryId id;
	private Employees employees;
	private Jobs jobs;
	private Departments departments;
	private Date endDate;

	public JobHistory() {
	}

	public JobHistory(JobHistoryId id, Employees employees, Jobs jobs,
			Date endDate) {
		this.id = id;
		this.employees = employees;
		this.jobs = jobs;
		this.endDate = endDate;
	}

	public JobHistory(JobHistoryId id, Employees employees, Jobs jobs,
			Departments departments, Date endDate) {
		this.id = id;
		this.employees = employees;
		this.jobs = jobs;
		this.departments = departments;
		this.endDate = endDate;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "employeeId", column = @Column(name = "EMPLOYEE_ID", nullable = false, precision = 6, scale = 0)),
			@AttributeOverride(name = "startDate", column = @Column(name = "START_DATE", nullable = false, length = 7, columnDefinition="DATE")) })
	@NotNull
	public JobHistoryId getId() {
		return this.id;
	}

	public void setId(JobHistoryId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_ID", nullable = false)
	@NotNull
	public Jobs getJobs() {
		return this.jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE", nullable = false, length = 7, columnDefinition="DATE")
	@NotNull
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
