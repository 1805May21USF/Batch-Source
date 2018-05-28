package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Account implements Serializable {
	
	private int ID;
	private double balance;
	private Customer signer;
	private ArrayList<Customer> customers;
	private ArrayList<Transaction> transactions;
	
	public Account(double b,Customer s,ArrayList<Customer> c) {
		Random rnd = new Random();
		this.setID(100000 + rnd.nextInt(900000));
		this.setBalance(b);
		this.setSigner(s);
		this.setCustomers(c);
	}
	
	public boolean widthdraw(double amount) {
		return true;
	}
	
	public boolean transfer(double amount, Account a) {
		return true;
	}
	public boolean deposit(double amount) {
		return true;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getSigner() {
		return signer;
	}

	public void setSigner(Customer signer) {
		this.signer = signer;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	

}
