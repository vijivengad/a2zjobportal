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

import com.viji.MyJobportal.dao.job_type_dao;

import com.viji.JobPortal.model.job_type;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class job_type_dao_test {

	// Declare attributes
	private static int idjob_type;
	private static String job_type;

	private static job_type_dao job_dao;
	private static Boolean databaseIsOnline;
	// Create the static class variable additionClass to run the test methods

	@BeforeClass

	public static void setUp() {

		job_dao = new job_type_dao();
		try {
			job_dao.testConnection();

			databaseIsOnline = true;

		} catch (Exception e) {

			databaseIsOnline = false;
		}

		idjob_type = 234;
		job_type = "Sales";
	}

	@Test
	public void TestB_createJobTypeTest() {
		job_type jbtype = new job_type();
		jbtype.setIdjob_type(idjob_type);
		jbtype.setJob_type(job_type);

		try {
			int i = job_dao.createJobtype(jbtype);
			assertNotEquals(-1, i);// tests valid create product
		} catch (Exception e) {
			System.out.println("exception in TestB_createJobTypeTest " + e.getMessage());
		}
	}

	@Test
	public void TestD_removeusertypeTest() {
		assumeTrue(databaseIsOnline);
		try {
			Boolean ret = job_dao.removejobtype(idjob_type);
			assertThat(ret, is(true));
		} catch (Exception e) {
			System.out.println("exception in TestD_removeusertypeTest " + e.getMessage());
		}
	}
}
