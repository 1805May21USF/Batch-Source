package com.revature.storage;

public class Account implements java.io.Serializable{
	// The serialVersionUID for the Account class
	private static final long serialVersionUID = 4L;
	
	// The fields stored in the Account class
	private String type;
	private String name;
	private double balance;
	private String shared;

	// Constructor for Account
	public Account(String t, String n, double b, String s) {
		type = t;
		name = n;
		balance = b;
		shared = s;
	}

	// Getter and setter method for the type field
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	// Getter and setter method for the name field
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// Getter and setter method for the balance field
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Getter and setter method for the shared field
	public String getShared() {
		return shared;
	}
	public void setShared(String shared) {
		this.shared = shared;
	}
	
	// Overrides Object's toString method
	@Override
	public String toString() {
		return "Account Name: " + name + "\nAccount Type: " + type + "\nAccount Balance: $" + balance + "\nShared With: " + shared + "\n";
	}
}
