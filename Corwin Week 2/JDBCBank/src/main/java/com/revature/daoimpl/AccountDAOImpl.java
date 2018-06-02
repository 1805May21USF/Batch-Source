package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAO.AccountDAO;
import com.revature.beans.Account;
import com.revature.util.ConnFactory;

public class AccountDAOImpl implements AccountDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Account findAccount(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_ACCOUNT WHERE ACCOUNT_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		Account s = null;
		
		while(rs.next()) {
			s = new Account(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
		}
		conn.close();
		return s;
	}
	
	@Override
	public Account findAccountByFingerprint(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_ACCOUNT WHERE FINGERPRINT = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		Account s = null;
		
		while(rs.next()) {
			s = new Account(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
		}
		conn.close();
		return s;
	}

	@Override
	public ArrayList<Account> findAllAccounts() throws SQLException {
		ArrayList<Account> AccountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM JDBCBANK_ACCOUNT");
		Account s = null;
		
		while(rs.next()) {
			s = new Account(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
			AccountList.add(s);
		}
		conn.close();
		return AccountList;
	}

	@Override
	public void createAccount(Account account) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_account(?,?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, account.getFingerprint());
		ps.setDouble(2, account.getBalance());
		ps.setString(3, account.getStatus());
		ps.execute();
		conn.close();
	}

	@Override
	public void updateAccount(Account account) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_account(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, account.getID());
		call.setInt(2, account.getFingerprint());
		call.setDouble(2, account.getBalance());
		call.setString(3, account.getStatus());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteAccount(Account Account) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_account(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, Account.getID());
		ps.execute();
		conn.close();
		
	}

}
