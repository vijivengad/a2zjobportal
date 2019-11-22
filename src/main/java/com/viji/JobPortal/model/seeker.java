package com.viji.JobPortal.model;

//import java.util.Date;
import java.sql.Date;

public class seeker {
	private int id;
	private int user_type_id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private Date date_of_birth;
	private String gender;
	private String contact_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_type_id() {
		return user_type_id;
	}

	public void setUser_type_id(int user_type_id) {
		this.user_type_id = user_type_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	@Override
	public String toString() {
		return "seeker [id=" + id + ", user_type_id=" + user_type_id + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", date_of_birth=" + date_of_birth + ", gender=" + gender + ", contact_number=" + contact_number
				+ "]";
	}


	

}
