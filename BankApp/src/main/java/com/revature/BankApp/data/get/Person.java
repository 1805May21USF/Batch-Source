package com.revature.BankApp.data.get;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Person {
	private ArrayList<String> accounts = new ArrayList<>();
	private String entry;
	private String fName;
	private String lName;
	private String username;
	private String password;
	private int status;
	private long accNo;
	private DecimalFormat df = new DecimalFormat("###,###,###.00");

	Person() {

	}

	public Person(String fName, String lName, String username, String password, int status, long accNo) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.status = status;
		this.accNo = accNo;
	}

	public ArrayList<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<String> accounts) {
		this.accounts = accounts;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public DecimalFormat getDf() {
		return df;
	}

	public void setDf(DecimalFormat df) {
		this.df = df;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", username=" + username + ", password=" + password
				+ ", status=" + status + ", accNo=" + accNo + "]";
	}

}
