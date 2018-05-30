package com.revature.BankApplication;

public class AdminAccess {

	
	Customer c;
	public AdminAccess(Customer c) {
		this.c = c;
	}
	
	
	public void displayInfo() {
		System.out.println("Welcome to the Admin Page");
	}
}
