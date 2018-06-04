package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.B_Account;
import com.revature.dao.B_AccountDAO;
import com.revature.util.ConnFactory;

public class B_AccountDAOImpl implements B_AccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createBankAccount(float acctBal, int makerID) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call INSERTACCOUNT(?, ?, ?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setFloat(1, acctBal);
		String second = Float.toString(acctBal);
		call.setString(2, second);
		call.setInt(3, makerID);
		call.execute();
		conn.close();
	}

	public List<B_Account> getBankAccountList() throws SQLException {
		// TODO Auto-generated method stub
		List<B_Account> accountList = new ArrayList<B_Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM B_ACCOUNT");
		B_Account s = null;
		
		//do not start from 0
		while(rs.next()) {
			s = new B_Account(rs.getInt(1), rs.getFloat(2), rs.getString(3));
			accountList.add(s);
		}
		conn.close();
		return accountList;
	}
	
	public List<B_Account> getMyAccountList(int uID) throws SQLException {
		// TODO Auto-generated method stub
		List<B_Account> accountList = new ArrayList<B_Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		//String temp = String.valueOf(uID);
		String composeString = "SELECT B_ACCOUNT.* " + 
				"FROM B_USER " + 
				"JOIN B_USER_ACCT_REF" + 
				" ON B_USER.USER_ID = B_USER_ACCT_REF.USER_ID " + 
				"JOIN B_ACCOUNT" + 
				" ON B_ACCOUNT.ACCOUNT_ID = B_USER_ACCT_REF.ACCOUNT_ID " + 
				"WHERE B_USER.USER_ID = "+ uID;
		//System.out.println(composeString);
		ResultSet rs = stmt.executeQuery(composeString);
		
		B_Account s = null;
		
		//do not start from 0
		while(rs.next()) {
			s = new B_Account(rs.getInt(1), rs.getFloat(2), rs.getString(3));
			accountList.add(s);
		}
		conn.close();
		return accountList;
	}
	
	
}

