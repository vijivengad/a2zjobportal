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

import com.viji.JobPortal.model.job_post_skill_set;
import com.viji.MyJobportal.dao.job_post_skill_set_dao;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class job_post_skillsetdaotest {

	// Declare attributes
	private static job_post_skill_set_dao job_ss_dao;

	private static int idjob_post_skill_set;
	private static int job_post_id;
	private static int job_post_skill_level;
	private static Boolean databaseIsOnline;

	// Create the static class variable additionClass to run the test methods
	@BeforeClass
	public static void setUp() {
		job_ss_dao = new job_post_skill_set_dao();
		try 
		{
			job_ss_dao.testConnection();
			databaseIsOnline = true;
		} catch (Exception e) {
			databaseIsOnline = false;
		}
		idjob_post_skill_set = 1234;
		job_post_id= 1001;
		job_post_skill_level = 4;
	}

	@Test
	public void TestB_createJobPostSkillDetailsTest() {

		// returns rownum if able to create product
		// returns -1 if unable to create product
		assumeTrue(databaseIsOnline);
		job_post_skill_set jpss = new job_post_skill_set();
		
		jpss.setIdjob_post_skill_set(idjob_post_skill_set);
		jpss.setJob_post_id(job_post_id);
		jpss.setJob_post_skill_level(job_post_skill_level);
		
		try
		{

			int i = job_ss_dao.createJobPostSkillDetails(jpss);
			assertNotEquals(-1, i);// tests valid create product
		}
		catch (Exception e)
		{
			System.out.println("exception in createJobDetailsTest " + e.getMessage());
		}
	}

	@Test
	public void TestD_removeJobSkillPostDetailsTest() {
		assumeTrue(databaseIsOnline);
		try {

			Boolean ret = job_ss_dao.removeJobSkillPostDetails(idjob_post_skill_set);
			assertThat(ret, is(true));

		} 
		catch (Exception e) {

			System.out.println("exception in removejobpostTest " + e.getMessage());
		}
	}
}
