/**
 * This class interacts with the BANCK_CUSTOMER table.
 */
package com.revature.bankingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Nicholas Smith
 *
 */
public class AccountTools
{
	//create an instance of ConnFactory
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	int bankAccountId;
	int userId;
	double balance;
	
	//getters and setters
	public int getBankAccountId()
	{
		return bankAccountId;
	}

	public void setBankAccountId(int bankAccountId)
	{
		this.bankAccountId = bankAccountId;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	
		public void insertAccount(int userId) throws SQLException
		{
			
			//create a Connection object that is assigned to the connection of cf
			Connection conn =  cf.getConnection();
			
			//create an SQL statement that will retrieve the next value from BANK_ACCOUNT_ID_SEQUENCE
			String sql = "SELECT BANK_ACCOUNT_ID_SEQUENCE.NEXTVAL FROM DUAL";
			
			//create a prepared statement that will run the the first SQL statement
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//create a result set
			//assign bankAccountId to the next value in the sequence
			ResultSet rs = ps.executeQuery();
			rs.next();
			bankAccountId = rs.getInt(1);	
			
			
			//create a SQL statement that will insert a account row into BANK_ACCOUNT
			String sql2 = "INSERT INTO BANK_ACCOUNT(BANK_ACCOUNT_ID, USER_ID, BALANCE) VALUES(?, ?, ?)";
			
			//create another prepared statement
			PreparedStatement ps2 = conn.prepareStatement(sql2);
				
			//set the first ? to the value of bankAccountId
			ps2.setInt(1, bankAccountId);
			
			//set the second ? to the value of userId
			ps2.setInt(2, userId);
			
			//set the third ? to next value of user_id_sequence
			ps2.setDouble(3, balance);	

			//execute the query
			rs = ps2.executeQuery();
			
			//close the connection, prepared statements, and result set
			conn.close();
			ps.close();
			rs.close();
			ps2.close();
			
		}
		
		//create a method to view balance
		public double getDatabaseBalance(int userId) throws SQLException 
		{
			int dbUserId = userId;
			
			
			Connection conn =  cf.getConnection();
			
			//SQL statements that grabs the balance from the customer
			String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE USER_ID = ?";
			
			//use a prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			//assign ? to userId
			ps.setInt(1, dbUserId);

			ResultSet rs = ps.executeQuery();
			rs.next();
			balance = rs.getDouble(1);
						
			conn.close();
			ps.close();
			rs.close();
			
			return balance;
		}
		
}
