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

public class experience_detail_dao {

	private DatabaseConnection dbc;
	private Connection conn = null;

	ArrayList<experience_detail> expdet;

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
	public List<experience_detail> getAllExperienceDetails() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		experience_detail expdet = null;
		List<experience_detail> detail = null;
		// Assign query string to a variable
		String qString = "select * from experience_detail";
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
			detail = new ArrayList<experience_detail>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				expdet = new experience_detail();
				expdet.setUser_account_id(rs.getInt(1));
				expdet.setIs_current_job(rs.getString(2));
				expdet.setJob_title(rs.getString(3));
				expdet.setCompany_name(rs.getString(4));
				expdet.setStart_date(rs.getDate(5));
				expdet.setEnd_date(rs.getDate(6));
				expdet.setJob_city(rs.getString(7));
				expdet.setJob_state(rs.getString(8));
				expdet.setJob_country(rs.getString(9));
				detail.add(expdet);
				
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
		return detail;

	}

	// ***********Create() method**************

	public Integer createExperienceDetails(experience_detail expdet)
			throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into experience_detail (user_account_id,is_current_job,job_title,company_name,start_date,end_date,job_city,job_state,job_country) values (?,?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "user_account_id" };

		DatabaseConnection dbc = new DatabaseConnection();
		//System.out.println("expdet"+expdet);
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,expdet.getUser_account_id());
			stmt.setString(2,expdet.getIs_current_job());
			stmt.setString(3,expdet.getJob_title());
			stmt.setString(4, expdet.getCompany_name());
			stmt.setDate(5, (Date)expdet.getStart_date());
			stmt.setDate(6, (Date)expdet.getEnd_date());
			stmt.setString(7, expdet.getJob_city());
			stmt.setString(8, expdet.getJob_state());
			stmt.setString(9, expdet.getJob_country());
		
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

	public Boolean updateExperienceDetail(experience_detail expdet) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign update string to variable
		
	

		
		String updateString = "update experience_detail "
				+ "set  is_current_job = ? , job_title = ?, company_name = ?, start_date = ?, end_date = ?, job_city =? , job_state= ? , job_country=?"
				+ "where user_account_id = ?";
		System.out.println("updatestring"+ updateString);
		// Create MySqlConnection class instance DatabaseConnection
		dbc = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)

			
			stmt.setString(1,expdet.getIs_current_job());
			stmt.setString(2,expdet.getJob_title());
			stmt.setString(3, expdet.getCompany_name());
			stmt.setDate(4, (Date)expdet.getStart_date());
			stmt.setDate(5, (Date)expdet.getEnd_date());
			stmt.setString(6, expdet.getJob_city());
			stmt.setString(7, expdet.getJob_state());
			stmt.setString(8, expdet.getJob_country());
			stmt.setInt(9,expdet.getUser_account_id());

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

	public Boolean removeExperienceDetail(int user_account_id) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// // Assign delete string to variable
		String deleteString = "delete from experience_detail where user_account_id = ?";

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

	public experience_detail getExperiencedetailByID(int Id) throws ClassNotFoundException, IOException, SQLException 
	{
//			// Declare variables
			Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		experience_detail expdet = null;
		
		// Assign query string to variable
			String qString = "select * from experience_detail where user_account_id = ?";
		
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
				expdet = new experience_detail();
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
		return expdet;
	}
	// End of removeUser()method
 
	// End of UserDAO class*/

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		experience_detail_dao exp_dao = new experience_detail_dao();
		
		
		// List or get all employer details
		// List< education_detail> res = new ArrayList<education_detail>();
		List<experience_detail> listdetail = exp_dao.getAllExperienceDetails();
	
		for (experience_detail exp1 : listdetail)

			System.out.println(exp1);

		
		// create product
		experience_detail expdet = new experience_detail();
		expdet.setUser_account_id(56);
		expdet.setIs_current_job("Y");
		expdet.setJob_title("Analyst");
		expdet.setCompany_name("TCS");
		expdet.setStart_date(java.sql.Date.valueOf("2010-10-23"));
		expdet.setEnd_date(java.sql.Date.valueOf("2015-08-12"));
		expdet.setJob_city("NewYork");
		expdet.setJob_state("New York");
		expdet.setJob_country("USA");
		exp_dao.createExperienceDetails(expdet);



		// update Product
		experience_detail expdet1 = listdetail.get(0);
		expdet1.setJob_title("DBA");
		exp_dao.updateExperienceDetail(expdet1);
	
		// remove product
		exp_dao.removeExperienceDetail(56);
		//emp_dao.removeEmployerDetail(1789);

		System.out.println("Thanks for using my jobsite");
	}

}

