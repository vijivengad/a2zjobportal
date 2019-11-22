


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

import com.viji.JobPortal.model.job_post;
import com.viji.MyJobportal.dao.job_post_dao;


	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public class job_post_dao_test {

		// Declare attributes

		private static job_post_dao job_dao;



		private static int idjob_post;

		private static int postedby;

		private static int job_type;

		private static String companyname;
		
		private static Date created_date;
		private static String description;
		private static int location_id;
		private static String is_active;

		private static Boolean databaseIsOnline;



		// Create the static class variable additionClass to run the test methods

		@BeforeClass

		public static void setUp() {

			job_dao = new job_post_dao();

			try {

				job_dao.testConnection();

				databaseIsOnline = true;



			} catch (Exception e) {

				databaseIsOnline = false;

			}
			idjob_post = 123;
			postedby= 1001;
			job_type= 123;
			companyname= "CTS";
			created_date= java.sql.Date.valueOf("2010-10-23");
			description="This is description";
			location_id= 100;
			is_active= "Y";
	
		}



		@Test

		public void TestB_createjobpostTest() {

			// returns rownum if able to create product

			// returns -1 if unable to create product

			assumeTrue(databaseIsOnline);

			job_post jp = new job_post();
			jp.setIdjob_post(idjob_post);
			jp.setPosted_by(postedby);
			jp.setJob_role(job_type);
			jp.setCompany_name(companyname);
			jp.setCreated_date(created_date);
			jp.setDescription(description);
			jp.setLocation_id(location_id);
			jp.setIs_active(is_active);
		
			try {

				int i = job_dao.createJobPostDetails(jp);



				assertNotEquals(-1, i);// tests valid create product



			} catch (Exception e) {

				System.out.println("exception in createJobDetailsTest " + e.getMessage());

			}



		}



		@Test

		public void TestD_removejobpostTest() {

			assumeTrue(databaseIsOnline);

			try {

				Boolean ret = job_dao.removeJobPostDetails(idjob_post);

				assertThat(ret, is(true));

			} catch (Exception e) {

				System.out.println("exception in removejobpostTest " + e.getMessage());

			}



		}

	}


