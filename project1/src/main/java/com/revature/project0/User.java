package com.revature.project0;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.revature.beans.Superhero;
import com.revature.util.ConnFactory;

public class User implements Serializable, UserDAO{
	public static ConnFactory cf =ConnFactory.getInstance();

	public static User defaultUser = getUsers().get(0);
	//private boolean admin = false;
	//private HashMap<String, String> loginInfo = new HashMap<String, String>() ;
	//private boolean active = false;
	//private double balance = 0;
	private int UserID;
	
	public boolean isAdmin() {
		//return admin;
	}
	public void setAdmin(boolean admin) {
		//this.admin = admin;
	}
	public HashMap<String, String> getLoginInfo() {
		//return loginInfo;
	}
	public void setLoginInfo(HashMap<String, String> loginInfo) {
		//this.loginInfo = loginInfo;
	}
	public boolean isActive() {
		//return active;
	}
	public void setActive(boolean active) {
		//this.active = active;
	}
	public double getBalance() {
		//return balance;
	}
	public void setBalance(double balance) {
		//this.balance = balance;
	}
	//THIS IS THE TRUE CONSTRUCTOR
	private User(int userID) {
		this.UserID=userID;
	}
	//THESE ARE PSUDOCONSTRUCTORS FOR BACKWARDS COMPATIBILITY
	private User(boolean admin,String username, String password, boolean active, double balance) {
		super();
		/*
		this.admin = admin;
		this.loginInfo.put(username, password);
		this.active = active;
		this.balance = balance;
		*/
	}
	public User(boolean admin, HashMap<String,String> logins, boolean active, double balance) {
		super();
		/*
		this.admin = admin;
		this.loginInfo = logins;
		this.active = active;
		this.balance = balance;
		*/
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
	@Override
	public void createUser(String userName) throws SQLException, NotPermittedException {
		// TODO Auto-generated method stub
		
	}
	public static List<User> getUsers() throws SQLException {
		List<User> userList = new ArrayList<>();

		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSERS");
		User user= null;
		while(rs.next()) {
			user = new User(rs.getInt(1));
			userList.add(user);
			
		}		return null;
	}
}
