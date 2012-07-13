package org.cab1729.osgi.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cab1729.osgi.entity.Employee;

public class GetEmpInfo implements IGetEmpInfo {
	
	@PersistenceContext(unitName="osgiservice")
	EntityManager em;

	@Override
	public String getEmpEmail(long id) {
		String email;
		try {
			Employee employee = em.find(Employee.class, Long.valueOf(id)); 
			email = employee.getEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			email = "NOT FOUND/ERROR";
		} 
		return email;
	}

}
