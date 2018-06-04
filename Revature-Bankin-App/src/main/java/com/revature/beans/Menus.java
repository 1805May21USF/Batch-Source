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

import com.revature.daoimpl.*;
import com.revature.beans.*;

public class Menus {
	
	final static Logger logger = Logger.getLogger(Menus.class);
	private static Scanner in = new Scanner(System.in);
	private boolean validEntry = false;
	private int entry;
	private static boolean accountsAdded = false;
	public static List<Client> clientList = new ArrayList<Client>();
	
	
	

	// main menu that prompts the user with options
	public void mainMenu() {
		Client client = null;
		try {
		ClientDAOimpl imp = new ClientDAOimpl();
		clientList = imp.getClients();
		System.out.println(clientList.size());
		}catch(SQLException e) {
			System.out.println("Error in db!");
		}
		
		do {
		try {
			//prompt user to select an option.
		mainMenuPrompt();
		entry = Integer.parseInt(in.next());
		//begin Switch statement
		switch(entry) {
		//if the user selects 1 then take the user to the login screen.
		case 1:{
			//open login Screen
			validEntry = true;
			loginScreen();
		}
		
		case 2:{// open the sign up screen
			String user = null;
			String password = null;
			String fname = null;
			String lname = null;
			boolean clientExists = false;
			boolean clientCreated = false;
			Menus m = new Menus();
			
			
			ClientDAOimpl imp = new ClientDAOimpl();
				do {
					try {//try to create a new client
				
				System.out.println("Enter a username");
				user = in.next();
				System.out.println("Enter a password");
				password = in.next();
				System.out.println("Enter your first name");
				fname = in.next();
				System.out.println("Enter your last name");
				lname = in.next();
				clientExists = m.checkIfUserExists(user);
						if(clientExists == false) {
						clientCreated = imp.newClient(user,password,fname,lname);
						}
					}catch(SQLException e) {
					e.printStackTrace();
					}
				}while(clientCreated == false);
					validEntry = true;
					clientList.clear();
					clientList = imp.getClients();
					m.loginScreen();
		}//end case 2
		
		
		case 3:{
			//exit the app
			System.out.println("Thank you for your loyal service");
			System.out.println("Goodbye!!!");
			System.exit(0);
			}
		
		
		default:{
			System.out.println("invalid option\n");
		}
		
		
		}//end switch
		
		}catch(Exception e) {
			System.out.println("invalid  option");
		}
		}while(validEntry != true);
		
	}






