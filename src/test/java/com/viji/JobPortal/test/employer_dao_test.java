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

import com.viji.JobPortal.model.employer;
import com.viji.MyJobportal.dao.education_detail_dao;
import com.viji.MyJobportal.dao.employer_dao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class employer_dao_test {
	// Declare atttibutes
	private static employer_dao emp_dao;
	
	private static int idemployer;
	private static int usertypeid;
	private static String company_name;
	private static String profile;
	private static String website;
	private static String email;
	private static String username;
	private static String password;

	private static Boolean databaseIsOnline;

	// Create the static class variable additionClass to run the test methods
	@BeforeClass
	public static void setUp() {
		emp_dao = new employer_dao();
		try {
			emp_dao.testConnection();
			databaseIsOnline = true;

		} catch (Exception e) {
			databaseIsOnline = false;
		}
		employer emp = new employer();
		idemployer = 5681;
		usertypeid = 2;
		company_name = "Cts";
		profile = "dffhhh";
		
		website= "saddff";
		email = "bala23@yahoo.com";
		username = "asdkl";
		password  = "adghjj";
		
	}

	

	

	@Test
	public void Test_createEducationDetailsTest() {
		// returns rownum if able to create product
		// returns -1 if unable to create product
		assumeTrue(databaseIsOnline);
		employer emp= new employer();
		emp.setIdemployer(idemployer);
		emp.setUsertypeid(usertypeid);
		emp.setCompany_name(company_name);
		emp.setProfile(profile);
		emp.setWebsite(website);
		emp.setEmail(email);
		emp.setUsername(username);
		emp.setPassword(password);
		
		
		try {
			int i = emp_dao.createEmployeeDetails(emp);

			assertNotEquals(-1, i);// tests valid create product

		} catch (Exception e) {
			System.out.println("exception in createEmployeeDetailsTest " + e.getMessage());
		}

	}


/*	@Test
	public void TestC_updateEducationDetailTest() {
		assumeTrue(databaseIsOnline);
		try {
			education_detail expected = ed_dao.getEduDetailsByID(568);
			expected.setDegree_name("MHRM");
			
			Boolean ret = ed_dao.updateEducationDetail(expected);
			education_detail actual =ed_dao.getEduDetailsByID(568);
			assertThat(ret, is(true));
			
			assertNotNull(actual);
			assertThat("MHRM", is(actual.getDegree_name()));
		} catch (Exception e) {
			System.out.println("exception in updateEducationDetailTest " + e.getMessage());
		}

	}*/

	@Test
	public void TestD_removeEmployeeDetailtTest() {
		assumeTrue(databaseIsOnline);
		try {
			Boolean ret = emp_dao.removeEmployerDetail(idemployer);
			assertThat(ret, is(true));
			employer actual = emp_dao.getEmployeeByID(idemployer);
			assertNull(actual);
		} catch (Exception e) {
			System.out.println("exception in removeEmployeeDetailtTest " + e.getMessage());
		}

	}
}


	

