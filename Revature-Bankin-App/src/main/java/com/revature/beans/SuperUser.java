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

public class SuperUser extends Client{
		private String userName;
		private String passWord;
		private int id;
		private static Scanner in = new Scanner(System.in);
		final static Logger logger = Logger.getLogger(Account.class);
		
	private static List<Account> superAccountList = new ArrayList<Account>();
	
	public SuperUser() throws FileNotFoundException, IOException {
		super();
		Properties prop = new Properties();
		prop.load(new FileReader("SuperUser.properties"));
		this.userName = prop.getProperty("usr");
		this.passWord = prop.getProperty("password");
		this.id = Integer.parseInt(prop.getProperty("id"));
		// TODO Auto-generated constructor stub
	}

	public static List<Account> getSuperAccountList() {
		return superAccountList;
	}

	public static void setSuperAccountList(List<Account> superAccountList) {
		SuperUser.superAccountList = superAccountList;
	}

	@Override
	public void printAccounts() {
		
		for(Account item : this.getSuperAccountList()) {
			System.out.println(item);
		}
		
	}

	
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
	
	Account selectAccount(int option) {
		Account clientAccount = null;
		
		for( Account acc : this.getSuperAccountList()) {
			if(acc.getAccountNumber() == option) {
				clientAccount = acc;
				break;
			}
		}
		return clientAccount;
	}
	
	void withdraw(Account account){
		boolean enoughMoney = false;
		AccountDAOimpl impl = new AccountDAOimpl();
		do {
		try {
		System.out.println("How much would you like to withdraw");
		///need to add an exception if the new amount would result in a negative balance
		double amount = Double.parseDouble(in.next());
		if(amount > account.getBalance()) {
			throw new AccountException("Broke ass, you don't have that much money!");
		}
		account.setBalance(account.getBalance() - amount);
		enoughMoney = true;
		logger.info("Your new balance is: " + account.getBalance());
		logger.info("$ " + amount + " was withdrawn from your Account!");
		}catch(AccountException e) {
			e.printStackTrace();
		}
		}while(enoughMoney == false);
		
		try {
		impl.updateBalance(account);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	void deposit(Account account) {
		// TODO Auto-generated method stub
		AccountDAOimpl impl = new AccountDAOimpl();
		System.out.println("How much would you like to Deposit");
		///need to add an exception if the new amount would result in a negative balance
		double amount = Double.parseDouble(in.next());
		account.setBalance(account.getBalance() + amount);
		logger.info("Your new balance is: " + account.getBalance());
		logger.info("$ " + amount + " was deposited to your Account!");
		try {
		impl.updateBalance(account);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	


}
