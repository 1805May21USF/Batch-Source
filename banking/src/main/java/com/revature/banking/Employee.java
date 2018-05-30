package com.revature.banking;

public class Employee extends User{
	private String name;
	private String username;
	private String passwd;
	private String phonen;
	private boolean loggedIn;
	
	Employee(String name, String username, String passwd, String phonen){
		this.name = name;
		this.username = username;
		this.passwd = passwd;
		this.phonen = phonen;
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhonen() {
		return phonen;
	}
	public void setPhonen(String phonen) {
		this.phonen = phonen;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

}
