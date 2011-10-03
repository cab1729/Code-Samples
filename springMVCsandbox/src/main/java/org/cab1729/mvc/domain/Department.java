package org.cab1729.mvc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTMENTS")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="MANAGER_ID")
	private java.math.BigDecimal managerId;

	//bi-directional many-to-one association to Location
    @ManyToOne
	@JoinColumn(name="LOCATION_ID")
	private Location location;

	//bi-directional many-to-one association to JobHistory
	@OneToMany(mappedBy="department")
	private Set<JobHistory> jobHistories;

    public Department() {
    }

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public java.math.BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(java.math.BigDecimal managerId) {
		this.managerId = managerId;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Set<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(Set<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}
	
}