package com.revature.bank;

public class LoginCustomer {
	
	private String userName;
	private String password;
	private String joiningFirstName;
	private String joiningLastName;
	
	public LoginCustomer() 
	{
		
	}
	
	public void setJoiningUser(String joiningFirst) 
	{
		joiningFirstName = joiningFirst;
	}
	
	public String getJoiningFirst() 
	{
		return joiningFirstName;
	}
	
	public void setJoiningLastName(String joiningLast) 
	{
		joiningLastName = joiningLast;
	}
	
	public String getJoiningLast(String joiningLast) 
	{
		return joiningLastName;
	}
	
	public void setLoginUserName(String user) 
	{
		userName = user;
	}
	
	public String getLoginUserName() 
	{
		return userName;
	}
	
	public void setLoginPassword(String pass) 
	{
		password = pass;
	}
	
	public String getLoginPassword() 
	{
		return password;
	}

	@Override
	public String toString() {
		return "LoginCustomer [userName=" + userName + ", password=" + password + ", joiningFirstName="
				+ joiningFirstName + ", joiningLastName=" + joiningLastName + "]";
	}
	
	

}
