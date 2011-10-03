package org.cab1729.mvc.service;

import java.util.List;

import org.cab1729.mvc.domain.Job;
import org.cab1729.mvc.dao.JobDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;
	
	public List<Job> listJobs() {
		
		return jobDAO.listJobs();
	}

}
