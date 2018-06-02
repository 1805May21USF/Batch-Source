package com.revature.JDBCBankTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.implementdao.ImpBankAccountDAO;
import com.revature.implementdao.ImpUserDAO;
import com.revature.util.ConnFactory;

class BankAccountTest {
	private static String firstname = "Bank";
	private static String lastname = "Account";
	private static String username = "banky";
	private static String password = "1";
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Test
	void testBankInsert() throws SQLException {
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser(firstname, lastname, username, password);
		User u = iud.getUserByCredentials(username, password);
		ImpBankAccountDAO ibad = new ImpBankAccountDAO();
		int oldsize = ibad.getBankAccountList().size();
		
		Connection conn = cf.getConnection();
				
		String sql = "{call INSERTBANKACCOUNT(?)";
		
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, u.getId());
		call.execute();
		
		int newsize = ibad.getBankAccountList().size();
		ibad.deleteBankAccount(ibad.getUserBankAccounts(u.getId()).get(0).getAccountid());
		iud.deleteUser(username);
		assertTrue(newsize>oldsize);
	}
	
	@Test
	void testBankRead() throws SQLException {
		Connection conn = cf.getConnection();
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser(firstname, lastname, username, password);
		User u = iud.getUserByCredentials(username, password);
		ImpBankAccountDAO ibad = new ImpBankAccountDAO();
		ibad.createBankAccount(u.getId());
		List<BankAccount> bankAccountList = new ArrayList<BankAccount>();
		String sql = "SELECT * FROM BANK_ACCOUNT";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		BankAccount b = null;
		
		while(rs.next()) {
			b=new BankAccount(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			bankAccountList.add(b);
		}
		ibad.deleteBankAccount(ibad.getUserBankAccounts(u.getId()).get(0).getAccountid());
		iud.deleteUser(username);
		assertTrue(bankAccountList.size()>0);
	}
	
	@Test
	void testUserAccountsRead() throws SQLException {
		Connection conn = cf.getConnection();
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser(firstname, lastname, username, password);
		User u = iud.getUserByCredentials(username, password);
		ImpBankAccountDAO ibad = new ImpBankAccountDAO();
		ibad.createBankAccount(u.getId());
		List<BankAccount> bankAccountList = new ArrayList<BankAccount>();
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE USERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u.getId());
		ResultSet rs = ps.executeQuery();
		BankAccount b = null;
		
		while(rs.next()) {
			b=new BankAccount(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			bankAccountList.add(b);
		}
		ibad.deleteBankAccount(ibad.getUserBankAccounts(u.getId()).get(0).getAccountid());
		iud.deleteUser(username);
		assertTrue(bankAccountList.size()>0);
	}
	
	@Test
	void testBankDelete() throws SQLException {
		Connection conn = cf.getConnection();
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser(firstname, lastname, username, password);
		User u = iud.getUserByCredentials(username, password);
		ImpBankAccountDAO ibad = new ImpBankAccountDAO();
		ibad.createBankAccount(u.getId());
		int oldsize = ibad.getBankAccountList().size();
		
				
		String sql = "{call DELETEBANKACCOUNT(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ibad.getUserBankAccounts(u.getId()).get(0).getAccountid());
		call.execute();
		iud.deleteUser(username);
		int newsize = ibad.getBankAccountList().size();
		assertTrue(newsize<oldsize);
	}
	
	@Test
	void testBankUpdate() throws SQLException {
		Connection conn = cf.getConnection();
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser(firstname, lastname, username, password);
		User u = iud.getUserByCredentials(username, password);
		ImpBankAccountDAO ibad = new ImpBankAccountDAO();
		ibad.createBankAccount(u.getId());
		
		String sql = "{call UPDATEBANKACCOUNT(?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ibad.getUserBankAccounts(u.getId()).get(0).getAccountid());
		call.setFloat(2, 30.00f);
		call.setInt(3, u.getId());
		call.execute();
		ibad.deleteBankAccount(ibad.getUserBankAccounts(u.getId()).get(0).getAccountid());
		iud.deleteUser(username);
	}

}
