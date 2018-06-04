package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.beans.ConnFactory;
import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;

public class CustomerDAOImpl implements CustomerDAO {
	// Retrieves the instance of the ConnFactory class
	public static ConnFactory cf = ConnFactory.getInstance();
	private static Logger log = Logger.getLogger(Customer.class.getName());
	
	// Creates a customer with the entered information
	public void createCustomer(String username, String password, String firstName, String lastName, char middleInitial, 
							   int age, String address, String city, int zip, String state) throws SQLException {
		// Retrieves the connection and provides the sql code to be executed
		Connection conn = cf.getConnection();
		String sql = "{call INSERT_BANK_CUSTOMER(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Instantiates a CallableStatement to insert a new customer
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
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully created customer " + username + "\n");
	}

	// Retrieves a list of all customers
	public ArrayList<Customer> getCustomerList(String arg) throws SQLException {
		// Instantiates the list to be returned
		ArrayList<Customer> customerList = new ArrayList<>();
		Connection conn = cf.getConnection();
		
		// Creates the prepared statement to collect a customer list
		String sql = "SELECT * FROM CUSTOMER WHERE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// Returns all customers if a dummy argument was sent
		if(!arg.equals("n"))
			stmt.setString(1, "CUSTOMERID > 0");
		// Returns all customers that match the sent valid argument
		else
			stmt.setString(1, arg);
		
		// Creates a result set and executes the prepared statement
		ResultSet rs = stmt.executeQuery();
		stmt.executeQuery("SELECT * FROM CUSTOMER");
		
		// Puts the retrieved customers into the list
		while(rs.next()) {
			Customer c = new Customer(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), 
									  rs.getString(5).charAt(0), rs.getString(4), rs.getInt(6), rs.getString(7), 
									  rs.getString(8), rs.getInt(9), rs.getString(10));
			
			customerList.add(c);
		}
		
		// Closes the database connection
		conn.close();
				
		// Returns the list
		return customerList;
	}

	// Deletes a customer whose id number was provided
	public void deleteCustomer(int id) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call DELETE_BANK_CUSTOMER(?)";
		
		// Instantiates a CallableStatement to delete the customer whose id was entered
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, id);
		
		// Executes call
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully deleted customer number " + id + "\n");
	}
	
	// Updates the customer information of the entered customer
	public void updateCustomer(Customer c) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call UPDATE_BANK_CUSTOMER(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Instantiates a CallableStatement to update the customer with the entered information
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, c.getId());
		call.setString(2, c.getUsername());
		call.setString(3, c.getPassword());
		call.setString(4, c.getFirstName());
		call.setString(5, c.getLastName());
		call.setString(6, c.getMiddleInitial() + "");
		call.setInt(7, c.getAge());
		call.setString(8, c.getAddress());
		call.setString(9, c.getCity());
		call.setInt(10, c.getZip());
		call.setString(11, c.getState());
		call.execute();
		
		// Executes call
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully updated customer " + c.getUsername() + "\n");
	}
}
