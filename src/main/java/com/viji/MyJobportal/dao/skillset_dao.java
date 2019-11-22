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

import com.viji.JobPortal.model.skillset;

import com.viji.JobPortal.model.skillset;



public class skillset_dao {



	private DatabaseConnection dbc;

	private Connection conn = null;



	ArrayList<skillset> sk;



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

	public List<skillset> getAllDetails() throws SQLException {

		// Declare variables

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		skillset sk = null;

		List<skillset> sklist = null;

		// Assign query string to a variable

		String qString = "select * from skillset";

		// Create MySqlConnection class instance

		DatabaseConnection dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try 
		{

			// Connect to database
			conn = dbc.getConnection();

			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();
			// Run query and assign to the ResultSet instance
			rs = stmt.executeQuery(qString);
			// Create list to hold User objects
			sklist = new ArrayList<skillset> ();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				sk = new skillset();
				// Assign columns/fields to related fields in the User object
			    sk.setIdskillset(rs.getInt(1));
				sk.setSkillset_name(rs.getString(2));
				sk.setSkillset_level(rs.getInt(3));
				sklist.add(sk);
			}
		} 
		catch (ClassNotFoundException | IOException | SQLException e) 
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();

		} 
		finally 
		{
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
		return sklist;
	}

	// ***********Create() method**************
	public Integer createJobApply(skillset sk)
			throws SQLException, ClassNotFoundException, IOException {

		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into skillset (idskillset,skillset_level, skillset_name) values (?,?,?)";

		int ID = -1;
		String[] COL = { "idskillset" };
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,sk.getIdskillset());
			stmt.setInt(2, sk.getSkillset_level());
			stmt.setString(3, sk.getSkillset_name());
			ID = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (rs != null) {
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
	public Boolean updateskillset(skillset sk) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "update skillset "
				+ "set skillset_level= ? , skillset_name = ? "
				+ "where idskillset = ?";

		// Create MySqlConnection class instance DatabaseConnection
		dbc = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(updateString);
			// Set query parameters (?)
			stmt.setInt(1, sk.getSkillset_level());
			stmt.setString(2, sk.getSkillset_name());
			stmt.setInt(3,sk.getIdskillset());
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

	public Boolean removeskillset(int idskillset) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// // Assign delete string to variable

		String deleteString = "delete from skillset where idskillset = ?";
		// // Create MySqlConnection class instance
		DatabaseConnection dbc = new DatabaseConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();

			stmt = conn.prepareStatement(deleteString);



			// Set query parameters (?)

			stmt.setInt(1, idskillset);

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
		skillset_dao sk_dao = new skillset_dao();
		// ja_dao.testConnection();
		// List or get all products
		List<skillset> sklist = sk_dao.getAllDetails();
		for (skillset skl : sklist)
			System.out.println(skl);

		// create detail
		skillset sk = new skillset();
		sk.setIdskillset(123);
		sk.setSkillset_level(4);
		sk.setSkillset_name("Java");
		sk_dao.createJobApply(sk);

		// update Product

		
//
		skillset sku= sklist.get(0); 

		sku.setSkillset_level(5);

		sk_dao.updateskillset(sku);

	
		// remove product

		sk_dao.removeskillset(123);



		System.out.println("Thanks for using my jobsite");

	}



}

