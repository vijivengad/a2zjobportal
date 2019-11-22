package com.viji.JobPortal.model;

import java.sql.Date;

public class skillset {
	
	private int idskillset;

	private String skillset_name;
	private int skillset_level;
	public int getIdskillset() {
		return idskillset;
	}
	public void setIdskillset(int idskillset) {
		this.idskillset = idskillset;
	}
	public String getSkillset_name() {
		return skillset_name;
	}
	public void setSkillset_name(String skillset_name) {
		this.skillset_name = skillset_name;
	}
	public int getSkillset_level() {
		return skillset_level;
	}
	public void setSkillset_level(int skillset_level) {
		this.skillset_level = skillset_level;
	}
	@Override
	public String toString() {
		return "skillset [idskillset=" + idskillset + ", skillset_name=" + skillset_name + ", skillset_level="
				+ skillset_level + "]";
	}
	
}
