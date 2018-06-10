package com.revature.banking_app;
//Class to hold User information
public class User
{
	
	
	
	//Level of permissions a user has
	public static enum LevelOfAccess 
	{
		Customer,
		Employee,
		Admin;
	}
	
	private String loginName;
	private String password;
	private String fullName;
	public LevelOfAccess permissions;
	
	
	public User(String loginName, String password, String fullName, LevelOfAccess permissions)
	{
		this.loginName = loginName;
		this.password = password;
		this.fullName = fullName;
		this.permissions = permissions;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}


}
