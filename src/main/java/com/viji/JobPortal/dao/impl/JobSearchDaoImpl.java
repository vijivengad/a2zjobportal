package com.viji.JobPortal.dao.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viji.JobPortal.dao.JobSearchDao;

/*@Repository
@Transactional
@Service*/
public class JobSearchDaoImpl implements JobSearchDao{

	/*@PersistenceContext
	private EntityManager entityManager;*/
	
	@Override
	public List<?> searchJobs(String role, String location_city, String location_state){
		/*String selectQuery = "SELECT jobId, posted_by,company_name, description,  is_active FROM JobPost jp WHERE role =:role AND location_city =:location_city AND location_state =:location_state";
		Query query = entityManager.createQuery(selectQuery);
		List<?> jpList = query.getResultList();
		return jpList;*/
		return null;
	}
	
}
