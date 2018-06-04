package com.revature.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void createAccount(double account_balance, int account_number) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "account_number";
		String sql = "Insert into Accounts values(userseq.nextval, ?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setDouble(1, account_number);
		stmt.setDouble(2, account_balance);
		stmt.executeUpdate();
		conn.close();
	}

	public List<Account> getSuperHeroList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void createAccount(String Username, String Password, String accountNumber, double accountBalance)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public Account readAccount(String Username, String Password, int accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		Account account = null;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "account_number";
		String sql = "Select * from Accounts where account_number = ?";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setInt(1, accountNumber);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int account_id = rs.getInt(1);
			int account_number = rs.getInt(2);
			double account_balance = rs.getInt(3);
			account = new Account(account_number, account_balance, account_id);
		}
		conn.close();
		return account;
	}

	public void updateAccount(String Username, String Password, Account account, double newAmount) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = null;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "User_id";
		String sql = "UPDATE accounts SET account_balance = ? WHERE account_number = ?";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setDouble(1, newAmount);
		stmt.setInt(2, account.getAccountnumber());
		ResultSet rs = stmt.executeQuery();
		conn.close();
	}

	public void deleteAccount(String Username, String Password) throws SQLException {
		// TODO Auto-generated method stub
		Account account = null;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "account_id";
		String sql = "DELETE from acounts u where u.username = ?";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setString(1, Username);
		ResultSet rs = stmt.executeQuery();
		conn.close();
	}
	
	public void deleteAllAccounts() throws SQLException{
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "account_id";
		String sql = "DELETE from users u where u.status = ?";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setInt(1, 1);
		ResultSet rs = stmt.executeQuery();
		conn.close();
	}

	public List<Account> getAccount() throws SQLException {
			// TODO Auto-generated method stub
			List<Account> accountList = new ArrayList<Account>();
			Account account = null;
			Connection conn = cf.getConnection();
			String[] primaryKeys = new String[1];
			primaryKeys[0] = "account_number";
			String sql = "Select * from Accounts";
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int account_id = rs.getInt(1);
				int account_number = rs.getInt(2);
				double account_balance = rs.getInt(3);
				account = new Account(account_number, account_balance, account_id);
				accountList.add(account);
			}
			conn.close();
			return accountList;
	}

}
