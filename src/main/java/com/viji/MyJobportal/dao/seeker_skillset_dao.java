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
	import com.viji.JobPortal.model.seeker_skillset;
	

	public class seeker_skillset_dao {

		private DatabaseConnection dbc;

		private Connection conn = null;



		ArrayList<seeker_skillset> skilllist;

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

		public List<seeker_skillset> getAllDetails() throws SQLException {

			// Declare variables

			Connection conn = null;

			Statement stmt = null;

			ResultSet rs = null;

			seeker_skillset skillset = null;

			List<seeker_skillset> seekerlist = null;

			// Assign query string to a variable

			String qString = "select * from seeker_skillset";

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

				seekerlist = new ArrayList<seeker_skillset>();

				// Read the ResultSet instance

				while (rs.next()) {

					// Each iteration creates a new user

					skillset = new seeker_skillset();
					// Assign columns/fields to related fields in the User object
					skillset.setIdseeker_skillset(rs.getInt(1));
					skillset.setSeeker_skillset_id(rs.getInt(2));
					skillset.setSeeker_skillset_level(rs.getInt(3));
					seekerlist.add(skillset);
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

		public Integer createSeekerSkillset(seeker_skillset se)

				throws SQLException, ClassNotFoundException, IOException {

			// Declare variables

			Connection conn = null;

			PreparedStatement stmt = null;

			ResultSet rs = null;



			// Assign insert statement string to variable

		

			String insertString = "insert into seeker_skillset (idseeker_skillset,seeker_skillset_id,seeker_skillset_level) values (?,?,?)";

			int ID = -1;

			String[] COL = { "idseeker_skillset" };

			DatabaseConnection dbc = new DatabaseConnection();
			try {
				conn = dbc.getConnection();
				stmt = conn.prepareStatement(insertString, COL);
				stmt.setInt(1,se.getIdseeker_skillset());
				stmt.setInt(2, se.getSeeker_skillset_id());
				stmt.setInt(3,se.getSeeker_skillset_level());


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

		} 
		// //****************updateJobApply() method*****************



		public Boolean updateJobSeekerSkillset(seeker_skillset se) throws SQLException, ClassNotFoundException, IOException {

			// Declare variables

			Connection conn = null;

			PreparedStatement stmt = null;

			Integer updateResult = null;

			// Assign update string to variable

			String updateString = "update seeker_skillset "

					+ "set  seeker_skillset_id = ?,seeker_skillset_level  = ? "

					+ "where idseeker_skillset = ?";
			
			System.out.println(updateString);


			// Create MySqlConnection class instance DatabaseConnection

			dbc = new DatabaseConnection();

			// Begin try/catch block to query the database

			try {

				// Connect to database and assign query string to PreparedStatement object

				conn = dbc.getConnection();

				stmt = conn.prepareStatement(updateString);


				// Set query parameters (?)
				stmt.setInt(1,se.getIdseeker_skillset());
				stmt.setInt(2,se.getSeeker_skillset_id() );
				stmt.setInt(3,se.getSeeker_skillset_level());

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

		} 
		// ****************removeUser() method (i.e., delete)*****************

		public Boolean removeJobSeekerSkillset(int idseeker_skillset) throws IOException, SQLException {

			// Declare variables

			Connection conn = null;

			PreparedStatement stmt = null;

			Integer updateResult = null;



			// // Assign delete string to variable

			String deleteString = "delete from seeker_skillset where idseeker_skillset = ?";

			// // Create MySqlConnection class instance

			DatabaseConnection dbc = new DatabaseConnection();

			// Begin try/catch block to query the database

			try {

				// Connect to database and assign query string to PreparedStatement object

				conn = dbc.getConnection();

				stmt = conn.prepareStatement(deleteString);

				// Set query parameters (?)

				stmt.setInt(1, idseeker_skillset);

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



			seeker_skillset_dao se_dao = new seeker_skillset_dao();

			// se_dao.testConnection();



			// List or get all products

			List<seeker_skillset> seekerlist = se_dao.getAllDetails();

			

			for (seeker_skillset se : seekerlist)

				System.out.println(se);



			// create detail

			seeker_skillset se = new seeker_skillset();
			se.setIdseeker_skillset(3456);
			se.setSeeker_skillset_id(1234);
			se.setSeeker_skillset_level(8);
			se_dao.createSeekerSkillset(se);

			// update Product
			seeker_skillset seu= seekerlist.get(0); 
			seu.setSeeker_skillset_level(5);
			
			System.out.println(seu);
			se_dao.updateJobSeekerSkillset(seu);
			// remove product

			se_dao.removeJobSeekerSkillset(3456);

			System.out.println("Thanks for using my jobsite");

		}
	}




