package com.revature.project0;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable{
	public static User defaultUser = new User(false, "defaultUser", "", true,0);
	public boolean admin = false;
	public HashMap<String, String> loginInfo = new HashMap<String, String>() ;
	public boolean active = false;
	public double balance = 0;
	public User(boolean admin,String username, String password, boolean active, double balance) {
		super();
		this.admin = admin;
		this.loginInfo.put(username, password);
		this.active = active;
		this.balance = balance;
	}
	public User(boolean admin, HashMap<String,String> logins, boolean active, double balance) {
		super();
		this.admin = admin;
		this.loginInfo = logins;
		this.active = active;
		this.balance = balance;
	}
	@Override
	public boolean equals(Object u) {
		if (u instanceof User) {
			if (((User) u).active == this.active && ((User) u).admin == this.admin &&((User) u).balance == this.balance && ((User) u).loginInfo.equals(this.loginInfo) ) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "User [admin=" + admin + ", loginInfo=" + loginInfo + ", active=" + active + ", balance=" + balance
				+ "]";
	}
}
