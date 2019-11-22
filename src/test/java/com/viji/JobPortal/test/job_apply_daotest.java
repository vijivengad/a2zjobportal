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

import com.viji.MyJobportal.dao.job_apply_dao;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class job_apply_daotest {

	// Declare attributes

	private static job_apply_dao ja_dao;



	private static int user_account_id;

	private static int job_post_id;

	private static Date apply_date;

	private static int application_id;

	private static Boolean databaseIsOnline;



	// Create the static class variable additionClass to run the test methods

	@BeforeClass

	public static void setUp() {

		ja_dao = new job_apply_dao();

		try {

			ja_dao.testConnection();

			databaseIsOnline = true;



		} catch (Exception e) {

			databaseIsOnline = false;

		}

		

		user_account_id = 123;

		job_post_id = 1001;

		apply_date =java.sql.Date.valueOf("2010-10-23");

		application_id = 1234567;

		

	}



	@Test

	public void TestB_createjobapplyTest() {

		// returns rownum if able to create product

		// returns -1 if unable to create product

		assumeTrue(databaseIsOnline);

		job_apply ja = new job_apply();

		ja.setUser_account_id(user_account_id);

		ja.setApplication_id(user_account_id);

		ja.setJob_post_id(job_post_id);

		ja.setApply_date(apply_date);

		ja.setApplication_id(application_id);

		

		try {

			int i = ja_dao.createJobApply(ja);



			assertNotEquals(-1, i);// tests valid create product



		} catch (Exception e) {

			System.out.println("exception in createEducationDetailsTest " + e.getMessage());

		}



	}



	



	@Test

	public void TestD_removejobapplyTest() {

		assumeTrue(databaseIsOnline);

		try {

			Boolean ret = ja_dao.removeJobApply(user_account_id);

			assertThat(ret, is(true));

		} catch (Exception e) {

			System.out.println("exception in removeEducationDetailtTest " + e.getMessage());

		}



	}

}