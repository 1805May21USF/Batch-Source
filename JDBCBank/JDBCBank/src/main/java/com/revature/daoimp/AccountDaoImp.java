package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoImp implements AccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createAccount(Account account) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "AccountID";
		
		String sql = "INSERT INTO ACCOUNT VALUES(ACCOUNTIDSEQ.NEXTVAL, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, account.getClientID());
		ps.setDouble(2, account.getBalance());
		ps.executeUpdate();
		
		System.out.println("Account Successfully Created!");
	}

	public void deleteAccount(int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeQuery("DELETE FROM ACCOUNT WHERE ACCOUNTID = '" + accountID + "'");
	}

	public Account getAccountByID(int accountID) throws SQLException {
		Account a = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE ACCOUNTID = '" + accountID + "'");
		rs.next();
		a = new Account(accountID, rs.getInt(2), rs.getDouble(3));
		
		return a;
	}

	public Account getAccountByClient(int clientID) throws SQLException {
		Account a = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE CLIENTID = '" + clientID + "'");
		rs.next();
		a = new Account(rs.getInt(1), clientID, rs.getDouble(3));
		
		return a;
	}

	public List<Account> getAllAccounts() throws SQLException {
		List<Account> accountsList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		Account a = null;
		
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			accountsList.add(a);
		}
			
		return accountsList;
	}

	public void deposit(Account account, double ammount) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeQuery("UPDATE ACCOUNT SET BALANCE = '" + account.getBalance() + "' WHERE ACCOUNTID = '" + account.getAccountID() + "'");
	}

	public void withdraw(Account account, double ammount) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeQuery("UPDATE ACCOUNT SET BALANCE = '" + account.getBalance() + "' WHERE ACCOUNTID = '" + account.getAccountID() + "'");
	}

	public void transfer(Account acc1, Account acc2, double amount) {
		
		
	}
	

}
