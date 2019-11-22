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

import com.viji.JobPortal.model.seeker;
import com.viji.MyJobportal.dao.education_detail_dao;
import com.viji.MyJobportal.dao.employer_dao;
import com.viji.MyJobportal.dao.seeker_dao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class seeker_dao_test {
	// Declare atttibutes
	private static seeker_dao sek_dao;
	
	private static int idseeker;
	private static int usertypeid;
	private static String firstname;
	private static String lastname;
	
	private static String email;
	private static String username;
	private static String password;
	private static java.sql.Date date_of_birth;
	private static String gender;
	private static String website;
	private static String contactno;
	private static Boolean databaseIsOnline;

	

	// Create the static class variable additionClass to run the test methods
	@BeforeClass
	public static void setUp() {
	sek_dao = new seeker_dao();
		try {
			sek_dao.testConnection();
			databaseIsOnline = true;

		} catch (Exception e) {
			databaseIsOnline = false;
		}
		seeker sek = new seeker();
		idseeker =1234;
		
		usertypeid = 2;
		firstname = "Deepali";
		lastname="Shah";
	   email = "deepa123@yahoo.com";
		username = "deepa12";
		password  = "adghjj";
		
		date_of_birth=java.sql.Date.valueOf("1981-10-12");
		gender="F";
	 contactno = "345892466";
		
	}

	

	

	@Test
	public void TestA_createSeekerDetailsTest() {
		// returns rownum if able to create product
		// returns -1 if unable to create product
		assumeTrue(databaseIsOnline);
		seeker sek=new seeker();
		sek.setId(idseeker);
		sek.setUser_type_id(usertypeid);
		sek.setFirstname(firstname);
		sek.setLastname(lastname);
		sek.setEmail(email);
		sek.setUsername(username);
		sek.setPassword(password);
		sek.setDate_of_birth(date_of_birth);
		sek.setGender(gender);
		sek.setContact_number(contactno);
		
		
		try {
			int i = sek_dao.createJobSeeker(sek);

			assertNotEquals(-1, i);// tests valid create product

		} catch (Exception e) {
			System.out.println("exception in createEmployeeDetailsTest " + e.getMessage());
		}

	}


	
	@Test
	public void TestD_removeJobSeekerDetailtTest() {
		assumeTrue(databaseIsOnline);
		try {
			Boolean ret = sek_dao.removeJobSeeker(idseeker);
			assertThat(ret, is(true));
		} catch (Exception e) {
			System.out.println("exception in removeEmployeeDetailtTest " + e.getMessage());
		}

	}
}


	

