package com.revature.BankingProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BankActions {
	private static File filename = new File("account.txt");
	
	//register
	public boolean Register(String username, String password, int type) {
		Account acc = new Account(username, password, type);

		if (userNameExists(username)) {
			System.out.println("User name taken, try again.");
			return false;
		} else {	
			ArrayList<Account> accounts = getAccounts();
			if (accounts == null) 
				accounts = new ArrayList<Account>();
			accounts.add(acc);
		}
		return true;
	}
	//login
	
	//Check if username already exists
	public boolean userNameExists(String username) {
		ArrayList<Account> accounts = getAccounts();
		
		if (accounts == null)
			return false;
		for (Account account : accounts) {
			if (account.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}	
	
	//Gets account using a username
	public Account getAccountByUsername(String username) {
		ArrayList<Account> accounts = getAccounts();
		
		if (accounts == null) {
			return null;
		}
		
		for (Account acc : accounts) {
			if (acc.getUsername().equals(username))
				return acc;
		}
		
		return null;
	}
	


	//Get the accounts from the file
	public static ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = null;
		
		// Deserialization
        try {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            accounts = (ArrayList<Account>)in.readObject();
             
            in.close();
            file.close();
            
            if (accounts == null)
            	accounts = new ArrayList<Account>();
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        
        return accounts;
	}
}
