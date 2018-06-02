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

class UserTest {
	public static ConnFactory cf = ConnFactory.getInstance();
	private static String username = "bobby22";
	private static String password = "22";
	private static String firstname = "Bobby";
	private static String lastname = "Jones";
	
	@Test
	void testUserByUsername() throws SQLException {
		Connection conn = cf.getConnection();
		ImpUserDAO iud = new ImpUserDAO();
		User usr = new User();
		iud.insertUser(firstname, lastname, username, password);
		String sql = "SELECT * FROM USERS WHERE USERNAME=? FETCH FIRST 1 ROWS ONLY";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			usr.setId(rs.getInt(1));
			usr.setFirstname(rs.getString(2));
			usr.setLastname(rs.getString(3));
			usr.setUsername(rs.getString(4));
			usr.setPassword(rs.getString(5));
		}
		iud.deleteUser(username);
		assertTrue(usr.getUsername().equals(username));
	}
	@Test
	void testCreateDeleteAccount() throws SQLException {
		ImpBankAccountDAO ibad = new ImpBankAccountDAO();
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser(firstname, lastname, username, password);
		User test = iud.getUserByCredentials(username, password);
		ibad.createBankAccount(test.getId());
		List<BankAccount> accounts1= ibad.getBankAccountList();
		int oldsize = accounts1.size();
		ibad.deleteBankAccount(ibad.getUserBankAccounts(test.getId()).get(0).getAccountid());
		List<BankAccount> accounts2 = ibad.getBankAccountList();
		int newsize = accounts2.size();
		iud.deleteUser(username);
		assertTrue(oldsize>newsize);
	}
	@Test
	void testSQLRead(){
		Connection conn = cf.getConnection();
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM USERS";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			User u = null;
			
			while(rs.next()) {
				u=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				userList.add(u);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		assertTrue(userList.size()>0);
	}
	
	@Test
	void testSQLInsert() throws SQLException {
		ImpUserDAO iud = new ImpUserDAO();
		int oldsize = iud.getUserList().size();
		
		Connection conn = cf.getConnection();
				
		String sql = "{call INSERTUSER(?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, firstname);
		call.setString(2, lastname);
		call.setString(3, username);
		call.setString(4, password);
		call.execute();
		
		int newsize = iud.getUserList().size();
		assertTrue(newsize>oldsize);
		
		iud.deleteUser(username);
	}
	
	@Test
	void testSQLLogin() throws SQLException {
		User usr = new User();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME='nlow2492' AND PASSWORD='wewe' FETCH FIRST 1 ROWS ONLY";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		while(rs.next()) {
			usr.setId(rs.getInt(1));
			usr.setFirstname(rs.getString(2));
			usr.setLastname(rs.getString(3));
			usr.setUsername(rs.getString(4));
			usr.setPassword(rs.getString(5));
		}
		assertTrue(usr.getFirstname().equals("Nicholas"));
	}
	
	@Test 
	void testSQLDelete() throws SQLException {
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser("Happy", "Go", "happy2", "2");
		int oldsize = iud.getUserList().size();
		
		Connection conn = cf.getConnection();
				
		String sql = "{call DELETEUSER(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, "happy2");
		call.execute();
		
		int newsize = iud.getUserList().size();
		assertTrue(newsize<oldsize);
	}
	
	@Test
	void testSQLUpdate() throws SQLException {
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser("Bobby", "Jones", "bobby22", "42");
		
		User test = iud.getUserByCredentials("bobby22", "42");
		test.setLastname("Fork");
		Connection conn = cf.getConnection();
	
		String sql = "{call UPDATEUSER(?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, test.getId());
		call.setString(2, test.getFirstname());
		call.setString(3, test.getLastname());
		call.setString(4, test.getUsername());
		call.setString(5, test.getPassword());
		call.execute();
		
		User test1 = iud.getUserByCredentials("bobby22", "42");
		iud.deleteUser("bobby22");
		assertTrue(test1.getLastname() != "Fork");
	}
	

}
