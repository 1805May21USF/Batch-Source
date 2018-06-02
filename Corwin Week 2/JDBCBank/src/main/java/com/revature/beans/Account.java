package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Account{
	
	private int ID;
	private int fingerprint;
	private double balance;
	private String status;
	private ArrayList<Customer> customers;
	private ArrayList<Transaction> transactions;
	
	public Account(double b,String s) {
		Random random = new Random();
		this.setFingerprint(100000000 + random.nextInt(900000000));
		this.setStatus(s);
		this.setBalance(b);
		this.customers = new ArrayList<Customer>();
		this.transactions = new ArrayList<Transaction>();
	}
	
	public Account(int ID,int f,double b,String s) {
		this.setFingerprint(f);
		this.setID(ID);
		this.setStatus(s);
		this.setBalance(b);
		this.customers = new ArrayList<Customer>();
		this.transactions = new ArrayList<Transaction>();
	}
	public boolean deposit(double amount) {
		//Transaction t = new Transaction("DEPOSIT",this,amount,this.balance+amount);
		this.balance = this.balance+amount;
		//
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
			//Transaction t = new Transaction("TRANSFER",this,a,am,this.balance-am);
			this.balance = this.balance-am;
			//
			//Transaction t2 = new Transaction("TRANSFER",a,this,am,a.getBalance()+am);
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
		//Transaction t = new Transaction("WITHDRAW",this,amount,this.balance-amount);
		this.balance = this.balance-amount;
		//this.transactions.add(t);
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
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public boolean removeCustomer(Customer c) {
		int toremove = -1;
		for(int i = 0;i<this.getCustomers().size();i++) {
			if(this.getCustomers().get(i).ID==c.getID()) {
				toremove = i;
			}
		}
		if(toremove != -1) {
			this.getCustomers().remove(toremove);
			System.out.println("Customer #"+c.getID()+" was removed from Account #"+this.getID());
			return true;
		}
		System.out.println("Customer #"+c.getID()+" was not a customer with Account #"+this.getID());
		return false;
	}
	public boolean addCustomer(Customer c) {
		int toremove = -1;
		for(int i = 0;i<this.getCustomers().size();i++) {
			if(this.getCustomers().get(i).ID==c.getID()) {
				toremove = i;
			}
		}
		if(toremove == -1) {
			this.getCustomers().add(c);
			System.out.println("Customer #"+c.getID()+" add to Account #"+this.getID());
			return true;
		}
		System.out.println("Customer #"+c.getID()+" was already on Account #"+this.getID());
		return false;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public boolean addTransaction(Transaction t) {
		this.getTransactions().add(t);
		return true;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(int fingerprint) {
		this.fingerprint = fingerprint;
	}
	

}
