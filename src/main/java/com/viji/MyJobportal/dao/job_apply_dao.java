package com.viji.MyJobportal.dao;



import java.io.IOException;

import java.sql.Connection;

import java.sql.Date;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

//import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.List;



import com.viji.JobPortal.model.DatabaseConnection;

import com.viji.JobPortal.model.job_apply;



public class job_apply_dao {



	private DatabaseConnection dbc;

	private Connection conn = null;



	ArrayList<job_apply> job_apply;



	public void testConnection() throws SQLException, ClassNotFoundException, IOException {

		try {

			dbc = new DatabaseConnection();

			conn = dbc.getConnection();

			System.out.println("Connected to database.");

		} catch (SQLException | ClassNotFoundException | IOException e) {

			System.out.println(e.getMessage());

		} finally {

			if (conn != null) {

				conn.close();

			}

		}

	}



	// ****************getAllJobApplys() method*****************

	public List<job_apply> getAllDetails() throws SQLException {

		// Declare variables

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		job_apply ja = null;

		List<job_apply> jalist = null;

		// Assign query string to a variable

		String qString = "select * from job_apply";

		// Create MySqlConnection class instance

		DatabaseConnection dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try {

			// Connect to database

			conn = dbc.getConnection();

			// If the connection fails the application won't make it to this point

			System.out.println("Connected to database.");

			// Create Statement instance/object

			stmt = conn.createStatement();



			// Run query and assign to the ResultSet instance

			rs = stmt.executeQuery(qString);

			// Create list to hold User objects

			jalist = new ArrayList<job_apply>();

			// Read the ResultSet instance

			while (rs.next()) {

				// Each iteration creates a new user

				ja = new job_apply();

				// Assign columns/fields to related fields in the User object



				ja.setUser_account_id(rs.getInt(1));

				ja.setJob_post_id(rs.getInt(2));

				ja.setApply_date(rs.getDate(3));

				ja.setApplication_id(rs.getInt(4));

				jalist.add(ja);

				

			}

		} catch (ClassNotFoundException | IOException | SQLException e) {

			System.out.println("Error: " + e.getMessage());

			e.getStackTrace();

		} finally {

			if (rs != null) {

				rs.close();

			}

			if (stmt != null) {

				stmt.close();

			}

			if (conn != null) {

				conn.close();

			}

		}

		return jalist;



	}



	// ***********Create() method**************



	public Integer createJobApply(job_apply ja)

			throws SQLException, ClassNotFoundException, IOException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;



		// Assign insert statement string to variable

	

		String insertString = "insert into job_apply (user_account_id,job_post_id, apply_date,application_id) values (?,?,?,?)";



		int ID = -1;

		String[] COL = { "user_account_id" };



		DatabaseConnection dbc = new DatabaseConnection();

		System.out.println("ja"+ja);

		try {

			conn = dbc.getConnection();

			stmt = conn.prepareStatement(insertString, COL);

			stmt.setInt(1,ja.getUser_account_id());

			stmt.setInt(2, ja.getJob_post_id());

			stmt.setDate(3, ja.getApply_date());

			stmt.setInt(4, ja.getApplication_id());

			ID = stmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Error: " + e.getMessage());

		} finally {

			if (rs != null) {

				rs.close();

			}

			if (stmt != null) {

				stmt.close();

			}

			if (conn != null) {

				conn.close();

			}

		}



		return ID;

	} // End of createProduct() method



	// //****************updateJobApply() method*****************



	public Boolean updateJobApply(job_apply ja) throws SQLException, ClassNotFoundException, IOException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		Integer updateResult = null;

		// Assign update string to variable


		
		String updateString = "update job_apply "
				+ "set job_post_id= ? , apply_date = ?, application_id = ? "
				+ "where user_account_id = ?";
		
		System.out.println("updateString" +updateString);


		// Create MySqlConnection class instance DatabaseConnection

		dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try {

			// Connect to database and assign query string to PreparedStatement object

			conn = dbc.getConnection();

			stmt = conn.prepareStatement(updateString);



			// Set query parameters (?)
		stmt.setInt(1, ja.getJob_post_id());

			stmt.setDate(2, ja.getApply_date());

			stmt.setInt(3, ja.getApplication_id());

			stmt.setInt(4,ja.getUser_account_id());

			// Run query and assign to ResultSet

			updateResult = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println("Error: " + e.getMessage());

		} finally {

			if (stmt != null) {

				stmt.close();

			}

			if (conn != null) {

				conn.close();

			}

		}

		if (updateResult > 0) {

			return true;

		}

		return false;

	} // End of updateUser() method



	// ****************removeUser() method (i.e., delete)*****************



	public Boolean removeJobApply(int user_account_id) throws IOException, SQLException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		Integer updateResult = null;



		// // Assign delete string to variable

		String deleteString = "delete from job_apply where user_account_id = ?";



		// // Create MySqlConnection class instance

		DatabaseConnection dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try {

			// Connect to database and assign query string to PreparedStatement object

			conn = dbc.getConnection();

			stmt = conn.prepareStatement(deleteString);



			// Set query parameters (?)

			stmt.setInt(1, user_account_id);

			// Run query and assign to ResultSet

			updateResult = stmt.executeUpdate();

			System.out.println("updateResult"+updateResult);

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println("Error: " + e.getMessage());

		} finally {

			if (stmt != null) {

				stmt.close();

			}

			if (conn != null) {

				conn.close();

			}



		}

		if (updateResult > 0) {

			return true;

		}

		return false;

	}



	

	// End of removeUser()method



	// End of UserDAO class



	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {



		job_apply_dao ja_dao = new job_apply_dao();

		// ja_dao.testConnection();



		// List or get all products



		List<job_apply> jalist = ja_dao.getAllDetails();

		

		for (job_apply ja : jalist)



			System.out.println(ja);



		// create detail

		job_apply ja = new job_apply();

		ja.setUser_account_id(123);

		ja.setJob_post_id(1001);

		ja.setApply_date(java.sql.Date.valueOf("2010-10-23"));

		ja.setApplication_id(1234567);

		

		ja_dao.createJobApply(ja);


		// update Product
		job_apply jau= jalist.get(0); 

		jau.setApplication_id(123456);
		System.out.println(jau);
		  ja_dao.updateJobApply(jau);

		 
		// remove product
		ja_dao.removeJobApply(123);



		System.out.println("Thanks for using my jobsite");

	}



}

