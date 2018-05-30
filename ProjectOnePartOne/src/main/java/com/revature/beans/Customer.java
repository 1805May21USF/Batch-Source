package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.revature.comparators.ApplicationIdComparator;

public class Customer extends User implements Serializable {
	
	private String fname;
	private String lname;
	private ArrayList<Application> applications;
	private ArrayList<Account> accounts;
	
	public Customer(String u,String p,String f, String l) {
		super(u,p);
		this.fname = f;
		this.lname = l;
		this.applications = new ArrayList<Application>();
		this.accounts = new ArrayList<Account>();
	}
	
	public Customer(int i,String u,String p,String f, String l) {
		super(i,u,p);
		this.fname = f;
		this.lname = l;
		this.applications = new ArrayList<Application>();
		this.accounts = new ArrayList<Account>();
	}
	
	@Override
	public String toString() {
		return "Customer [fname=" + fname + ", lname=" + lname + ", applications=" + applications + ", accounts="
				+ accounts + ", ID=" + ID + ", userName=" + userName + ", passWord=" + passWord + ", isAdmin=" + isAdmin
				+ ", isEmployee=" + isEmployee + ", isCustomer=" + isCustomer + "]";
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

	public ArrayList<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(ArrayList<Application> apps) {
		this.applications = apps;
	}
	
	public void addApplication(Application a) {
		this.applications.add(a);
	}
	
	public void addAccount(Account a) {
		this.accounts.add(a);
	}

	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
