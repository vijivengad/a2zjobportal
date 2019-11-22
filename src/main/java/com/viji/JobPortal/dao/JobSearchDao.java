package com.viji.JobPortal.dao;

import java.util.List;




public interface JobSearchDao {
	public List<?>  searchJobs(String skill, String location_city, String location_state);
	
}
