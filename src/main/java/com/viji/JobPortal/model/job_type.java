package com.viji.JobPortal.model;

import java.sql.Date;

public class job_type {
	private int idjob_type;
	
	private String job_type;

	public int getIdjob_type() {
		return idjob_type;
	}

	@Override
	public String toString() {
		return "job_type [idjob_type=" + idjob_type + ", job_type=" + job_type + "]";
	}

	public void setIdjob_type(int idjob_type) {
		this.idjob_type = idjob_type;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	
}
