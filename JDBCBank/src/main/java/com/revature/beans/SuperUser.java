package com.revature.beans;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import org.apache.log4j.Logger;

import com.revature.daoimpl.AccountDAOimpl;

//Client class to hold all of the superUser related data.
public class SuperUser extends Client{
		private String userName;
		private String passWord;
		private int id;
		private static Scanner in = new Scanner(System.in);
		final static Logger logger = Logger.getLogger(Account.class);
	//list to hold all of the accounts for the super user
	private static List<Account> superAccountList = new ArrayList<Account>();
	//super user constructor
	//get  all of the properties from the superuser.prop file
	//use those values to instantiate the super user.
	public SuperUser() throws FileNotFoundException, IOException {
		super();
		Properties prop = new Properties();
		prop.load(new FileReader("SuperUser.properties"));
		this.userName = prop.getProperty("usr");
		this.passWord = prop.getProperty("password");
		this.id = Integer.parseInt(prop.getProperty("id"));
		// TODO Auto-generated constructor stub
	}
	//getter for the getsuperaccountlist
	public static List<Account> getSuperAccountList() {
		return superAccountList;
	}
	//setter for the super account list.
	public static void setSuperAccountList(List<Account> superAccountList) {
		SuperUser.superAccountList = superAccountList;
	}
	
	//print all of the accounts in the super user.
	@Override
	public void printAccounts() {
		
		for(Account item : this.getSuperAccountList()) {
			System.out.println(item);
		}
		
	}

	// get account that needs to be deleted.
	//if the user inputted value is a
	Account getAccountForDelete() {
		Account account = null;
		int accountNum = Integer.parseInt(in.next());		
		for(Account acc : this.getSuperAccountList()) {
			if(acc.getAccountNumber() == accountNum) {
				account = acc;
				break;
			}
		}
		return account;
	}
	//select the account from the users inputted value
	Account selectAccount(int option) {
		Account clientAccount = null;
		//if the account number is equal to the inputted value the return the clientAccount
		for( Account acc : this.getSuperAccountList()) {
			if(acc.getAccountNumber() == option) {
				clientAccount = acc;
				break;
			}
		}
		return clientAccount;
	}
	
	//withdraw monies from the Account
	//while the client doesn't have enough money
	void withdraw(Account account){
		
		boolean enoughMoney = false;
		AccountDAOimpl impl = new AccountDAOimpl();
		do {
		try {
		System.out.println("How much would you like to withdraw");
		///need to add an exception if the new amount would result in a negative balance
		double amount = Double.parseDouble(in.next());
		//if the amount is greater than the current balance
		if(amount > account.getBalance()) {
			throw new AccountException("You ain't got no money!");
		}
		//then set the balance to the current balance - amount
		account.setBalance(account.getBalance() - amount);
		//set the escape boolean
		enoughMoney = true;
		//log the transaction.
		logger.info("Your new balance is: " + account.getBalance());
		logger.info("$ " + amount + " was withdrawn from your Account!");
		}catch(AccountException e) {//print out the custom exception
			e.printStackTrace();
		}
		}while(enoughMoney == false);
		
		try {//update the balance in the DAO
		impl.updateBalance(account);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//deposit monies into the account
	void deposit(Account account) {
		// TODO Auto-generated method stub
		AccountDAOimpl impl = new AccountDAOimpl();
		System.out.println("How much would you like to Deposit");
		///need to add an exception if the new amount would result in a negative balance
		double amount = Double.parseDouble(in.next());
		//get the amount to be deposited
		account.setBalance(account.getBalance() + amount);
		//log the transaction.
		logger.info("Your new balance is: " + account.getBalance());
		logger.info("$ " + amount + " was deposited to your Account!");
		try {
		impl.updateBalance(account);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	


}
