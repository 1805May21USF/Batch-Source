package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.beans.ConnFactory;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {
	// Retrieves the instance of the ConnFactory class
	public static ConnFactory cf = ConnFactory.getInstance();
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class.getName());
	
	// Creates an employee with the entered information
	public void createEmployee(String username, String password, String firstName, String lastName, char middleInitial, 
							   int age, String address, String city, int zip, String state, String department, double pay) throws SQLException {
		// Retrieves the connection and provides the sql code to be executed
		Connection conn = cf.getConnection();
		String sql = "{call INSERT_BANK_EMPLOYEE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Instantiates a CallableStatement to insert a new employee
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, firstName);
		call.setString(4, lastName);
		call.setString(5, middleInitial + "");
		call.setInt(6, age);
		call.setString(7, address);
		call.setString(8, city);
		call.setInt(9, zip);
		call.setString(10, state);
		call.setString(11, department);
		call.setDouble(12, pay);
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully created employee " + username + "\n");
	}

	// Retrieves a list of all employees
	public ArrayList<Employee> getEmployeeList(int arg) throws SQLException {
		// Instantiates the list to be returned
		ArrayList<Employee> employeeList = new ArrayList<>();
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM BANK_EMPLOYEE WHERE ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, arg);
		
		ResultSet rs = stmt.executeQuery();
		
		// Puts the retrieved employees into the list
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
									  rs.getString(6).charAt(0), rs.getString(5), rs.getInt(7), rs.getString(8), 
									  rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getDouble(13));
			
			employeeList.add(e);
		}
		
		// Closes the database connection
		conn.close();
		
		// Returns the list
		return employeeList;
	}
	
	public ArrayList<Employee> employeeExists(String arg) throws SQLException{
		// Instantiates the list to be returned
		ArrayList<Employee> employeeList = new ArrayList<>();
		Connection conn = cf.getConnection();
				
		String sql = "SELECT * FROM BANK_EMPLOYEE WHERE USERNAME = ?";
				
		PreparedStatement stmt = conn.prepareStatement(sql);
				
		stmt.setString(1, arg);
				
		ResultSet rs = stmt.executeQuery();
				
		// Puts the retrieved employees into the list
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					  				  rs.getString(6).charAt(0), rs.getString(5), rs.getInt(7), rs.getString(8), 
					  				  rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getDouble(13));
					
			employeeList.add(e);
		}
				
		// Closes the database connection
		conn.close();
				
		// Returns the list
		return employeeList;
	}
	
	public ArrayList<Employee> employeeExists(String argOne, String argTwo) throws SQLException{
		// Instantiates the list to be returned
		ArrayList<Employee> employeeList = new ArrayList<>();
		Connection conn = cf.getConnection();
				
		String sql = "SELECT * FROM BANK_EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
				
		PreparedStatement stmt = conn.prepareStatement(sql);
				
		stmt.setString(1, argOne);
		stmt.setString(2, argTwo);
				
		ResultSet rs = stmt.executeQuery();
				
		// Puts the retrieved employees into the list
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
									  rs.getString(6).charAt(0), rs.getString(5), rs.getInt(7), rs.getString(8), 
									  rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getDouble(13));
					
			employeeList.add(e);
		}
				
		// Closes the database connection
		conn.close();
				
		// Returns the list
		return employeeList;
	}

	// Deletes an employee whose id number was provided
	public void deleteEmployee(int id) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call DELETE_BANK_EMPLOYEE(?)";
		
		// Instantiates a CallableStatement to delete the employee whose id was entered
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, id);
		
		// Executes call
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully deleted employee number " + id + "\n");
	}
	
	// Updates the employee information of the entered customer
	public void updateEmployee(Employee e) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call UPDATE_BANK_CUSTOMER(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Instantiates a CallableStatement to update the customer with the entered information
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, e.getId());
		call.setString(2, e.getUsername());
		call.setString(3, e.getPassword());
		call.setString(4, e.getFirstName());
		call.setString(5, e.getLastName());
		call.setString(6, e.getMiddleInitial() + "");
		call.setInt(7, e.getAge());
		call.setString(8, e.getAddress());
		call.setString(9, e.getCity());
		call.setInt(10, e.getZip());
		call.setString(11, e.getState());
		call.setString(12, e.getDepartment());
		call.setDouble(13, e.getPay());
		call.execute();
		
		// Executes call
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info\nSuccessfully updated employee number " + e.getId() + " " + e.getUsername() + "\n");
	}
}
