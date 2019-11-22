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
import com.viji.JobPortal.model.job_post;

public class job_post_dao {

	private DatabaseConnection dbc;
	private Connection conn = null;

	ArrayList<job_post> jbpos;

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
	public List<job_post> getAllJobPostDetails() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		job_post jbpos = null;
		List<job_post> jblist= null;
		// Assign query string to a variable
		String qString = "select * from job_post";
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
			jblist = new ArrayList<job_post>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				jbpos=new job_post();
				jbpos.setIdjob_post(rs.getInt(1));
				jbpos.setPosted_by(rs.getInt(2));
				jbpos.setJob_role(rs.getInt(3));
				jbpos.setCompany_name(rs.getString(4));
				jbpos.setCreated_date(rs.getDate(5));
				jbpos.setDescription(rs.getString(6));
				jbpos.setLocation_id(rs.getInt(7));
				jbpos.setIs_active(rs.getString(8));
				
			
				jblist.add(jbpos);
				
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

	public Integer createJobPostDetails(job_post jbpos)
			throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into job_post (idjob_post,posted_by,job_type,company_name,created_date,description,location_id,is_active) values (?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "idjob_post" };

		DatabaseConnection dbc = new DatabaseConnection();
		
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,jbpos.getIdjob_post());
			stmt.setInt(2,jbpos.getPosted_by());
			stmt.setInt(3,jbpos.getJob_role());
			stmt.setString(4,jbpos.getCompany_name());
			stmt.setDate(5,jbpos.getCreated_date());
			stmt.setString(6,jbpos.getDescription());
			stmt.setInt(7,jbpos.getLocation_id());
			stmt.setString(8,jbpos.getIs_active());
			
	
		
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

	/**
	 * @param jbpos
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Boolean updateJobpost(job_post jbpos) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign update string to variable
		
		String updateString = "update job_post "
				+ "set  posted_by= ?, job_type = ?, company_name = ?, created_date=?,description = ?,location_id = ?,is_active = ? "
				+ "  where idjob_post = ?";
		System.out.println("updatestring"+ updateString);
		// Create MySqlConnection class instance DatabaseConnection
		dbc = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setInt(1,jbpos.getPosted_by());
			stmt.setInt(2,jbpos.getJob_role());
			stmt.setString(3,jbpos.getCompany_name());
			stmt.setDate(4,jbpos.getCreated_date());
			stmt.setString(5,jbpos.getDescription());
			stmt.setInt(6,jbpos.getLocation_id());
			stmt.setString(7,jbpos.getIs_active());
			stmt.setInt(8, jbpos.getIdjob_post());
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

	public Boolean removeJobPostDetails(int idjob_post) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// // Assign delete string to variable
		String deleteString = "delete from job_post where idjob_post = ?";

		// // Create MySqlConnection class instance
		DatabaseConnection dbc = new DatabaseConnection();
		
		try {
			
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, idjob_post);
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

		job_post_dao jb_dao = new job_post_dao();
		
		
		// List or get all employer details
		// List< education_detail> res = new ArrayList<education_detail>();
		List<job_post> jblist = jb_dao.getAllJobPostDetails();
	
		for (job_post jb : jblist)

			System.out.println(jb);

		
		// create product
		job_post jbpost = new job_post();
		jbpost.setIdjob_post(1002);
		jbpost.setPosted_by(1001);
		jbpost.setJob_role(123);
		jbpost.setCompany_name("TechMahindra");
		jbpost.setCreated_date(java.sql.Date.valueOf("2010-10-23"));
		jbpost.setDescription("This role is forQuality Engineer");
		jbpost.setLocation_id(100);
		jbpost.setIs_active("N");
		
		jb_dao.createJobPostDetails(jbpost);



		// update Product
		job_post jbp = jblist.get(0);
		jbp.setLocation_id(300);
		jb_dao.updateJobpost(jbp);
	
		// remove product
		jb_dao.removeJobPostDetails(1002);
		

		System.out.println("Thanks for using my jobsite");
	}

}

