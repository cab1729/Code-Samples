package org.cab1729.mvc.dao;

import java.util.List;
import org.cab1729.mvc.domain.Employee;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);

	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		return sessionFactory.getCurrentSession()
			.createQuery("from Employee")
				.list();
	}

	public void removeEmployee(Long id) {
		Employee employee = 
			(Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
		if (null != employee) {
			sessionFactory.getCurrentSession().delete(employee);
		}
	}
	
}
