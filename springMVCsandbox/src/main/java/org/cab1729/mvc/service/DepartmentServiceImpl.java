package org.cab1729.mvc.service;

import java.util.List;

import org.cab1729.mvc.domain.Department;
import org.cab1729.mvc.dao.DepartmentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	public List<Department> listDepartments() {
		
		return departmentDAO.listDeparments();
	}

}
