package com.viji.JobPortal.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.viji.JobPortal.dao.JobSearchDao;
import com.viji.JobPortal.entity.JobPost;


@Controller
public class JobportalController {
	

	
	/*@Autowired
	JobSearchDao jobsearchdao;*/
	
	@GetMapping("/")
	public String showIndexPage(Model model) throws SQLException {
		return "Index";
	}
	
	

	@PostMapping("/jobsearchresult")
		public String jobsearchresults(Model model){
		return "jobsearchresult";
	}
	
	/*@RequestMapping(value = "/searchjobs", method = RequestMethod.GET)
	public String searchJobs(
			@RequestParam("role") String role,
			@RequestParam("location_city") String location_city,
			@RequestParam("location_state") String location_state, Model model) {
		
		List<?> jp = jobsearchdao.searchJobs(role, location_city, location_state);
		
		model.addAttribute("jobs", jp);
		
		return "jobsearch";
	}*/
	
	
	
}