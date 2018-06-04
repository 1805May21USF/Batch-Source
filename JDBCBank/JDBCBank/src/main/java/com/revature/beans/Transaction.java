package com.revature.beans;

public class Transaction implements java.io.Serializable{
	// Allows for Transaction objects to be serialized
	private static final long serialVersionUID = -3515915628132960776L;
	
	// Fields stored in the Transaction object
	private int id;
	private int customerId;
	private int initialAccount;
	private int finalAccount;
	private double amount;
	private String type;
	
	// A public constructor to create Transaction objects
	public Transaction(int i, int ci, int ia, int fa, double a, String t) {
		id = i;
		customerId = ci;
		initialAccount = ia;
		finalAccount = fa;
		amount = a;
		type = t;
	}

	// Getter and setter methods for the id field
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	// Getter and setter methods for the customerId field
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// Getter and setter methods for the initialAccount field
	public int getInitialAccount() {
		return initialAccount;
	}
	public void setInitialAccount(int initialAccount) {
		this.initialAccount = initialAccount;
	}

	// Getter and setter methods for the finalAccount field
	public int getFinalAccount() {
		return finalAccount;
	}
	public void setFinalAccount(int finalAccount) {
		this.finalAccount = finalAccount;
	}

	// Getter and setter methods for the amount field
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	// Getter and setter methods for the type field
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
