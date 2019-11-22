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
import com.viji.JobPortal.model.job_post_skill_set;

public class job_post_skill_set_dao {

	private DatabaseConnection dbc;
	private Connection conn = null;

	ArrayList<job_post_skill_set> jbpos;

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
	public List<job_post_skill_set> getAllJobPostskillDetails() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		job_post_skill_set jbpos = null;
		List<job_post_skill_set> jblist= null;
		// Assign query string to a variable
		String qString = "select * from job_post_skill_set";
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
			rs = stmt.executeQuery(qString);	
			jblist = new ArrayList<job_post_skill_set>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				jbpos=new job_post_skill_set();
				jbpos.setIdjob_post_skill_set(rs.getInt(1));
				jbpos.setJob_post_id(rs.getInt(2));
				jbpos.setJob_post_skill_level(rs.getInt(3));
				
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

	public Integer createJobPostSkillDetails(job_post_skill_set jbpos)
			throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into job_post_skill_set (idjob_post_skill_set,job_post_id,job_post_skill_level) values (?,?,?)";

		int ID = -1;
		String[] COL = { "idjob_post_skill_set" };

		DatabaseConnection dbc = new DatabaseConnection();
		
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,jbpos.getIdjob_post_skill_set());
			stmt.setInt(2, jbpos.getJob_post_id());
			stmt.setInt(3,jbpos.getJob_post_skill_level());
			
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

	public Boolean updateJobSkillpost(job_post_skill_set jbpos) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign update string to variable
		
		String updateString = "update job_post_skill_set "
				+ "set  job_post_id = ?, job_post_skill_level= ? "
				+ "  where idjob_post_skill_set = ?";
		System.out.println("updatestring"+ updateString);
		// Create MySqlConnection class instance DatabaseConnection
		dbc = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(updateString);
			stmt.setInt(1,jbpos.getJob_post_id());
			stmt.setInt(2,jbpos.getJob_post_skill_level());
			stmt.setInt(3, jbpos.getIdjob_post_skill_set());
			
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

	public Boolean removeJobSkillPostDetails(int idjob_post_skill_setpost) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// // Assign delete string to variable
		String deleteString = "delete from job_post_skill_set where idjob_post_skill_set = ?";

		// // Create MySqlConnection class instance
		DatabaseConnection dbc = new DatabaseConnection();
		
		try {
			
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, idjob_post_skill_setpost);
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

		job_post_skill_set_dao jbss_dao = new job_post_skill_set_dao();
		
		
		// List or get all employer details
		// List< education_detail> res = new ArrayList<education_detail>();
		

		
		// create product
		job_post_skill_set jbpostss = new job_post_skill_set();
		jbpostss.setJob_post_id(1001);
		jbpostss.setIdjob_post_skill_set(1234);
		jbpostss.setJob_post_skill_level(4);
		jbss_dao.createJobPostSkillDetails(jbpostss);

		List<job_post_skill_set> jpsslist = jbss_dao.getAllJobPostskillDetails();
		
		for (job_post_skill_set js : jpsslist)

			System.out.println(js);

		// update Product
		jbpostss.setJob_post_skill_level(5);
		jbss_dao.updateJobSkillpost(jbpostss);
	
		// remove product
		jbss_dao.removeJobSkillPostDetails(1234);
		

		System.out.println("Thanks for using my jobsite");
	}

}

