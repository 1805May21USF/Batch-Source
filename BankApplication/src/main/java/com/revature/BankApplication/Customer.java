package com.revature.BankApplication;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.BankApplication.Account;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019108870544105900L;
	private boolean employee;
	private String fname;
	private String lname;
	private String user;
	private String pass;
	private ArrayList<Integer> accNum;
	
	public Customer(String fn, String ln, String user, String pass) {
		fname = fn;
		lname = ln;
		this.user = user;
		this.pass = pass;
		employee = false;
		accNum = new ArrayList<Integer>();
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
	public ArrayList<Integer> getAccNum() {
		return accNum;
	}
	public void setAccNum(ArrayList<Integer> accNum) {
		this.accNum = accNum;
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
	public boolean isEmployee() {
		return employee;
	}
	public void setEmployee(boolean employee) {
		this.employee = employee;
	}
	
	
	
}