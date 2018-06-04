package com.revature.beans;

import java.sql.SQLException;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import org.apache.log4j.Logger;

import com.revature.daoimpl.AccountDAOimpl;

public class Account {
	
	
	private double balance;
	private int accountNumber;
	private int clientsID;
	final static Logger logger = Logger.getLogger(Account.class);
	private Scanner in = new Scanner(System.in);
	
	
	public Account(int clientsID, int accountNumber, double balance) {
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.clientsID = clientsID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getClientsID() {
		return clientsID;
	}
	public void setClientsID(int clientsID) {
		this.clientsID = clientsID;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber=" + accountNumber + ", clientsID=" + clientsID + "]";
	}
	
	
	void deposit() {
		// TODO Auto-generated method stub
		AccountDAOimpl impl = new AccountDAOimpl();
		System.out.println("How much would you like to Deposit");
		///need to add an exception if the new amount would result in a negative balance
		double amount = Double.parseDouble(in.next());
		setBalance(getBalance() + amount);
		logger.info("Your new balance is: " + getBalance());
		logger.info("$ " + amount + " was withdrawn from your Account!");
		try {
		impl.updateBalance(this);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//withdraw monies from the account while there is enough money to withdraw.
	void withdraw(){
		boolean enoughMoney = false;
		AccountDAOimpl impl = new AccountDAOimpl();
		do {
		try {
		System.out.println("How much would you like to withdraw");
		///need to add an exception if the new amount would result in a negative balance
		double amount = Double.parseDouble(in.next());
		if(amount > getBalance()) {
			throw new AccountException("Broke ass, you don't have that much money!");
		}
		setBalance(getBalance() - amount);
		enoughMoney = true;
		//set the balance and log the transactions.
		logger.info("Your new balance is: " + getBalance());
		logger.info("$ " + amount + " was withdrawn from your Account!");
		}catch(AccountException e) {
			e.printStackTrace();
		}
		}while(enoughMoney == false);
		
		try {
		impl.updateBalance(this);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	


	


}