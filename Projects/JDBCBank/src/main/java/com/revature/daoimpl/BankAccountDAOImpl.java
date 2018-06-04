package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.dao.BankAccountDAO;
import com.revature.util.ConnFactory;

/*
 * Implementation of the bank account DAO.
 */
public class BankAccountDAOImpl implements BankAccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public List<BankAccount> getBankAccounts() throws SQLException {
		List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNT ORDER BY BANK_ACCOUNT_ID";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		BankAccount a = null;
		
		while (rs.next()) {
			a = new BankAccount(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			bankAccounts.add(a);
		}
		conn.close();
		return bankAccounts;
	}

	@Override
	public void createBankAccount(BankAccount acc) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTBANK(?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setFloat(1, acc.getBalance());
		call.setInt(2, acc.getUser_ID());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteBankAccount(BankAccount acc) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call DELETEBANK(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, acc.getBank_account_ID());
		call.execute();
		conn.close();
	}

	@Override
	public void updateBankAccount(BankAccount acc) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call UPDATEBANK(?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, acc.getBank_account_ID());
		call.setDouble(2, acc.getBalance());
		call.setInt(3, acc.getUser_ID());
		call.execute();
		conn.close();
	}

	public List<BankAccount> getCustomerBankAccounts(int user_ID) throws SQLException {
		List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNT "
				+ "JOIN CUSTOMER_ACCOUNT "
				+ "ON CUSTOMER_ACCOUNT.USER_ID = BANK_ACCOUNT.USER_ID "
				+ "WHERE BANK_ACCOUNT.USER_ID = " + user_ID + " "
				+ "ORDER BY BANK_ACCOUNT_ID";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		BankAccount a = null;
		
		while (rs.next()) {
			a = new BankAccount(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			bankAccounts.add(a);
		}
		conn.close();
		return bankAccounts;
	}

	public BankAccount getByID(int bankAccountID) throws SQLException {
		List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = " + bankAccountID + " ORDER BY BANK_ACCOUNT_ID";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		BankAccount a = null;
		
		while (rs.next()) {
			a = new BankAccount(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			bankAccounts.add(a);
		}
		conn.close();
		return bankAccounts.get(0);
	}
}
