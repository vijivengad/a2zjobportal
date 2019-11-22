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
import org.springframework.stereotype.Repository;

import com.viji.JobPortal.model.admin;
import com.viji.MyJobportal.dao.admin_dao;
import com.viji.MyJobportal.dao.skillset_dao;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class admin_dao_test {

	// Declare attributes
	private static admin_dao ad_dao;
	private static int usertype;
	private static String username;
	private static String password;
	private static Boolean databaseIsOnline;
	// Create the static class variable additionClass to run the test methods

	@BeforeClass

	public static void setUp() {
	
		ad_dao = new admin_dao();
				try {

			ad_dao.testConnection();

			databaseIsOnline = true;

		} catch (Exception e) {

			databaseIsOnline = false;
		}

	    usertype = 3;
		username ="Arpita";
		password = "pass";
	}

    @Test

	public void TestB_createAdminTest() {

		assumeTrue(databaseIsOnline);
		admin ad = new admin();
		ad.setUsertyp(usertype);
		ad.setUsername(username);
		ad.setPassword(password);
		
		try {

			int i = ad_dao.createAdmin(ad);
			
			assertNotEquals(-1, i);// tests valid create product

		} catch (Exception e) {

			System.out.println("exception in createEducationDetailsTest " + e.getMessage());

		}



	}

	@Test

	public void TestD_removeAdminTest() {

		assumeTrue(databaseIsOnline);

		try {

			Boolean ret = ad_dao.removeAdmin(username);

			assertThat(ret, is(true));

		} catch (Exception e) {

			System.out.println("exception in removeAdminTest " + e.getMessage());

		}



	}

}
