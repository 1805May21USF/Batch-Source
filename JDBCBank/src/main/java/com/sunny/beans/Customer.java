package com.sunny.beans;

public class Customer {
	
	private int customerID;
	private String fname;
	private String lname;
	private String user;
	private String pass;
	
	public Customer(String fn, String ln, String user, String pass) {
		fname = fn;
		lname = ln;
		this.user = user;
		this.pass = pass;
	}
	
	public Customer(int cid, String fn, String ln, String user, String pass) {
		customerID = cid;
		fname = fn;
		lname = ln;
		this.user = user;
		this.pass = pass;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "CID: " + customerID + "\nName: " 
				+ fname + " " + lname + "\nUser: " + user
				+ "\nPass: " + pass + "\n";
	}
	
	
}
