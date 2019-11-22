package com.viji.JobPortal.model;

import java.sql.Date;

public class job_post_skill_set {
	
	private int idjob_post_skill_set;
	
	private int job_post_id;
	private int job_post_skill_level;
	public int getIdjob_post_skill_set() {
		return idjob_post_skill_set;
	}
	public void setIdjob_post_skill_set(int idjob_post_skill_set) {
		this.idjob_post_skill_set = idjob_post_skill_set;
	}
	public int getJob_post_id() {
		return job_post_id;
	}
	public void setJob_post_id(int job_post_id) {
		this.job_post_id = job_post_id;
	}
	public int getJob_post_skill_level() {
		return job_post_skill_level;
	}
	public void setJob_post_skill_level(int job_post_skill_level) {
		this.job_post_skill_level = job_post_skill_level;
	}
	@Override
	public String toString() {
		return "job_post_skill_set [idjob_post_skill_set=" + idjob_post_skill_set + ", job_post_id=" + job_post_id
				+ ", job_post_skill_level=" + job_post_skill_level + "]";
	}
	

}
