package com.viji.JobPortal.model;

import java.util.Date;
//import java.sql.Date;

public class employer {

	private int idemployer;
	private int usertypeid;
	private String company_name;
	private String profile;
	private String website;
	private String email;
	private String username;
	private String password;

	public int getIdemployer() {
		return idemployer;
	}

	public void setIdemployer(int idemployer) {
		this.idemployer = idemployer;
	}

	public int getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	@Override
	public String toString() {
		return "employer [idemployer=" + idemployer + ", usertypeid=" + usertypeid + ", company_name=" + company_name
				+ ", profile=" + profile + ", website=" + website + ", email=" + email + ", username=" + username
				+ ", password=" + password + "]";
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
