package com.viji.JobPortal.model;

import java.util.Date;

public class experience_detail {
	
	private int user_account_id;
	private String is_current_job;
	private String job_title;
	private String company_name;
	private Date start_date;
	private Date end_date;
	private String job_city;
	private String job_state;
	private String job_country;
	@Override
	public String toString() {
		return "experience_detail [user_account_id=" + user_account_id + ", is_current_job=" + is_current_job
				+ ", job_title=" + job_title + ", company_name=" + company_name + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", job_city=" + job_city + ", job_state=" + job_state + ", job_country="
				+ job_country + "]";
	}
	public int getUser_account_id() {
		return user_account_id;
	}
	public void setUser_account_id(int user_account_id) {
		this.user_account_id = user_account_id;
	}
	public String getIs_current_job() {
		return is_current_job;
	}
	public void setIs_current_job(String is_current_job) {
		this.is_current_job = is_current_job;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getJob_city() {
		return job_city;
	}
	public void setJob_city(String job_city) {
		this.job_city = job_city;
	}
	public String getJob_state() {
		return job_state;
	}
	public void setJob_state(String job_state) {
		this.job_state = job_state;
	}
	public String getJob_country() {
		return job_country;
	}
	public void setJob_country(String job_country) {
		this.job_country = job_country;
	}
	
}
