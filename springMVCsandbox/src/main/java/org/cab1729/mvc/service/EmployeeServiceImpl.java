package org.cab1729.mvc.service;

import java.util.List;

import org.cab1729.mvc.dao.EmployeeDAO;
import org.cab1729.mvc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);

	}

	public List<Employee> listEmployee() {
		return employeeDAO.listEmployee();
	}

	public void removeEmployee(Long id) {
		employeeDAO.removeEmployee(id);

	}

}
