package com.viji.MyJobportal.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;


import com.viji.JobPortal.model.DatabaseConnection;
import com.viji.JobPortal.model.education_detail;
import com.viji.JobPortal.model.employer;
import com.viji.JobPortal.model.experience_detail;
import com.viji.JobPortal.model.job_location;

public class job_location_dao {

	private DatabaseConnection dbc;
	private Connection conn = null;

	ArrayList<job_location> jbloc;

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

	// ****************getAlleducationDetails() method*****************
	public List<job_location> getAllJoblocationDetails() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		job_location jbloc = null;
		List<job_location> jblist= null;
		// Assign query string to a variable
		String qString = "select * from job_location";
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
			jblist = new ArrayList<job_location>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				jbloc = new job_location();
				jbloc.setIdjob_location(rs.getInt(1));
				jbloc.setCity(rs.getString(2));
				jbloc.setState(rs.getString(3));
				jbloc.setCountry(rs.getString(4));
				jbloc.setZip(rs.getInt(5));
			
				jblist.add(jbloc);
				
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
		return jblist;

	}

	// ***********Create() method**************

	public Integer createJobLocationDetails(job_location jbloc)
			throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into job_location (idjob_location,city,state,country,zip) values (?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "idjob_location" };

		DatabaseConnection dbc = new DatabaseConnection();
		
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,jbloc.getIdjob_location());
			stmt.setString(2,jbloc.getCity());
			stmt.setString(3,jbloc.getState());
			stmt.setString(4,jbloc.getCountry());
			stmt.setInt(5,jbloc.getZip());
		
			ID = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		finally {
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

	// //****************updateEducationDetail() method*****************

	public Boolean updateJobLocation(job_location jbloc) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign update string to variable
		
		String updateString = "update job_location "
				+ "set  city = ? , state = ?, country = ?, zip = ?"
				+ " where idjob_location = ?";
		System.out.println("updatestring"+ updateString);
		// Create MySqlConnection class instance DatabaseConnection
		dbc = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setInt(1,jbloc.getIdjob_location());
			stmt.setString(2,jbloc.getCity());
			stmt.setString(3,jbloc.getState());
			stmt.setString(4,jbloc.getCountry());
			stmt.setInt(5,jbloc.getZip());
		
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

	// ****************removeJobLocationDetails() method (i.e., delete)*****************

	public Boolean removeJobLocationDetails(int idjob_location) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// // Assign delete string to variable
		String deleteString = "delete from job_location where idjob_location = ?";

		// // Create MySqlConnection class instance
		DatabaseConnection dbc = new DatabaseConnection();
		
		try {
			
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, idjob_location);
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

	
	// End of UserDAO class*/

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		job_location_dao jb_dao = new job_location_dao();
		
		
		// List or get all employer details
		// List< education_detail> res = new ArrayList<education_detail>();
		List<job_location> jblist = jb_dao.getAllJoblocationDetails();
	
		for (job_location jb : jblist)

			System.out.println(jb);

		
		// create product
		job_location jbloc = new job_location();
		jbloc.setIdjob_location(400);
		jbloc.setCity("Chicago");
		jbloc.setState("IL");
		jbloc.setCountry("USA");
		jbloc.setZip(60002);
	
		jb_dao.createJobLocationDetails(jbloc);



		// update Product
		job_location jbu = jblist.get(0);
		jbu.setCity("Detroit");
		jb_dao.updateJobLocation(jbu);
	
		// remove product
		jb_dao.removeJobLocationDetails(400);
		

		System.out.println("Thanks for using my jobsite");
	}

}