	private void mainMenuPrompt() {
		System.out.println("------Welcome, select an option below to begin-----");
		System.out.println("---------(1)Login----------");
		System.out.println("---------(2)Signup---------");
		System.out.println("---------(3)Exit-----------");
	}
	
	
	
	
	
	
	public void loginScreen() throws FileNotFoundException, IOException, SQLException {
		ClientDAOimpl clientDAO = new ClientDAOimpl();
		Client client = null;
		Menus m = new Menus();
		SuperUser sup = null;
		boolean isSuperUser = false;
		
			sup = checkIfSuperUser();
		if(sup == null) {
		try {
		do {
			clientList = clientDAO.getClients();
			System.out.println("---------Please login below---------");
			client = verifyCLient(clientList);
			
		}while(client == null); 
		}catch (SQLException e) {
			e.printStackTrace();
		}//
		
		m.accountScreen(client);
		}
		else {
			//go to superUserScreen
			System.out.println("SuperUserScreen");
			SuperUserDAOimpl im = new SuperUserDAOimpl();
			try {
				sup.setSuperAccountList(im.getAllAccounts());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			superUserScreen(sup);
		}
	}

	
	
	
	
	
	private void superUserScreen(SuperUser sup) throws SQLException, FileNotFoundException, IOException {
		superUserPrompt();
		SuperUserDAOimpl impl = new SuperUserDAOimpl();
		int option = Integer.parseInt(in.next());
		Account account = null;
		switch (option) {
		
		case 1:{
			System.out.println("printaccounts");
			sup.printAccounts();
			superUserScreen(sup);
			
		}
		case 2:{
			
			impl.createAccount();
			sup.getSuperAccountList().clear();
			sup.setSuperAccountList(impl.getAllAccounts());
			sup.printAccounts();
			superUserScreen(sup);
		}
		case 3:{
			sup.printAccounts();
			System.out.println("Select an acountNumber to delete that account!");
			account = sup.getAccountForDelete();
			if(account != null) {
				impl.deleteAccount(account);
				System.out.println("Account Deleted!");
			}
			superUserScreen(sup);
		}
		case 4:{
			sup.printAccounts();
			System.out.println("Select an acountNumber to withdraw money from that account!");
			//withdraw from account
			option = Integer.parseInt(in.next());
			account = sup.selectAccount(option);
			sup.withdraw(account);
			superUserScreen(sup);
		}
		case 5:{
			sup.printAccounts();
			System.out.println("Select an acountNumber to deposit money into that account!");
			//deposit into account
			option = Integer.parseInt(in.next());
			account = sup.selectAccount(option);
			sup.deposit(account);
			superUserScreen(sup);
		}
		case 6:{
			loginScreen();
			}
		}
	}


	
	
	private void superUserPrompt() {
		System.out.println("----Select an option-----");
		System.out.println("----(1)View Accounts-----");
		System.out.println("----(2)Create Account-----");
		System.out.println("----(3)Delete Account-----");
		System.out.println("----(4)Withdraw from account-----");
		System.out.println("----(5)Deposit into account-----");
		System.out.println("----(6)Logout-----");
	}



	private Client verifyCLient(List<Client> clientList2) {
		// TODO Auto-generated method stub
		String userName;
		String password;
		Client client = null;
		
		do {
		try {
			
			System.out.println("Enter your UserName");
			userName = in.next();
			System.out.println("Enter your Password");
			password = in.next();
			for( Client next : clientList2) {//for loop
			if(next.getUserName().equals(userName)
			&& next.getPassword().equals(password)) {
			System.out.println("Welcome Back " + next.getFirstName() + " " + next.getLastName());
			client = next;
			return next;
			}//if
			}//for
			if(client ==null) {
				throw new AccountException("Wrong user Name or Password");
			}
		
		}catch(AccountException e) {
			e.printStackTrace();;
		}
		}while(client == null);
		
		return null;
	}
	
	
	
	
	//Account options screen
	public void accountScreen(Client client) {
		Menus m = new Menus();
		Account account = null;
		boolean validEntry = false;
		ClientDAOimpl clientImpl = new ClientDAOimpl();
		AccountDAOimpl accountImpl = new AccountDAOimpl();
		do {
		try {
		System.out.println("-----Select an option-----");
		System.out.println("-----(1)Select one of your accounts-----");
		System.out.println("-----(2)Open a new account-----");
		System.out.println("-----(3)LOGOUT-----");
		int option = Integer.parseInt(in.next());
		
		switch(option) {
		
		case 1: {
			//display accounts
			if(accountsAdded == false) {
			clientImpl.addAccountsFromDB(client);
			accountsAdded = true;}
			System.out.println("--------------Select Account----------------");
			client.printAccounts();
			System.out.println("to access an account enter the account number");
			option = Integer.parseInt(in.next());
			account = client.selectAccount(option);
			System.out.println("--------Select an option----------");
			System.out.println("(1)-------withdraw");
			System.out.println("(2)-------deposit");
			System.out.println("(3)-------close Account");
			System.out.println("(4)-------EXIT");
			option = Integer.parseInt(in.next());
			switch(option) {//inner Switch
			case 1:{
				account.withdraw();
				break;
				
			}
			case 2:{
				account.deposit();
				break;
			}
			case 3:{
				
				accountImpl.deleteAccount(account);
				client.removeAccountFromList(account);
				m.accountScreen(client);
			}
			case 4:{
				m.accountScreen(client);
				break;
			}
			default:{
				System.out.println("That is invalid");
				break;
			}
			
		}//inner switch
		
			break;
		}//outer case 1
		
		
		case 2: {
			AccountDAOimpl imp = new AccountDAOimpl();
			System.out.println(client.getClientID());
			imp.createAccount(client);
			client.getAccountList().clear();
			clientImpl.addAccountsFromDB(client);
			accountsAdded = true;
			m.accountScreen(client);
			
		}
		
		//take the user back to the main menu
		case 3: {
			m.mainMenu();
			}
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("you have to enter a valid entry!");
		}
		}while(validEntry == false);
	}


		
	public boolean checkIfUserExists(String username) {
		boolean clientExists = false;
		for(Client c : clientList) {
			if(c.getUserName().equals(username)) {
				clientExists = true;
				break;
			}
			else {
				clientExists = false;
			}
		}
		return clientExists;
	}
	
	public SuperUser checkIfSuperUser() throws FileNotFoundException, IOException {
		String username;
		String passWord;
		
		System.out.println("Enter your UserName");
		username = in.next();
		System.out.println("Enter your Password");
		passWord = in.next();
		Properties prop = new Properties();
		prop.load(new FileReader("SuperUser.properties"));
		
		if(username.equals(prop.getProperty("usr"))
		&& passWord.equals( prop.getProperty("password"))) {
			System.out.println("You are super");
			return new SuperUser();
		}
		
		
		//id = Integer.parseInt(prop.getProperty("id"));
		else {
		return null;
		}
	}
	
	
}
