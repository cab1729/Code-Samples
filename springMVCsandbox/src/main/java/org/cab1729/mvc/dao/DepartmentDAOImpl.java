package org.cab1729.mvc.dao;

import java.util.List;

import org.cab1729.mvc.domain.Department;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Department> listDeparments() {
		return sessionFactory.getCurrentSession()
		.createQuery("from Department")
			.list();
	}

}
