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
import com.viji.JobPortal.model.seeker_skillset;
import com.viji.MyJobportal.dao.education_detail_dao;
import com.viji.MyJobportal.dao.employer_dao;
import com.viji.MyJobportal.dao.seeker_dao;
import com.viji.MyJobportal.dao.seeker_skillset_dao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class seeker_skillset_daotest {
	// Declare attributes
	private static seeker_skillset_dao sek_dao;
	
	private static int idseeker_skillset;
	private static int seeker_skillset_id;
	private static int seeker_skillset_level;
	private static Boolean databaseIsOnline;

	

	// Create the static class variable additionClass to run the test methods
	@BeforeClass
	public static void setUp() {
	sek_dao = new seeker_skillset_dao();
		try {
			sek_dao.testConnection();
			databaseIsOnline = true;

		} catch (Exception e) {
			databaseIsOnline = false;
		}
		idseeker_skillset = 3456;
		seeker_skillset_id =1234;
		seeker_skillset_level =8;
	}

	@Test
	public void TestA_createSeekerSkillsetTest() {
		// returns rownum if able to create product
		// returns -1 if unable to create product
		assumeTrue(databaseIsOnline);
		seeker_skillset sek=new seeker_skillset();
		sek.setSeeker_skillset_id(seeker_skillset_id);
		sek.setIdseeker_skillset(idseeker_skillset);
		sek.setSeeker_skillset_level(seeker_skillset_level);
		
		try {
			int i = sek_dao.createSeekerSkillset(sek);
			assertNotEquals(-1, i);// tests valid create product
		} catch (Exception e) {
			System.out.println("exception in TestA_createSeekerSkillsetTest " + e.getMessage());
		}

	}


	
	@Test
	public void TestD_removeSeekerSkillsetTest() {
		assumeTrue(databaseIsOnline);
		try {
			Boolean ret = sek_dao.removeJobSeekerSkillset(idseeker_skillset);
			assertThat(ret, is(true));
		} catch (Exception e) {
			System.out.println("exception in TestD_removeSeekerSkillsetTest " + e.getMessage());
		}

	}
}


	

