package org.cab1729.mvc.dao;

import java.util.List;

import org.cab1729.mvc.domain.Job;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Job> listJobs() {
		return sessionFactory.getCurrentSession()
		.createQuery("from Job")
			.list();
	}

}
