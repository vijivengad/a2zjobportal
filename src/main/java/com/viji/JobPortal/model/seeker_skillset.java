package com.viji.JobPortal.model;

import java.sql.Date;

public class seeker_skillset {
	
	private int idseeker_skillset;
	private int seeker_skillset_id;
	private int seeker_skillset_level;
	public int getIdseeker_skillset() {
		return idseeker_skillset;
		
	}
	@Override
	public String toString() {
		return "seeker_skillset [idseeker_skillset=" + idseeker_skillset + ", seeker_skillset_id=" + seeker_skillset_id
				+ ", seeker_skillset_level=" + seeker_skillset_level + "]";
	}
	public void setIdseeker_skillset(int idseeker_skillset) {
		this.idseeker_skillset = idseeker_skillset;
	}
	public int getSeeker_skillset_id() {
		return seeker_skillset_id;
	}
	public void setSeeker_skillset_id(int seeker_skillset_id) {
		this.seeker_skillset_id = seeker_skillset_id;
	}
	public int getSeeker_skillset_level() {
		return seeker_skillset_level;
	}
	public void setSeeker_skillset_level(int seeker_skillset_level) {
		this.seeker_skillset_level = seeker_skillset_level;
	}
	

}
