package com.revature.project0;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class User implements Serializable, UserDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4758392937390992554L;

	public static ConnFactory cf =ConnFactory.getInstance();
	
	public static User defaultUser;
	static {
		try {
			defaultUser = getUser("defaultUser");
		} catch (SQLException e) {
			System.err.println("ERROR! We got an SQL execption from getuser!");
			e.printStackTrace();
		}
		if (defaultUser == null){
			System.err.println("ERROR! We failed to get the default user!");
		}


	}
	//private boolean admin = false;
	//private HashMap<String, String> loginInfo = new HashMap<String, String>() ;
	//private boolean active = false;
	//private double balance = 0;
	private int UserID;
	
	public boolean isAdmin() {
		//return admin;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "select ISADMIN from BANKUSERS where USERID= ?";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, this.UserID);
		ResultSet rs;

			rs = ps.executeQuery();
		if (!rs.next()) {
			return false;
		}
		return rs.getBoolean(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void setAdmin(boolean admin) {
		//this.admin = admin;
		//return admin;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "update BANKUSERS set ADMIN = ? where USERID= ?";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setBoolean(1, admin);
		ps.setInt(2, this.UserID);
		ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  HashMap<String, String> getLoginInfo() {
		//return loginInfo;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "select USERNAME, PASSWD from BANKUSERSLOGINS where USERID= ?";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, this.UserID);
		ResultSet rs;

			rs = ps.executeQuery();
		HashMap<String, String> logins = new HashMap<>();
		while( rs.next()) {
			logins.put(rs.getString(1), rs.getString(2));
		}
		return logins;
		} catch (SQLException e) {
			System.err.println("failed to get login info for user " + this.UserID);
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean isActive() {
		//return active;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "select ISACTIVE from BANKUSERS where USERID= ?";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, this.UserID);
		ResultSet rs;

			rs = ps.executeQuery();
			if (!rs.next()) {
				return false;
			}
		return rs.getBoolean(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void setActive(boolean active) {
		//this.active = active;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "update BANKUSERS set ISACTIVE = ? where USERID= ?";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setBoolean(1, active);
		ps.setInt(2, this.UserID);
		ps.executeUpdate();

		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double getBalance() {
		//return balance;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "select BALANCE from BANKUSERS where USERID= ?";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, this.UserID);
		ResultSet rs;

			rs = ps.executeQuery();
		if (!rs.next()) {
			return -666;
		}
		return rs.getDouble(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -666;
	}
	public void setBalance(double balance) {
		//this.balance = balance;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "update BANKUSERS set BALANCE = ? where USERID= ?";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setDouble(1, balance);
		ps.setInt(2, this.UserID);
		ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//THIS IS THE TRUE CONSTRUCTOR
	private User(int userID) {
		this.UserID=userID;
	}
	//THESE ARE PSUDOCONSTRUCTORS FOR BACKWARDS COMPATIBILITY

	public User(boolean admin, HashMap<String,String> logins, boolean active, double balance) throws SQLException, NotPermittedException{
		super();
		/*
		this.admin = admin;
		this.loginInfo = logins;
		this.active = active;
		this.balance = balance;
		*/
		Connection conn = cf.getConnection();
		conn.createStatement().executeUpdate("SET TRANSACTION NAME 'insertUser'");

		String sql = "{? = call INSERTUSER(?, ?, ?)}";
		CallableStatement call = conn.prepareCall(sql);
	    call.registerOutParameter (1, Types.INTEGER);
	    
		call.setBoolean(2, admin);
		call.setBoolean(3, active);
		call.setDouble(4, balance);
		call.executeUpdate();
		UserID =call.getInt(1);
		//create the user's login info
		
		for (Entry<String, String> pair : logins.entrySet()) {
			if (!addAlias(pair.getKey(), pair.getValue())) {
				//ABORT!
				conn.createStatement().executeUpdate("ROLLBACK");
				throw new NotPermittedException("Error! Username is in use, or has problem!");
			}
		}
		conn.createStatement().executeUpdate("COMMIT");

	}
	
	public boolean addAlias(String username, String password) {
		//create the user's login info
		Connection conn = cf.getConnection();
		
		String loginInsert = "{call INSERTLOGIN(?, ?, ?)}";
		try {		
		CallableStatement insertCall = conn.prepareCall(loginInsert);
				insertCall.setInt(1, UserID);
			
					insertCall.setString(2,username);
				
				insertCall.setString(3, password);
				insertCall.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object u) {
		if (u instanceof User) {
			if (((User) u).isActive() == this.isActive() && ((User) u).isAdmin() == this.isAdmin() &&((User) u).getBalance() == this.getBalance() && ((User) u).getLoginInfo().equals(this.getLoginInfo()) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", isAdmin()=" + isAdmin() + ", getLoginInfo()=" + getLoginInfo()
				+ ", isActive()=" + isActive() + ", getBalance()=" + getBalance() + "]";
	}
	
	public static List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		try {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs;

			rs = stmt.executeQuery("SELECT * FROM BANKUSERS");
		User user= null;
		while(rs.next()) {
			user = new User(rs.getInt(1));
			userList.add(user);
			
		}	
		} catch (SQLException e) {
			System.err.println("ERROR! Failed to get the BANKUSERS table. Sorry, but this problem is unrecoverable.");
			e.printStackTrace();
		}
		return userList;
	}
	public static User getUser(String username) throws SQLException {
		//prepared statement
			Connection conn = cf.getConnection();
			String[] primaryKeys = new String[1];
			primaryKeys[0] = "USERID";
			String sql = "select USERID from BANKUSERSLOGINS where USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getInt(1));
			}
			return null;
	}
	public static void commitAndClose() {
		Connection conn = cf.getConnection();
		try {
			conn.createStatement().executeUpdate("COMMIT");
		} catch (SQLException e) {
			System.err.println("FAILED TO COMMIT! OH GEEZ! " + e.getMessage());
			e.printStackTrace();
		}

	}
}
