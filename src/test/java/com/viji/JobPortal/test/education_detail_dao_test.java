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

import com.viji.JobPortal.model.education_detail;
import com.viji.MyJobportal.dao.education_detail_dao;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class education_detail_dao_test {
	// Declare atttibutes
	private static education_detail_dao ed_dao;

	private static int user_account_id;
	private static String degree_name;
	private static String major;
	private static String university;
	private static Date start_date;
	private static Date completion_date;
	private static Double cgpa;
	private static Blob resume;
	private static Boolean databaseIsOnline;

	// Create the static class variable additionClass to run the test methods
	@BeforeClass
	public static void setUp() {
		ed_dao = new education_detail_dao();
		try {
			ed_dao.testConnection();
			databaseIsOnline = true;

		} catch (Exception e) {
			databaseIsOnline = false;
		}
		education_detail ed = new education_detail();
		user_account_id = 56;
		degree_name = "MBBS";
		major = "General";
		university = "Texas";
		
		start_date= java.sql.Date.valueOf("2010-10-23");
		completion_date = java.sql.Date.valueOf("2015-08-12");
		cgpa = 3.2;
		String res = "adghjj";
		try {
			resume = new SerialBlob(res.getBytes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			ed_dao.createEducationDetails(ed);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	

	@Test
	public void TestA_getAllDetailsTest() throws ClassNotFoundException, SQLException, IOException {
		assumeTrue(databaseIsOnline);


		List<education_detail> actual = ed_dao.getAllDetails();
		System.out.println("actual size" + actual.size());
		System.out.println(actual);
		assertEquals(3, actual.size());

	}

	@Test
	public void TestB_createEducationDetailsTest() {
		// returns rownum if able to create product
		// returns -1 if unable to create product
		assumeTrue(databaseIsOnline);
		education_detail eddetail = new education_detail();
		eddetail.setUser_account_id(user_account_id);
		eddetail.setDegree_name(degree_name);
		eddetail.setMajor(major);
		eddetail.setUniversity(university);
		eddetail.setStart_date(start_date);
		eddetail.setCompletion_date(completion_date);
		eddetail.setCgpa(cgpa);
		eddetail.setResume(resume);
		try {
			int i = ed_dao.createEducationDetails(eddetail);

			assertNotEquals(-1, i);// tests valid create product

		} catch (Exception e) {
			System.out.println("exception in createEducationDetailsTest " + e.getMessage());
		}

	}


	@Test
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

	}

	@Test
	public void TestD_removeEducationDetailtTest() {
		assumeTrue(databaseIsOnline);
		try {
			Boolean ret = ed_dao.removeEducationDetail(user_account_id);
			assertThat(ret, is(true));
			education_detail actual = ed_dao.getEduDetailsByID(user_account_id);
			assertNull(actual);
		} catch (Exception e) {
			System.out.println("exception in removeEducationDetailtTest " + e.getMessage());
		}

	}
}
