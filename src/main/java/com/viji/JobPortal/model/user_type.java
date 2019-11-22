package com.viji.JobPortal.model;

public class user_type {

	private int id;
	private int user_type;
	private String user_typerole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "user_type [id=" + id + ", user_type=" + user_type + "]";
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getUser_typerole() {
		return user_typerole;
	}

	public void setUser_typerole(String user_typerole) {
		this.user_typerole = user_typerole;
	}

}
