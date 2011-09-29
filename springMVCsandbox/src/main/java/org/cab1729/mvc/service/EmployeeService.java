package org.cab1729.mvc.service;

import java.util.List;

import org.cab1729.mvc.domain.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	public List<Employee> listEmployee();
	public void removeEmployee(Long id);

}
