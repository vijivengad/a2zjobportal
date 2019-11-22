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

import com.viji.MyJobportal.dao.skillset_dao;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)



public class skillset_daotest {

	// Declare attributes

	private static skillset_dao sk_dao;
	private static int idskillset;

	private static String skillset_name;

	private static int skillset_level;

	

	private static Boolean databaseIsOnline;



	// Create the static class variable additionClass to run the test methods

	@BeforeClass

	public static void setUp() {

		sk_dao = new skillset_dao();

		try {

			sk_dao.testConnection();

			databaseIsOnline = true;



		} catch (Exception e) {

			databaseIsOnline = false;

		}

		

		idskillset = 123;

		skillset_name = "Java";

		skillset_level = 4;

	}





	@Test

	public void TestB_createskillsetTest() {

		
		// returns -1 if unable to create product

		assumeTrue(databaseIsOnline);

		skillset ja = new skillset();

		ja.setIdskillset(idskillset);

		ja.setSkillset_level(skillset_level);

		ja.setSkillset_name(skillset_name);

		

		try {

			int i = sk_dao.createJobApply(ja);



			assertNotEquals(-1, i);// tests valid create product



		} catch (Exception e) {

			System.out.println("exception in createEducationDetailsTest " + e.getMessage());

		}



	}

	@Test

	public void TestD_removeskillsetTest() {

		assumeTrue(databaseIsOnline);

		try {

			Boolean ret = sk_dao.removeskillset(idskillset);

			assertThat(ret, is(true));

		} catch (Exception e) {

			System.out.println("exception in removeEducationDetailtTest " + e.getMessage());

		}



	}

}
