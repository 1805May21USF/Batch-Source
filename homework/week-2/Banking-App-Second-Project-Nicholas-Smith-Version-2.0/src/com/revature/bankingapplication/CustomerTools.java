/**
 * This class interacts with the BANCK_CUSTOMER table.
 */
package com.revature.bankingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankingapplication.ConnFactory; 

/**
 * @author Nicholas Smith
 *
 */
public class CustomerTools
{
	//create an instance of ConnFactory
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//new instance variables
	int userId;
	String firstName;
	String lastName;
	String userName;
	String userPassword;
	
	//getters and setters
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	//create a method to see if a customer exists in the database
	public boolean checkCustomer(String username, String password) throws SQLException
	{
		
		Connection conn =  cf.getConnection();
		String sql = "SELECT * FROM BANK_CUSTOMER WHERE USER_NAME = ? AND USER_PASSWORD = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		//1 is placeholder for ?
		ps.setString(1, username);
		
		//2 is the placeholder for the second ?
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		boolean exists = rs.next();
		
		conn.close();
		ps.close();
		rs.close();
		
		return exists;
	}
		
	//insert customer into the database
	public void insertCustomer(String username, String password, String firstName, String lastName) throws SQLException
	{
		
		userName = username;
		userPassword = password;
		this.firstName = firstName;
		this.lastName = lastName;
		 
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
		String sql2 = "INSERT INTO BANK_CUSTOMER(USER_NAME, USER_PASSWORD, USER_ID, FIRST_NAME, LAST_NAME) VALUES(?, ?, ?, ?, ?)";
		
		//create another prepared statement
		PreparedStatement ps2 = conn.prepareStatement(sql2);
			
		//set the first ? to the value of username
		ps2.setString(1, userName);
		
		//set the second ? to the value of password
		ps2.setString(2, userPassword);
		
		//set the third ? to next value of user_id_sequence
		ps2.setInt(3, userId);

		//set the fourth ? to next value of firstName
		ps2.setString(4, lastName);
				
		//set the fifth ? to next value of lastName
		ps2.setString(5, firstName);		

		//execute the query
		rs = ps2.executeQuery();
		
		//close the connection, prepared statements, and result set
		conn.close();
		ps.close();
		rs.close();
		ps2.close();
	}
	
	//TODO: create a method that returns the userid from the database
	public int getDatabaseUserId(String userName, String userPassword) throws SQLException
	{
				userId = 0;
				this.userName = userName;
				this.userPassword = userPassword;
				
				//create a Connection object that is assigned to the connection of cf
				Connection conn =  cf.getConnection();
				
				//create an SQL statement that will retrieve the next value from USER_ID_SEQUENCE
				String sql = "SELECT USER_ID FROM BANK_CUSTOMER WHERE USER_NAME = ? AND USER_PASSWORD = ?";
				
				//create a prepared statement that will run SQL statement
				PreparedStatement ps = conn.prepareStatement(sql);
				
				//assign the first ? to userName
				ps.setString(1, userName);
				
				//assign the second ? to userPassword
				ps.setString(2, userPassword);
				
				//create a result set
				ResultSet rs = ps.executeQuery();
				rs.next();
				userId = rs.getInt(1);		
				
				conn.close();
				ps.close();
				rs.close();
				
				return userId;
	}

	@Override
	public String toString()
	{
		return "CustomerTools [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName
				+ ", userPassword=" + userPassword + "]";
	}
	
	
}
