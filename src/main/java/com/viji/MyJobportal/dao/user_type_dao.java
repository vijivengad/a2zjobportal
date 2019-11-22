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
import com.viji.JobPortal.model.user_type;

	public class user_type_dao {
		private DatabaseConnection dbc;

		private Connection conn = null;
	ArrayList<user_type> use;


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

		public List<user_type> getAllUserTypeDetails() throws SQLException {

			// Declare variables

			Connection conn = null;

			Statement stmt = null;

			ResultSet rs = null;

			user_type use = null;

			List<user_type> userlist = null;

			// Assign query string to a variable

			String qString = "select * from user_type";

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

				userlist = new ArrayList<user_type>();

				// Read the ResultSet instance

				while (rs.next()) {

					// Each iteration creates a new user

					use = new user_type();
					// Assign columns/fields to related fields in the User object
					use.setId(rs.getInt(1));
					use.setUser_type(rs.getInt(2));
					use.setUser_typerole(rs.getString(3));
					userlist.add(use);
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

			return userlist;



		}



		// ***********Create() method**************



		public Integer createUser_type(user_type use)

				throws SQLException, ClassNotFoundException, IOException {

			// Declare variables

			Connection conn = null;

			PreparedStatement stmt = null;

			ResultSet rs = null;



			// Assign insert statement string to variable

		

			String insertString = "insert into user_type (iduser_type, user_type, usertyperole) values (?,?,?)";

			int ID = -1;

			String[] COL = { "user_type" };

			DatabaseConnection dbc = new DatabaseConnection();
			try {
				conn = dbc.getConnection();
				stmt = conn.prepareStatement(insertString, COL);
				stmt.setInt(1,use.getId());
				stmt.setInt(2,use.getUser_type());
				stmt.setString(3,use.getUser_typerole());

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



		public Boolean updateUsertype(user_type use) throws SQLException, ClassNotFoundException, IOException {

			// Declare variables

			Connection conn = null;

			PreparedStatement stmt = null;

			Integer updateResult = null;

			// Assign update string to variable

			String updateString = "update user_type "

					+ "set  user_type= ?, usertyperole=? "

					+ "where iduser_type = ?";
			
			System.out.println(updateString);


			// Create MySqlConnection class instance DatabaseConnection

			dbc = new DatabaseConnection();

			// Begin try/catch block to query the database

			try {

				// Connect to database and assign query string to PreparedStatement object

				conn = dbc.getConnection();

				stmt = conn.prepareStatement(updateString);


				// Set query parameters (?)
			
				stmt.setInt(1, use.getUser_type());
				stmt.setString(2, use.getUser_typerole());
				stmt.setInt(3, use.getId());
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



		public Boolean removeuser_type(int iduser_type) throws IOException, SQLException {

			// Declare variables

			Connection conn = null;

			PreparedStatement stmt = null;

			Integer updateResult = null;



			// // Assign delete string to variable

			String deleteString = "delete from user_type where iduser_type = ?";

			// // Create MySqlConnection class instance

			DatabaseConnection dbc = new DatabaseConnection();

			// Begin try/catch block to query the database

			try {

				// Connect to database and assign query string to PreparedStatement object

				conn = dbc.getConnection();

				stmt = conn.prepareStatement(deleteString);
			// Set query parameters (?)

				stmt.setInt(1, iduser_type);

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
			user_type_dao use_dao = new user_type_dao();

			// use_dao.testConnection();

			// List or get all products
			
			// create detail
			user_type usec = new user_type();
			usec.setId(4);
			usec.setUser_type(4);
			usec.setUser_typerole("admin");
			use_dao.createUser_type(usec);

			List<user_type> userlist = use_dao.getAllUserTypeDetails();
			for (user_type use : userlist)
				System.out.println(use);

			
			// update Product
			user_type useu= userlist.get(3); 
			useu.setUser_typerole("admin");
			
			System.out.println(useu);
			use_dao.updateUsertype(useu);
			
			// remove product
			use_dao.removeuser_type(4);

			System.out.println("Thanks for using my jobsite");
		}



}

