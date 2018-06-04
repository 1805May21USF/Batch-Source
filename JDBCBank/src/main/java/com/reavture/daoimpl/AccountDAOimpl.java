package com.reavture.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.conn.ConnFactory;
import com.revature.beans.Account;
import com.revature.dao.AccountDAO;

public class AccountDAOimpl implements AccountDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	//create a new Account
	@Override
	public void addAccount(String username, double initAmount) throws SQLException {
		Connection conn = cf .getConnection();
		String sql = "INSERT INTO BANK_ACCOUNT VALUES (ACCOUNT_IDSEQ.NEXTVAL, ?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, getUserId(username));
			ps.setString(2, username);
			ps.setDouble(3, initAmount);
			ps.executeQuery();
			conn.close();
		}catch(SQLException e)
		{
			System.out.println("Couldn't register account at AccountDAOImpl:  " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	//get the user_id from the Usertable to add to the account table
	@Override
	public int getUserId(String username)throws SQLException
	{
		Connection conn = cf .getConnection();
		String sql = "SELECT USER_ID FROM BANK_USER WHERE USERNAME =  ? ";
		int id = 0;
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				id = rs.getInt(1);
			}
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println("Couldn't get User_Id at AccountDAOImpl:  " + e.getMessage());
			e.printStackTrace();
		}
		return id;
		
	}
	
	
	
	//retrieve an account with their account number
	@Override
	public Account getAccount(int accId) throws SQLException {
		Connection conn = cf .getConnection();
		
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_ID = '" + accId + "'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Account a = null;
			
			while(rs.next())
			{
				//returns id and balance
				//return transactions??
				a = new Account(rs.getInt(1), rs.getInt(2));
			}
			conn.close();
		}catch(SQLException e)
		{
			System.out.println("Couldn't get account at AccountDAOImpl:  " + e.getMessage());

		}
		
		
		return null;
	}

	//retrieve list of Accounts
	@Override
	public List<Account> getAccounts(String username) throws SQLException {
		Connection conn = cf .getConnection();
		List<Account> accounts = new ArrayList<Account>();
		
		String sql = ("SELECT ACCOUNT_ID, ACCOUNT_BALANCE FROM BANK_ACCOUNT WHERE USERNAME = ?");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			Account a = null;
			while(rs.next())
			{
				//POPULATE HERE
				a = new Account(rs.getInt(1), rs.getDouble(2));
				accounts.add(a);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("Couldn't get list of accounts at AccountDAOImpl:  " + e.getMessage());
		}
		return accounts;
	}
	
	
	//get account balance from username
	@Override
	public double getAccountBal(String username, int accountId) throws SQLException
	{
		double accountbalance = 0;
		ResultSet rs;
		Connection conn = cf .getConnection();
		String sql = "SELECT ACCOUNT_BALANCE FROM BANK_ACCOUNT WHERE USERNAME = ? AND ACCOUNT_ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, accountId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				accountbalance = rs.getDouble(1);
			}
			conn.close();
		}catch(SQLException e)
		{
			System.out.println("Couldn't register get account balance at AccountDAOImpl:  " + e.getMessage());

		}
		
		return accountbalance ;
	}
	
	//getting account_id from user_id
	@Override
	public int getAccountId(int userId) throws SQLException
	{
		Connection conn = cf .getConnection();
		int accountId = 0;
		String sql = "SELECT ACCOUNT_ID FROM BANK_ACCOUNT WHERE USER_ID = '" + userId + "'";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				accountId = rs.getInt(1);
			}
			conn.close();
		}catch(SQLException e)
		{
			System.out.println("Couldn't get accountId at AccountDAOImpl:  " + e.getMessage());

		}
		return accountId;
	}
	
	//update a account balance
	@Override
	public void updateAccountBal(String username, double amount, int accountId) throws SQLException {
		Connection conn = cf .getConnection();
		String sql = "UPDATE BANK_ACCOUNT SET ACCOUNT_BALANCE = ? WHERE USERNAME = ? AND ACCOUNT_ID = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, username);
			ps.setInt(3, accountId);
			ps.executeQuery();
			
			conn.close();
		}catch(SQLException e)
		{
			System.out.println("Couldn't update account balance at AccountDAOImpl:  " + e.getMessage());

		}

	}


	//delete an account with their username and accountId using a STORED PROCEDURE
	@Override
	public void deleteAccount(String username, int accountId) throws SQLException {
		Connection conn = cf .getConnection();
		String sql = "{call DELETEACCOUNT(?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username );
			cs.setInt(2, accountId);
			cs.execute();
			conn.close();
		}catch(SQLException e){
			System.out.println("Couldn't delete account at AccountDAOImpl:  " + e.getMessage());
			e.printStackTrace();
		}
	}

}
