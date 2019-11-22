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

import org.springframework.stereotype.Repository;

import com.viji.JobPortal.model.DatabaseConnection;
import com.viji.JobPortal.model.admin;
@Repository
public class admin_dao{
	private DatabaseConnection dbc;

	private Connection conn = null;
ArrayList<admin> ad;


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

	public List<admin> getAllAdminDetails() throws SQLException {

		// Declare variables

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		admin ad = null;

		List<admin> adlist = null;

		// Assign query string to a variable

		String qString = "select * from admin";

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

			adlist = new ArrayList<admin>();

			// Read the ResultSet instance

			while (rs.next()) {

				// Each iteration creates a new user
				ad = new admin();
				ad.setUsertyp(rs.getInt(1));
				ad.setUsername(rs.getString(2));
				ad.setPassword(rs.getString(3));
				adlist.add(ad);
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

		return adlist;



	}



	// ***********Create() method**************



	public Integer createAdmin(admin ad)

			throws SQLException, ClassNotFoundException, IOException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		// Assign insert statement string to variable

		String insertString = "insert into admin (usertype, username, password) values (?,?,?)";

		int ID = -1;

		String[] COL = { "user_type" };

		DatabaseConnection dbc = new DatabaseConnection();
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1, ad.getUsertype());
			stmt.setString(2, ad.getUsername());
			stmt.setString(3, ad.getPassword());
			
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



	public Boolean updateAdmin(admin ad) throws SQLException, ClassNotFoundException, IOException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		Integer updateResult = null;

		// Assign update string to variable

		String updateString = "update admin "

				+ "set  username= ?, password=? "

				+ "where usertype = ?";
		
		System.out.println(updateString);


		// Create MySqlConnection class instance DatabaseConnection

		dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try {

			// Connect to database and assign query string to PreparedStatement object

			conn = dbc.getConnection();

			stmt = conn.prepareStatement(updateString);


			// Set query parameters (?)
			stmt.setString(1, ad.getUsername());
			stmt.setString(2, ad.getPassword());
			stmt.setInt(3, ad.getUsertype());
		
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



	public Boolean removeAdmin(String username) throws IOException, SQLException {

		// Declare variables

		Connection conn = null;

		PreparedStatement stmt = null;

		Integer updateResult = null;



		// // Assign delete string to variable

		String deleteString = "delete from admin where username = ?";

		// // Create MySqlConnection class instance

		DatabaseConnection dbc = new DatabaseConnection();

		// Begin try/catch block to query the database

		try {

			// Connect to database and assign query string to PreparedStatement object

			conn = dbc.getConnection();

			stmt = conn.prepareStatement(deleteString);
		// Set query parameters (?)

			stmt.setString(1, username);

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
		admin_dao ad_dao = new admin_dao();

		// use_dao.testConnection();
		// List or get all products
		List<admin> adlist = ad_dao.getAllAdminDetails();
		for (admin adl : adlist)
			System.out.println(adl);
		
		// create detail
		admin ad = new admin();
		ad.setUsertyp(3);
		ad.setUsername("Arpita");
		ad.setPassword("pass");
		ad_dao.createAdmin(ad);
		
		// update Product
		admin ad1= adlist.get(0); 
		ad1.setPassword("pass1");
		
		System.out.println(ad1);
		ad_dao.updateAdmin(ad1);
		
		// remove product
		ad_dao.removeAdmin("arpita");
	
		System.out.println("Thanks for using my jobsite");
	}
}

