package app;

import java.util.ArrayList;

public class Account {
	//account data
	private String accountNum;
	private Permission accessLevel;
	
	//user data
	private String name;
	private String username;
	private String password;
	private double funds;
	
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public Permission getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(Permission accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public ArrayList<Integer> getJointUser() {
		return jointUser;
	}

	public void setJointUser(ArrayList<Integer> jointUser) {
		this.jointUser = jointUser;
	}

	//for if they set up a joint account
	ArrayList<Integer> jointUser = new ArrayList<Integer>();
	
	//setting up admin levels
	public enum Permission {
		CUSTOMER,
		EMPLOYEE,
		ADMIN
	}
	
	public Account() {
		this.accessLevel = Permission.CUSTOMER;
		this.username = "default";
		this.password = "password";
		this.funds = 0;
	}
	public Account(Permission level, String username, String password) {
		this.accessLevel = level;
		this.username = username;
		this.password = password;
		this.funds = 0;
	}
	public Account(String accountNum, Permission accessLevel, String name, String username, String password, double funds) {
		this.accountNum = accountNum;
		this.accessLevel = accessLevel;
		this.name = name;
		this.username = username;
		this.password = password;
		this.funds = funds;
	}
	
	public boolean Login(String triedUsername, String triedPassword) {
		if (this.username.equals(triedUsername) && this.password.equals(triedPassword)) { return true; }
		return false;
	}
}
