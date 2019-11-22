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

import javax.sql.rowset.serial.SerialBlob;


import com.viji.JobPortal.model.DatabaseConnection;
import com.viji.JobPortal.model.education_detail;

public class education_detail_dao {

	private DatabaseConnection dbc;
	private Connection conn = null;

	ArrayList<education_detail> eddetail;

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
	public List<education_detail> getAllDetails() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		education_detail ed = null;
		List<education_detail> eddetail = null;
		// Assign query string to a variable
		String qString = "select * from education_detail";
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
			eddetail = new ArrayList<education_detail>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				ed = new education_detail();
				// Assign columns/fields to related fields in the User object

				ed.setUser_account_id(rs.getInt(1));
				ed.setDegree_name(rs.getString(2));
				ed.setMajor(rs.getString(3));
				ed.setUniversity(rs.getString(4));
				ed.setStart_date(rs.getDate(5));
				ed.setCompletion_date(rs.getDate(6));
				ed.setCgpa(rs.getDouble(7));
				ed.setResume(rs.getBlob(8));

				// Add educationdetails to the list*/
				eddetail.add(ed);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
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
		return eddetail;

	}

	// ***********Create() method**************

	public Integer createEducationDetails(education_detail ed)
			throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into education_detail (user_account_id,degree_name, Major,university,start_date,completion_date,cgpa,resume) values (?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "user_account_id" };

		DatabaseConnection dbc = new DatabaseConnection();
		System.out.println("ed"+ed);
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,ed.getUser_account_id());
			stmt.setString(2, ed.getDegree_name());
			stmt.setString(3, ed.getMajor());
			stmt.setString(4, ed.getUniversity());
			stmt.setDate(5, (Date) ed.getStart_date());
			stmt.setDate(6, (Date) ed.getCompletion_date());
			stmt.setDouble(7, ed.getCgpa());
			stmt.setBlob(8, ed.getResume());
			

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

	// //****************updateEducationDetail() method*****************

	public Boolean updateEducationDetail(education_detail ed) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign update string to variable
		String updateString = "update education_detail "
				+ "set degree_name = ?, Major= ? , university = ?,start_date = ?,completion_date =?, cgpa =?,resume = ? "
				+ "where user_account_id = ?";

		// Create MySqlConnection class instance DatabaseConnection
		dbc = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)

			stmt.setString(1, ed.getDegree_name());
			stmt.setString(2, ed.getMajor());
			stmt.setString(3, ed.getUniversity());
			stmt.setDate(4, (Date) ed.getStart_date());
			stmt.setDate(5, (Date) ed.getCompletion_date());
			stmt.setDouble(6, ed.getCgpa());
			stmt.setBlob(7, ed.getResume());
			stmt.setInt(8, ed.getUser_account_id());

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

	public Boolean removeEducationDetail(int user_account_id) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// // Assign delete string to variable
		String deleteString = "delete from education_detail where user_account_id = ?";

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

	public education_detail getEduDetailsByID(int Id) throws ClassNotFoundException, IOException, SQLException 
	{
//			// Declare variables
			Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		education_detail ed = null;
		
		// Assign query string to variable
			String qString = "select * from education_detail where user_account_id = ?";
		
		// Create MySqlConnection class instance
			 DatabaseConnection dbc = new DatabaseConnection();
			// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
		conn = dbc.getConnection();
		stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setInt(1, Id); // user_id if from String parameter passed to method
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				ed = new education_detail();
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
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
		return ed;
	}
	// End of removeUser()method

	// End of UserDAO class

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		education_detail_dao ed_dao = new education_detail_dao();
		// ed_dao.testConnection();

		// List or get all products

		List<education_detail> edlist = ed_dao.getAllDetails();
		
		for (education_detail ed1 : edlist)

			System.out.println(ed1);

		// create detail
		education_detail ed = new education_detail();
		ed.setUser_account_id(56);
		ed.setDegree_name("MBBS");
		ed.setMajor("General");
		ed.setUniversity("Texas");
		
		ed.setStart_date(java.sql.Date.valueOf("2010-10-23"));
		ed.setCompletion_date(java.sql.Date.valueOf("2015-08-12"));
		ed.setCgpa(3.2);
		String resume = "adghjj";
		ed.setResume(new SerialBlob(resume.getBytes()));
		ed_dao.createEducationDetails(ed);
		

		// update Product
		/*
		  education_detail ed= edlist.get(0); 
		  ed.setDegree_name("MBA");

		 * ed_dao.updateEducationDetail(ed);
		 */

		// remove product
		//ed_dao.removeEducationDetail(56);

		System.out.println("Thanks for using my jobsite");
	}

}
