package com.revature.jdbcbankproj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Users {

	int userid;
	String username;
	String fname;
	String lname;
	String passwd;
	String DOB;
	int usertypeid;
	String createddate;
	int userstatusid;
	
	
	public int GetUserID(String usern, String passw) {
		// Retrieve UserID
		
		int userid_GetUserID = 0;
		Statement stmt;
		Connection conn = MainDriver.cf.getConnection();
		
		try {
			stmt = conn.createStatement();
			//System.out.println("usern: " + usern);
			//System.out.println("passw: " + passw);
			String sqlString = "SELECT USER_ID FROM USERS WHERE USERNAME = '" + usern + "' AND USER_PASWD = '" + passw + "'";
			//System.out.println(sqlString);
			
			ResultSet result = stmt.executeQuery(sqlString);
			
			while(result.next()) {
				//System.out.println("USER ID: " + result.getInt("USER_ID"));
				userid_GetUserID = result.getInt("USER_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userid_GetUserID;
	}
	
	public void SetUser(int user_id) {
		
		Statement stmt;
		Connection conn = MainDriver.cf.getConnection();
		
		try {
			stmt = conn.createStatement();
			String sqlString = String.format("SELECT * FROM USERS WHERE USER_ID = " + user_id);
			ResultSet result = stmt.executeQuery(sqlString);
			
			while(result.next()) {
				
				this.userid = result.getInt("USER_ID");
				this.username = result.getString("USERNAME");
				this.fname = result.getString("USER_FNAME");
				this.lname = result.getString("USER_LNAME");
				this.userstatusid = result.getInt("USER_STATUS_ID");
				this.usertypeid = result.getInt("USER_TYPE_ID");
				
				//System.out.println("USER ID: " + this.userid);
				//System.out.println("FNAME: " + this.fname);
				//System.out.println("LNAME: " + this.lname);
				//System.out.println("USER STATUS: " + this.userstatusid);
				//System.out.println("USER TYPE: " + this.usertypeid);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean CheckUsername(String usern) {
		// Check if Username exists.
		this.username = usern;
		boolean usern_exists = false;
		PreparedStatement stmt;
		Connection conn = MainDriver.cf.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT USERNAME FROM USERS WHERE USERNAME = ?");
			stmt.setString(1, this.username);
			
			MainDriver.log.info(stmt.toString());
			
			int cu = stmt.executeUpdate();
			
			if(cu > 0) {
				System.out.println("User " + this.username + " exists.");
				usern_exists = true;
			}
			else {
				System.out.println("User " + this.username + " does not exist.");
				usern_exists = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(usern_exists == true) {
			return true;
		}
		else {
			return false;
		}
		
		
		
		// If username exists, return true.
		
		// If username does not exist, return false.
		
		
		
	}
	
	public boolean CheckUserStatus(String usern) {
		// Check status of user
		
		
		// If status is "CLOSED", return false
		
		// If status is "ACTIVE", return true.
		return false;
	}
	
	public boolean CheckUsernameAndPass(String usern, String passw) {
		// Check if Username and password exists.
		this.username = usern;
		this.passwd = passw;
		boolean usern_pass_exists = false;
		PreparedStatement stmt;
		Connection conn = MainDriver.cf.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT USERNAME FROM USERS WHERE USERNAME = ? AND USER_PASWD = ?");
			stmt.setString(1, this.username);
			stmt.setString(2, this.passwd);
			
			MainDriver.log.info(stmt.toString());
			
			int cu = stmt.executeUpdate();
			
			if(cu > 0) {
				System.out.println("User " + this.username + " exists.");
				usern_pass_exists = true;
			}
			else {
				System.out.println("User " + this.username + " and password combo does not exist.");
				usern_pass_exists = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(usern_pass_exists == true) {
			return true;
		}
		else {
			return false;
		}
				
	}
	
	
	public void CreateUsers(String usern) {
		MainDriver.log.info("In CreateUsers(): ");
		this.username = usern;
		Scanner scanCU = new Scanner(System.in);
		
		System.out.println("Password: ");
		this.passwd = scanCU.next();
		System.out.println("Password: " + this.passwd);
		
		System.out.print("First Name: ");
		this.fname = scanCU.next();
		System.out.println("First Name: " + this.fname);
		
		System.out.println("Last Name: ");
		this.lname = scanCU.next();
		System.out.println("Last Name: " + this.lname);
		
		System.out.println("Date Of Birth (YYYY-MM-DD): ");
		this.DOB = scanCU.next();
		System.out.println("DOB: " + this.DOB);
		
		
		PreparedStatement stmt;
		
		Connection conn = MainDriver.cf.getConnection();
		try {
			stmt = conn.prepareStatement("INSERT INTO USERS VALUES (SEQ_CREATE_USER_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE)");
			
			stmt.setString(1, this.username);
			stmt.setString(2, this.fname);
			stmt.setString(3, this.lname);
			stmt.setString(4, this.passwd);
			stmt.setDate(5, java.sql.Date.valueOf(this.DOB));
			stmt.setInt(6, 2);
			stmt.setInt(7, 1);
			
			MainDriver.log.info(stmt.toString());
			
			int cu = stmt.executeUpdate();
			
			if(cu > 0) {
				System.out.println("User has been created.");
			}
			else {
				System.out.println("Failed to create user.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 
		
		
		// User type 2 = customer. User status 1 = active.
		
	}
	
	
}
