package com.viji.JobPortal.model;

import java.util.Date;

public class job_location {

	@Override
	public String toString() {
		return "job_location [idjob_location=" + idjob_location + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip=" + zip + "]";
	}

	public int getIdjob_location() {
		return idjob_location;
	}

	public void setIdjob_location(int idjob_location) {
		this.idjob_location = idjob_location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	private int idjob_location;

	private String city;
	private String state;
	private String country;

	private int zip;

}
