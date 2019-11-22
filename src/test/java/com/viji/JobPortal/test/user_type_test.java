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



import com.viji.JobPortal.model.skillset;
import com.viji.JobPortal.model.user_type;
import com.viji.MyJobportal.dao.skillset_dao;
import com.viji.MyJobportal.dao.user_type_dao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class user_type_test {

	// Declare attributes
	private static int id;
	private static int user_type;
	private static String user_typerole;
	private static user_type_dao use_dao;
	private static Boolean databaseIsOnline;
	// Create the static class variable additionClass to run the test methods

	@BeforeClass

	public static void setUp() {

		use_dao = new user_type_dao();
				try {

			use_dao.testConnection();

			databaseIsOnline = true;

		} catch (Exception e) {

			databaseIsOnline = false;
		}

		id = 4;
		user_type =4;
		user_typerole = "admin";
	}

    @Test

	public void TestB_createUserTypeTest() {

		assumeTrue(databaseIsOnline);

		user_type use = new user_type();
		use.setId(id);
		use.setUser_type(user_type);
		use.setUser_typerole(user_typerole);

		try {

			int i = use_dao.createUser_type(use);
			
			assertNotEquals(-1, i);// tests valid create product

		} catch (Exception e) {

			System.out.println("exception in createEducationDetailsTest " + e.getMessage());

		}



	}

	@Test

	public void TestD_removeusertypeTest() {

		assumeTrue(databaseIsOnline);

		try {

			Boolean ret = use_dao.removeuser_type(user_type);

			assertThat(ret, is(true));

		} catch (Exception e) {

			System.out.println("exception in removeEducationDetailtTest " + e.getMessage());

		}



	}

}
