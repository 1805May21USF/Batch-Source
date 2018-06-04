package com.revature.DAOImple;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;

public class AccountDAOImple implements AccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createAccount(int userID, float balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTACCOUNT(?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.setFloat(2, balance);
		call.execute();
		conn.close();
		// TODO Auto-generated method stub
		
	}
	public List<Account> getUserAccountsList(int userID) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn= cf.getConnection();//line needed in each method
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACCOUNTS.USERID = "+ userID);
		Account a = null;
		
		while(rs.next()) {
			a = new Account(rs.getFloat(3),rs.getInt(2),rs.getInt(1));
			accountList.add(a);
		}
		rs.close();
		conn.close();
		return accountList;
		
	}
		public boolean withdraw(int accountID,float amount) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "{call WITHDRAWACCOUNT(?,?)";
			
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, accountID);
			call.setFloat(2, amount);
			call.execute();
			conn.close();
			return true;
		}
		public void deposit(int accountID,float amount) throws SQLException{
			Connection conn = cf.getConnection();
			String sql = "{call DEPOSITACCOUNT(?,?)";
			
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, accountID);
			call.setFloat(2, amount);
			call.execute();
			conn.close();
		}
		public void deleteAccount(int accountID) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "{call DELETEACCOUNT(?)";
			
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, accountID);
			call.execute();
			conn.close();
		}

}
