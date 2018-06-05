package com.revature.driver;
//import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import org.junit.Test;


public class BankPerson implements BankPersonDAO {

	/**
	 * 
	 */
	/**
	 * 
	 */
	
	private int rank;
	public static ConnFactory cf = ConnFactory.getInstance();

	
	
	protected String firstName;
	protected String  lastName;

	protected String userName;
	private String password;
	public ArrayList<Account> accountList;
	public BankPerson() {
		
	}
	
	public BankPerson(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public BankPerson(String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public int loggingIn() {
		return rank;
	}
	
	public String getUser() {
		return userName;
	}

	public boolean checkPass(String possiblePass) {
		return (possiblePass.equals(password));
	}
	
	public boolean createBankPerson(String name, String pass, int rank, String fn, String ln) {
		
		Connection conn = cf.getConnection();
		String sql = "{call ADDUSER(?,?,?,?,?)}";
		CallableStatement call;
			
			try {
				call = conn.prepareCall(sql);
				call.setString(1, name);
				call.setString(2, pass);
				call.setInt(3, rank);
				call.setString(4, fn);
				call.setString(5, ln);
				call.execute();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		
		
		return true;
		
	}
	public boolean deleteBankPerson(String name) {
		Connection conn = cf.getConnection();
		String sql = "{call DELETEUSER(?)}";
		
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setString(1,name);
			call.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public void printInfo(int id) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER WHERE USER_ID = " + Integer.toString(id) );
		
		rs.next();
		
		System.out.println("Hello! Your name on record is " + rs.getString(5)+" " + rs.getString(6) + ".");
		System.out.println("Your user name is " +rs.getString(2));
		
		conn.close();
	}
	
	
	public boolean userExists(String usr) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER WHERE USERNAME = " + usr);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*	public void createAccount(String name, String type, int rank) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "call ADDACCOUNT(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,name);
		call.setString(2, type);
		call.setInt(3, rank);
		call.execute();
		conn.close();
	}
	
	public void deleteAccount(String name) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "call DELETEACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,name);
		call.execute();
		conn.close();
		
	}
	 * 
	 * 
	 */
	
	
}
