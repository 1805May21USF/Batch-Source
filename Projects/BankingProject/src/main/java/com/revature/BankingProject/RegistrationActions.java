package com.revature.BankingProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import com.revature.Utility.UtilityActions;

public class RegistrationActions {
	private static File filename = new File("UserAccounts.txt");
	private static UserActions u = new UserActions();
	private static CustomerActions c = new CustomerActions();
	
	public void userOptions(String username) {
		UserAccount userAccount = getUserAccountByUsername(username);
		
		switch (userAccount.getAccountType()) {
			case 0:
				u.selectAnAccount(username);
				break;
			case 1:
				//Employee options
					//view customer info
						//account
						//balances
						//personal info
					//approve/deny applications
				break;
			case 2:
				//Admin options
					//view customer info
					//edit customer info
					//view/edit employee info?
					//withdraw, deposit, transfer to/from all accounts
					//cancel accounts
				break;
		}
	}
	
	//register
	public boolean register(String username, String password, int type) {
		UserAccount acc = new UserAccount(username, password, type);

		if (usernameExists(username)) {
			System.out.println("User name taken, try again.");
			return false;
		} else {	
			ArrayList<UserAccount> userAccounts = getAccounts();
			if (userAccounts == null) 
				userAccounts = new ArrayList<UserAccount>();
			userAccounts.add(acc);
			
			UtilityActions.write(userAccounts, filename);
		}
		//register customer account info to username
		
		return true;
	}

	//Check if username already exists
	public static boolean usernameExists(String username) {
		ArrayList<UserAccount> userAccounts = getAccounts();
		
		if (userAccounts != null)
			for (UserAccount userAccount : userAccounts) 
				if (userAccount.getUsername().equals(username)) 
					return true;
		return false;
	}	
	
	//Gets account using a username
	public UserAccount getUserAccountByUsername(String username) {
		ArrayList<UserAccount> userAccounts = getAccounts();
		
		if (userAccounts != null) 
			for (UserAccount userAccount : userAccounts) 
				if (userAccount.getUsername().equals(username))
					return userAccount;
		return null;
	}
	
	//Get the accounts from the file
	public static ArrayList<UserAccount> getAccounts() {
		return convert(UtilityActions.read(filename));
	}
	
	//Convert generic array to UserAccount
	private static ArrayList<UserAccount> convert(ArrayList<?> list) {		
		ArrayList<UserAccount> userAccounts = null;
		
		if (list != null) {
			userAccounts = new ArrayList<UserAccount>();
			for (Object item : list)
				userAccounts.add((UserAccount) item);
		}
		return userAccounts;
	}

	//Checks if pass matches for username
	public boolean login(String user, String pass) {
		UserAccount userAccount = getUserAccountByUsername(user);
		
		if (userAccount != null)
			if (userAccount.getPassword().equals(pass))
				return true;
		return false;
	}
}
