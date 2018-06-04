package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;

public class AccountDAOImpl implements AccountDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createAccount(double balance,
			String accountStatus, int userId) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "ACCOUNT_NUMBER";
		String sql = 
				"INSERT INTO BANK_ACCOUNT VALUES(ACCOUNTSEQ.NEXTVAL,?,?,?)"; //? is a placeholder

		try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setDouble(1, balance);
			ps.setString(2, accountStatus);
			ps.setInt(3, userId);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		conn.close();
	}

	/*
	 * Retrieves the accounts of a specific user
	 */
	@Override
	public List<Account> retrieveUserAccounts(int userId) throws SQLException{
		List<Account> accountList = new ArrayList<>();

		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM BANK_ACCOUNT WHERE USER_ID = " + userId);
		Account acct = null;

		while (rs.next()) {
			//System.out.println("This user has an account");
			acct = new Account(rs.getInt(1), rs.getDouble(2),
					rs.getString(3), rs.getInt(4));
			accountList.add(acct);
		} 
		
		conn.close();
		return accountList;
	}
	
	/*
	 * Retrieves a specific account
	 */
	@Override
	public Account retrieveAccount(int accountNumber) throws SQLException{

		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM BANK_ACCOUNT "
				+ "WHERE ACCOUNT_NUMBER = " + accountNumber);
		Account acct = null;

		while (rs.next()) {
			//System.out.println("This user has an account");
			acct = new Account(rs.getInt(1), rs.getDouble(2),
					rs.getString(3), rs.getInt(4));
			
			conn.close();
			return acct;
		} 

		return null;
	}

	@Override
	public List<Account> retrieveAllAccounts() throws SQLException {
		List<Account> accountList = new ArrayList<>();

		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM BANK_ACCOUNT");
		Account acct = null;

		while (rs.next()) {
			//System.out.println("This user has an account");
			acct = new Account(rs.getInt(1), rs.getDouble(2),
					rs.getString(3), rs.getInt(4));
			accountList.add(acct);
		} 

		conn.close();
		return accountList;
	}

	@Override
	public void updateAccount(int accountNumber,
			double amount) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM BANK_ACCOUNT WHERE"
						+ " ACCOUNT_NUMBER = " + accountNumber);

		if(rs.next()) {
			String[] primaryKeys = new String[1];
			primaryKeys[0] = "ACCOUNT_NUMBER";
			String sql =
					"UPDATE BANK_ACCOUNT SET BALANCE = "+ amount
					+ " WHERE ACCOUNT_NUMBER = " + accountNumber;
			try {
				PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Bank account not found.");
				e.printStackTrace();
			}
		}
		conn.close();
	}

	@Override
	public void deleteAccount(String accountNumber) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute("DELETE FROM BANK_ACCOUNT"
				+ " WHERE ACCOUNT_NUMBER = " + accountNumber);
		conn.close();
	}

}
