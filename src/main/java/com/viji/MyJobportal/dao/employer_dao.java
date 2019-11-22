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

public class employer_dao {

	private DatabaseConnection dbc;
	private Connection conn = null;

	ArrayList<employer> emp;

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
	public List<employer> getAllEmployeeDetails() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		employer emp = null;
		List<employer> employee = null;
		// Assign query string to a variable
		String qString = "select * from employer";
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
			employee = new ArrayList<employer>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				emp = new employer();
				emp.setIdemployer(rs.getInt(1));
				emp.setUsertypeid(rs.getInt(2));
				emp.setCompany_name(rs.getString(3));
				emp.setProfile(rs.getString(4));
				emp.setWebsite(rs.getString(5));
				emp.setEmail(rs.getString(6));
				emp.setUsername(rs.getString(7));
				emp.setPassword(rs.getString(8));
			
				employee.add(emp);
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
		return employee;

	}

	// ***********Create() method**************

	public Integer createEmployeeDetails(employer emp)
			throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into employer (idemployer,usertypeid,company_name,profile,website,email,username,password) values (?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "idemployer" };

		DatabaseConnection dbc = new DatabaseConnection();
		System.out.println("emp"+emp);
		try {
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,emp.getIdemployer());
			stmt.setInt(2, emp.getUsertypeid());
			stmt.setString(3, emp.getCompany_name());
			stmt.setString(4, emp.getProfile());
			stmt.setString(5, emp.getWebsite());
			stmt.setString(6,  emp.getEmail());
			stmt.setString(7, emp.getUsername());
			stmt.setString(8, emp.getPassword());
			

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

	public Boolean updateEmployee(employer emp) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign update string to variable
		
	

		
		String updateString = "update employer "
				+ "set  usertypeid = ? , company_name = ?,profile = ?,website = ?, email = ?,username = ? ,password = ?"
				+ "where idemployer = ?";
		System.out.println("updatestring"+ updateString);
		// Create MySqlConnection class instance DatabaseConnection
		dbc = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbc.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)

			//stmt.setInt(1, emp.getIdemployer());
			stmt.setInt(1, emp.getUsertypeid());
			stmt.setString(2, emp.getCompany_name());
			stmt.setString(3,emp.getProfile());
			stmt.setString(4,emp.getWebsite());
			stmt.setString(5, emp.getEmail());
			stmt.setString(6, emp.getUsername());
			stmt.setString(7, emp.getPassword());
			stmt.setInt(8, emp.getIdemployer());

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

	public Boolean removeEmployerDetail(int user_account_id) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// // Assign delete string to variable
		String deleteString = "delete from employer where idemployer = ?";

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

	public employer getEmployeeByID(int Id) throws ClassNotFoundException, IOException, SQLException 
	{
//			// Declare variables
			Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		employer emp = null;
		
		// Assign query string to variable
			String qString = "select * from employer where idemployer = ?";
		
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
				emp = new employer();
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
		return emp;
	}
	// End of removeUser()method

	// End of UserDAO class*/

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		employer_dao emp_dao = new employer_dao();
		
		
		// List or get all employer details
		// List< education_detail> res = new ArrayList<education_detail>();
		List<employer> emplist = emp_dao.getAllEmployeeDetails();
	
		for (employer emp1 : emplist)

			System.out.println(emp1);

		// create product
	/*	employer emp = new employer();
		emp.setIdemployer(1789);
		emp.setUsertypeid(2);
		emp.setCompany_name("Target");
		emp.setProfile("asdfgg");
		emp.setWebsite("fghhhj");
		emp.setEmail("arpi23@yahoo.com");
		emp.setUsername("arpita");
		emp.setPassword("rtydg");
		
		for (employer emp1 : emplist)

			System.out.println(emp1);

		emp_dao.createEmployeeDetails(emp);*/


		// update Product
		
		employer employee= emplist.get(0);
		employee.setUsername("Asmita");
		 
		emp_dao.updateEmployee(employee);
		 

		// remove product
		//emp_dao.removeEmployerDetail(1789);

		System.out.println("Thanks for using my jobsite");
	}

}
