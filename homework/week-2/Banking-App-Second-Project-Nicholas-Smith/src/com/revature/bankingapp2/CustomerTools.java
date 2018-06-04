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
		
	//TODO: insert customer into the database
	public void insertCustomer(String username, String password) throws SQLException
	{
		int userId;  
		
		//create a Connection object that is assigned to the connection of cf
		Connection conn =  cf.getConnection();
		
		//create an SQL statement that will retrieve the next value from USER_ID_SEQUENCE
		String sql = "SELECT USER_ID_SEQUENCE.NEXTVAL FROM DUAL";
		
		//create a prepared statement that will run the the first SQL statement
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//create a result set
		//assign userID to the next value in the sequence
		ResultSet rs = ps.executeQuery();
		rs.next();
		userId = rs.getInt(1);	

		//create a SQL statement that will insert a customer row into BANK_CUSTOMER
		String sql2 = "INSERT INTO BANK_CUSTOMER(USER_NAME, USER_PASSWORD, USER_ID) VALUES(?, ?, ?)";
		
		//create another prepared statement
		PreparedStatement ps2 = conn.prepareStatement(sql2);
			
		//set the first ? to the value of username
		ps2.setString(1, username);
		
		//set the second ? to the value of username
		ps2.setString(2, password);
		
		//set the second ? to next value of user_id_sequence
		ps2.setInt(3, userId);

		//execute the query
		rs = ps2.executeQuery();
		
		//close the connection, prepared statement, and result set
		conn.close();
		ps.close();
		rs.close();
		ps2.close();
	}
	
}
