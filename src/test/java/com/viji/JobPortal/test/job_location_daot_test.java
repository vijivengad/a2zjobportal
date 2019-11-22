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

import java.sql.Date;

import java.util.List;



import org.junit.BeforeClass;

import org.junit.FixMethodOrder;

import org.junit.Test;

import org.junit.runners.MethodSorters;



import com.viji.JobPortal.model.job_apply;
import com.viji.JobPortal.model.job_location;
import com.viji.MyJobportal.dao.job_apply_dao;
import com.viji.MyJobportal.dao.job_location_dao;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class job_location_daot_test {

	// Declare attributes

	private static job_location_dao ja_dao;



	private static int idjob_location;

	private static String city;

	private static String state;

	private static String contry;
	
	private static int zip;

	private static Boolean databaseIsOnline;



	// Create the static class variable additionClass to run the test methods

	@BeforeClass

	public static void setUp() {

		ja_dao = new job_location_dao();

		try {

			ja_dao.testConnection();

			databaseIsOnline = true;



		} catch (Exception e) {

			databaseIsOnline = false;

		}

		

		idjob_location = 123;

		city = "California";

		state ="CA";

		contry = "USA";

		zip = 93063;

	}



	@Test

	public void TestB_createjoblocationTest() {

		// returns rownum if able to create product

		// returns -1 if unable to create product

		assumeTrue(databaseIsOnline);

		job_location ja = new job_location();
		
		ja.setIdjob_location(idjob_location);
		ja.setCity(city);
		ja.setState(state);
		ja.setCountry(contry);
		ja.setZip(zip);
	
		try {

			int i = ja_dao.createJobLocationDetails(ja);



			assertNotEquals(-1, i);// tests valid create product



		} catch (Exception e) {

			System.out.println("exception in createJobDetailsTest " + e.getMessage());

		}



	}



	@Test

	public void TestD_removejoblocationTest() {

		assumeTrue(databaseIsOnline);

		try {

			Boolean ret = ja_dao.removeJobLocationDetails(idjob_location);

			assertThat(ret, is(true));

		} catch (Exception e) {

			System.out.println("exception in removejoblocationTest " + e.getMessage());

		}



	}

}