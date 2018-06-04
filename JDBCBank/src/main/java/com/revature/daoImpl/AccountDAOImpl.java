package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.Connect2DB;

public class AccountDAOImpl implements AccountDAO {

	public static Connect2DB cdb = Connect2DB.getInstance();

	//user can view all the accounts using this method just by passing the userid
	public List<Account> getUserAccount(int userID) throws SQLException {
		List<Account> userAccount = new ArrayList<Account>();
		Connection conn = cdb.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNTS WHERE USERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		Account ac = null;
		
		while(rs.next()) {
			ac = new Account(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			userAccount.add(ac);
		}
		conn.close();
		return userAccount;
	}

	//this method creates the sql statement to create new account for a registered user
	public void createAccount(int userID) throws SQLException {
		Connection conn = cdb.getConnection();
		String sql = "{call CREATE_ACCOUNT(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.execute();
	}

	//this method creates the sql statement to delete user account (user action)
	public void deleteAccount(Account ac) throws SQLException {
		Connection conn = cdb.getConnection();
		String sql = "{call DELETE_ACCOUNT(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ac.getAccountID());
		call.execute();
	}
	
	//this method updates the balance of the user in the database
	public void updateAccount(Account ac, float balance) throws SQLException{
		Connection conn = cdb.getConnection();
		String sql = "{call UPDATE_BALANCE(?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ac.getAccountID());
		call.setFloat(2, balance);
		call.execute();
		conn.close();
	}

}
