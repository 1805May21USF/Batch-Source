package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
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
		
		
	}

	public void deleteAccount(int accountID) throws SQLException {
		
		
	}

	public Account getAccountByID(int accountID) throws SQLException {
		
		return null;
	}

	public Account getAccountByClient(int clientID) throws SQLException {
		
		return null;
	}

	public List<Account> getAllAccounts() throws SQLException {
		
		return null;
	}

	public void deposit(Account account, double ammount) {
		
		
	}

	public void withdraw(Account account, double ammount) {
		
		
	}

	public void transfer(Account acc1, Account acc2, double amount) {
		
		
	}

}
