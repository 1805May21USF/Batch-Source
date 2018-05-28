package com.revature.beans;

import java.io.Serializable;

public class Employee extends User implements Serializable {
	
	private String fname;
	private String lname;
	
	public Employee(String u, String p,String f,String l) {
		super(u,p);
		this.setFname(f);
		this.setLname(l);
		this.setEmployee(true);
		this.setCustomer(false);
	}
	
	public Employee(int i,String u, String p,String f,String l) {
		super(i,u,p);
		this.setFname(f);
		this.setLname(l);
		this.setEmployee(true);
		this.setCustomer(false);
	}
	
	public void makeAdmin() {
		this.setCustomer(false);
		this.setEmployee(false);
		this.setAdmin(true);
	}
	
	public void makeEmployee() {
		this.setEmployee(true);
		this.setAdmin(false);
		this.setCustomer(false);
	}
	
	public void makeCustomer() {
		this.setCustomer(true);
		this.setEmployee(false);
		this.setAdmin(false);
	}
	
	

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", ID=" + ID + ", userName=" + userName + ", passWord="
				+ passWord + ", isAdmin=" + isAdmin + ", isEmployee=" + isEmployee + ", isCustomer=" + isCustomer + "]";
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

}
