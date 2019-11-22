package com.viji.JobPortal.model;

import java.sql.Date;

public class job_post {
	

	private int idjob_post;
	private int posted_by;
	private int job_role;
	private String company_name;
	private Date created_date;
	private String description;
	private int location_id;
	private String is_active;
	
	public int getIdjob_post() {
		return idjob_post;
	}
	public void setIdjob_post(int idjob_post) {
		this.idjob_post = idjob_post;
	}
	public int getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(int posted_by) {
		this.posted_by = posted_by;
	}
	public int getJob_role() {
		return job_role;
	}
	public void setJob_role(int job_type) {
		this.job_role = job_type;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	@Override
	public String toString() {
		return "job_post [idjob_post=" + idjob_post + ", posted_by=" + posted_by + ", job_role=" + job_role
				+ ", company_name=" + company_name + ", created_date=" + created_date + ", description=" + description
				+ ", location_id=" + location_id + ", is_active=" + is_active + "]";
	}
	

}
