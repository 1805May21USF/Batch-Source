package com.revature.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Account {
	
	private String type;
	private String owner;
	private double balance;
	
	private static final String accountFile = "accounts.txt";
	public static ArrayList<Account> accountList = new ArrayList<Account>();
	
	public Account() {
		
	}
	
	public Account(String type, String owner, double balance) {
		this.type = type;
		this.owner = owner;
		this.balance = balance;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getType() {
		return type;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void createAccount(String type, String owner, double balance) {
		Account newAccount = new Account(type, owner, balance);
		accountList.add(newAccount);
		writeAccountFile();
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if(this.balance - amount >= 0) {
			this.balance -= amount;
		} else {
			System.out.println("Account has insufficient funds to make this withdrawal!");
		}
	}
	
	public void transfer(Account acc1, Account acc2, double amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
	
	public void writeAccountFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(accountFile, true));
			objectOut.writeObject(accountList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readAccountFile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(accountFile));
			accountList = (ArrayList<Account>) objectIn.readObject();
			objectIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
