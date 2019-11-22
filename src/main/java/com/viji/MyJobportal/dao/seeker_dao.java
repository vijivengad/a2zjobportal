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

import com.viji.JobPortal.model.seeker;

public class seeker_dao {

	private DatabaseConnection dbc;

	private Connection conn = null;



	ArrayList<seeker> seekerlist;

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

	public List<seeker> getAllDetails() throws SQLException {

		// Declare variables

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		seeker seeker = null;

		List<seeker> seekerlist = null;

		// Assign query string to a variable

		String qString = "select * from seeker";

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

			seekerlist = new ArrayList<seeker>();

			// Read the ResultSet instance

			while (rs.next()) {

				// Each iteration creates a new user

				seeker = new seeker();
				// Assign columns/fields to related fields in the User object

				seeker.setId(rs.getInt(1));
				seeker.setUser_type_id(rs.getInt(2));
				seeker.setFirstname(rs.getString(3));
				seeker.setLastname(rs.getString(4));
				seeker.setEmail(rs.getString(5));
				seeker.setUsername(rs.getString(6));
				seeker.setPassword(rs.getString(7));
				seeker.setDate_of_birth(rs.getDate(8));
				seeker.setGender(rs.getString(9));
				seeker.setContact_number(rs.getString(10));
				seekerlist.add(seeker);
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

		return seekerlist;



	}



	// ***********Create() method**************



	public Integer createJobSeeker(seeker se)

			throws SQLException, ClassNotFoundException, IOException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;



		// Assign insert statement string to variable

	

		String insertString = "insert into seeker (idseeker,usertypeid, firstname,lastname,email, username, password, date_of_birth, gender, contactno) values (?,?,?,?,?,?,?,?,?,?)";

		int ID = -1;

		String[] COL = { "user_account_id" };

		DatabaseConnection dbc = new DatabaseConnection();
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setInt(1,se.getId());
			stmt.setInt(2, se.getUser_type_id());
			stmt.setString(3, se.getFirstname());
			stmt.setString(4, se.getLastname());
			stmt.setString(5, se.getEmail());
			stmt.setString(6, se.getUsername());
			stmt.setString(7, se.getPassword());
			stmt.setDate(8, se.getDate_of_birth());
			stmt.setString(9, se.getGender());
			stmt.setString(10, se.getContact_number());

			

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



	public Boolean updateJobSeeker(seeker se) throws SQLException, ClassNotFoundException, IOException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		Integer updateResult = null;

		// Assign update string to variable

		String updateString = "update seeker "

				+ "set  firstname = ?,lastname  = ?,email = ?, username = ?, password = ?, date_of_birth = ?, gender = ?, contactno = ? "

				+ "where idseeker = ?";
		
		System.out.println(updateString);


		// Create MySqlConnection class instance DatabaseConnection

		dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try {

			// Connect to database and assign query string to PreparedStatement object

			conn = dbc.getConnection();

			stmt = conn.prepareStatement(updateString);


			// Set query parameters (?)

			stmt.setString(1, se.getFirstname());

			stmt.setString(2, se.getLastname());

			stmt.setString(3, se.getEmail());

			stmt.setString(4, se.getUsername());

			stmt.setString(5, se.getPassword());

			stmt.setDate(6,se.getDate_of_birth());

			stmt.setString(7, se.getGender());

			stmt.setString(8, se.getContact_number());

			stmt.setInt(9,se.getId());

			

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



	public Boolean removeJobSeeker(int idseeker) throws IOException, SQLException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		Integer updateResult = null;



		// // Assign delete string to variable

		String deleteString = "delete from seeker where idseeker = ?";



		// // Create MySqlConnection class instance

		DatabaseConnection dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try {

			// Connect to database and assign query string to PreparedStatement object

			conn = dbc.getConnection();

			stmt = conn.prepareStatement(deleteString);



			// Set query parameters (?)

			stmt.setInt(1, idseeker);

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


	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {



		seeker_dao se_dao = new seeker_dao();

		// se_dao.testConnection();



		// List or get all products



		List<seeker> seekerlist = se_dao.getAllDetails();

		

		for (seeker se : seekerlist)

			System.out.println(se);



		// create detail

		seeker se = new seeker();

		se.setId(100);

		se.setUser_type_id(2);

		se.setFirstname("Sam");

		se.setLastname("Walton");

		se.setPassword("pass");
		se.setEmail("sam@walton.com");
		se.setUsername("samwalton");
		se.setPassword("sam");

		se.setDate_of_birth(java.sql.Date.valueOf("2010-10-23"));

		se.setGender("F");

		se.setContact_number("4056748345");

	

		se_dao.createJobSeeker(se);

		// update Product
		seeker seu= seekerlist.get(0); 
		seu.setLastname("Jobs");
		System.out.println(seu);
		se_dao.updateJobSeeker(seu);
		// remove product

		se_dao.removeJobSeeker(100);

		System.out.println("Thanks for using my jobsite");

	}



}

