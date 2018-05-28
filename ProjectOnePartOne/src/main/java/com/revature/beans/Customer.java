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
	}
	
	public Customer(int i,String u,String p,String f, String l) {
		super(i,u,p);
		this.fname = f;
		this.lname = l;
		this.applications = new ArrayList<Application>();
	}
	
	public boolean applicationApprove(Application a) {
		int indx = Collections.binarySearch(applications, a, new ApplicationIdComparator());
		if(indx < 0) {
			return false;
		}
		else {
			this.applications.get(indx).setApproval(true);
			return true;
		}
	}
	public boolean applicationDeny(Application a) {
		int indx = Collections.binarySearch(applications, a, new ApplicationIdComparator());
		if(indx < 0) {
			return false;
		}
		else {
			this.applications.get(indx).setApproval(false);
			return true;
		}
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

	public void setApplication(ArrayList<Application> apps) {
		this.applications = apps;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
