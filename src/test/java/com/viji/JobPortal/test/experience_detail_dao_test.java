package com.viji.JobPortal.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeTrue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.viji.JobPortal.model.experience_detail;
import com.viji.MyJobportal.dao.education_detail_dao;
import com.viji.MyJobportal.dao.employer_dao;
import com.viji.MyJobportal.dao.experience_detail_dao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class experience_detail_dao_test {
	// Declare atttibutes
	private static experience_detail_dao exp_dao;

	private static int user_account_id;
	private static String is_current_job;
	private static String job_title;
	private static String company_name;
	private static Date start_date;
	private static Date end_date;
	private static String job_city;
	private static String job_state;
	private static String job_country;
	private static Boolean databaseIsOnline;

	// Create the static class variable additionClass to run the test methods
	@BeforeClass
	public static void setUp() {
		exp_dao = new experience_detail_dao();
		try {
			exp_dao.testConnection();
			databaseIsOnline = true;

		} catch (Exception e) {
			databaseIsOnline = false;
		}
		experience_detail expdet = new experience_detail();
		user_account_id = 56;
		is_current_job = "N";
		job_title = "QA";
		company_name = "Cts";
		start_date = java.sql.Date.valueOf("2010-11-23");
		end_date = java.sql.Date.valueOf("2015-09-12");
		job_city = "LosAngeles";
		job_state = "California";
		job_country = "USA";
	}


	 @Test
	public void createExperienceDetailsTest() {
		// returns rownum if able to create product
		// returns -1 if unable to create product
		assumeTrue(databaseIsOnline);
		experience_detail exp = new experience_detail();
		exp.setUser_account_id(user_account_id);
		exp.setIs_current_job(is_current_job);
		exp.setJob_title(job_title);
		exp.setCompany_name(company_name);
		exp.setStart_date(start_date);
		exp.setEnd_date(end_date);
		exp.setJob_city(job_city);
		exp.setJob_state(job_state);
		exp.setJob_country(job_country);
		try {
			int i = exp_dao.createExperienceDetails(exp);

			assertNotEquals(-1, i);// tests valid create product

		} catch (Exception e) {
			System.out.println("exception in createExperienceDetailsTest " + e.getMessage());
		}

	}

	

	@Test
	public void removeEmployeeDetailtTest() {
		assumeTrue(databaseIsOnline);
		try {
			Boolean ret = exp_dao.removeExperienceDetail(user_account_id);
			assertThat(ret, is(true));
			experience_detail actual = exp_dao.getExperiencedetailByID(user_account_id);
			assertNull(actual);
		} catch (Exception e) {
			System.out.println("exception in removeExperienceDetailtTest " + e.getMessage());
		}

	}
}
