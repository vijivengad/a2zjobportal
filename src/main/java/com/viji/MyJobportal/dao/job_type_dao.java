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
import com.viji.JobPortal.model.job_type;

	public class job_type_dao {

		private DatabaseConnection dbc;

		private Connection conn = null;
		ArrayList<job_type> jbt;

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

		public List<job_type> getAllDetails() throws SQLException {

			// Declare variables

			Connection conn = null;

			Statement stmt = null;

			ResultSet rs = null;

			job_type jbt = null;

			List<job_type> jbtlist = null;

			// Assign query string to a variable

			String qString = "select * from job_type";

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
				jbtlist=new ArrayList<job_type>();
			
				// Read the ResultSet instance
				while (rs.next()) {
					// Each iteration creates a new user
					jbt = new job_type();
					// Assign columns/fields to related fields in the User object
					jbt.setIdjob_type(rs.getInt(1));
					jbt.setJob_type("Sales");
				  
					jbtlist.add(jbt);
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
			return jbtlist;
		}

		// ***********Create() method**************
		public Integer createJobtype(job_type jbt)
				throws SQLException, ClassNotFoundException, IOException {

			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			// Assign insert statement string to variable
			String insertString = "insert into job_type (idjob_type,job_type) values (?,?)";

			int ID = -1;
			String[] COL = { "idjob_type" };
			DatabaseConnection dbc = new DatabaseConnection();
			try {
				conn = dbc.getConnection();
				stmt = conn.prepareStatement(insertString, COL);
				stmt.setInt(1,jbt.getIdjob_type());
				stmt.setString(2, jbt.getJob_type());
				
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
		public Boolean updatejobtype(job_type jbt) throws SQLException, ClassNotFoundException, IOException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			Integer updateResult = null;

			// Assign update string to variable
			String updateString = "update job_type "
					+ "set job_type= ? "
					+ "where idjob_type = ?";

			// Create MySqlConnection class instance DatabaseConnection
			dbc = new DatabaseConnection();
			// Begin try/catch block to query the database
			try {
				// Connect to database and assign query string to PreparedStatement object
				conn = dbc.getConnection();
				stmt = conn.prepareStatement(updateString);
				// Set query parameters (?)
				stmt.setString(1, jbt.getJob_type());
				stmt.setInt(2, jbt.getIdjob_type());
			
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

		public Boolean removejobtype(int idjob_type) throws IOException, SQLException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			Integer updateResult = null;

			// // Assign delete string to variable

			String deleteString = "delete from job_type where idjob_type = ?";
			// // Create MySqlConnection class instance
			DatabaseConnection dbc = new DatabaseConnection();

			// Begin try/catch block to query the database
			try {
				// Connect to database and assign query string to PreparedStatement object
				conn = dbc.getConnection();

				stmt = conn.prepareStatement(deleteString);



				// Set query parameters (?)

				stmt.setInt(1, idjob_type);

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
			job_type_dao jbt_dao = new job_type_dao();
			// ja_dao.testConnection();
			// List or get all products
			List<job_type> jbtlist = jbt_dao.getAllDetails();
			for (job_type jbt : jbtlist)
				System.out.println(jbt);

			// create detail
			job_type jb= new job_type();
			jb.setIdjob_type(234);
			jb.setJob_type("Sales");
	
			jbt_dao.createJobtype(jb);

			// update Product
			job_type jbt= jbtlist.get(0); 
			jbt.setJob_type("Marketing");
			jbt_dao.updatejobtype(jbt);

			// remove product
			jbt_dao.removejobtype(234);

			System.out.println("Thanks for using my jobsite");

		}



	}




