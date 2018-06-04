package com.revature.bankingapp2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankingapp2.ConnFactory; 

public class CustomerTools
{
	//create an instance of ConnFactory
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//create a method to see if a customer exists in the database
	public boolean checkCustomer(String user) throws SQLException
	{
		
		Connection conn =  cf.getConnection();
		String sql = "SELECT * FROM BANK_CUSTOMER WHERE user = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		//1 is placeholder for ?
		ps.setString(1, user);
		
		ResultSet rs = ps.executeQuery();
		boolean exists = rs.next();
		
		conn.close();
		ps.close();
		rs.close();
		
		return exists;
	}
	
	//print customer from the database
	//TODO: Make sure this works
	public void printCustomer() throws SQLException
	{
		//create a Connection object that is assigned to the connection of cf
		Connection conn =  cf.getConnection();
		//create a SQL statement that will return all rows from BANK_CUSTOMER
		String sql = "SELECT * FROM BANK_CUSTOMER";
		//create a prepared statement
		PreparedStatement ps = conn.prepareStatement(sql);
		//create a result set
		ResultSet rs = ps.executeQuery();
		
		//close the connection, prepared statement, and result set
		conn.close();
		ps.close();
		rs.close();
	}
	
	//TODO: insert customer into the database
	public void insertCustomer(String username, String password) 
	{
		
	}
	
}
