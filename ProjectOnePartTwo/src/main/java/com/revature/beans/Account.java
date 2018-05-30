package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Account implements Serializable {
	
	private int ID;
	private double balance;
	private Customer signer;
	private String status;
	private ArrayList<Customer> customers;
	private ArrayList<Transaction> transactions;
	
	public Account(double b,Customer s,ArrayList<Customer> c) {
		Random rnd = new Random();
		this.setID(100000 + rnd.nextInt(900000));
		this.status = "OPEN";
		this.setBalance(b);
		this.setSigner(s);
		this.setCustomers(c);
		this.transactions = new ArrayList<Transaction>();
	}
	public boolean deposit(double amount) {
		Transaction t = new Transaction("DEPOSIT",this,amount,this.balance+amount);
		this.balance = this.balance+amount;
		this.transactions.add(t);
		System.out.println("$" + amount + " deposited.");
		return true;
	}
	public boolean canTransfer(double amount) {
		if(this.balance-amount<0) {
			System.out.println("The transfer failed, amount cannot be withdrawn.");
			return false;
		}
		return true;
	}
	public boolean transfer(Account a, double am) {
		if(canTransfer(am)) {
			Transaction t = new Transaction("TRANSFER",this,a,am,this.balance-am);
			this.balance = this.balance-am;
			Transaction t2 = new Transaction("TRANSFER",a,this,am,a.getBalance()+am);
			return true;
		}
		return false;
	}
	public boolean canWithdraw(double amount) {
		if(this.balance-amount<0) {
			System.out.println("The withdraw failed, amount cannot be withdrawn.");
			return false;
		}
		return true;
	}
	public boolean withdraw(double amount) {
		Transaction t = new Transaction("WITHDRAW",this,amount,this.balance-amount);
		this.balance = this.balance-amount;
		this.transactions.add(t);
		System.out.println("$" + amount + " withdrawn.");
		return true;
	}
	
	public void closeAccount() {
		this.setStatus("CLOSED");
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
