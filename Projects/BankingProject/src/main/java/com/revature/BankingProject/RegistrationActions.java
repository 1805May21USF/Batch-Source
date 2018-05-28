package com.revature.BankingProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.revature.Utility.UtilityActions;

public class RegistrationActions {
	private static File filename = new File("UserAccounts.txt");
	private static UserActions u = new UserActions();
	private static CustomerActions c = new CustomerActions();
	private static Scanner sc = App.sc;
	
	public void userOptions(String username) {
		UserAccount userAccount = getUserAccountByUsername(username);
		
		switch (userAccount.getAccountType()) {
			case 0:
				customerOptions(username);
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
				adminOptions();
				break;
		}
	}
	
	private void adminOptions() {
		String input;
		while (true) {
			System.out.println("Select 1 for Select A Customer Account, 2 for View , -1 for Exit.");
			input = sc.nextLine();
			if (input.equals("-1"))
				return;
			if (input.equals("1")) {
				connectToUserAccount();
			} else if (input.equals("2")) {

			} else {
				System.out.println("Invalid entry, try again");
			}
		}
		//Admin options
			//view customer info
			//edit customer info
			//view/edit employee info?
			//withdraw, deposit, transfer to/from all accounts
			//cancel accounts
	}

	private void connectToUserAccount() {
		while (true) {
			System.out.println("Customer username or -1 for Exit: ");
			String input = sc.nextLine();
			if (input.equals("-1"))
				break;
			if (RegistrationActions.usernameExists(input)) {
				customerOptions(input);
				break;
			}
		}	
	}

	private void customerOptions(String username) {
		String input;
		while (true) {
			System.out.println("Select 1 for View Personal Info, 2 for Select A Bank Account, 3 for Apply For Joint Account, -1 for Exit.");
			input = sc.nextLine();
			if (input.equals("-1"))
				return;
			if (input.equals("1")) {
				c.viewPersonalInfo(username);
			} else if (input.equals("2")) {
				u.selectAnAccount(username);
			} else if (input.equals("3")) {
				applyForJointAccount(username);
			} else {
				System.out.println("Invalid entry, try again");
			}
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
	
	private void applyForJointAccount(String username) {
		CustomerAccount curAccount = CustomerActions.getCustomerAccountByUsername(username);
		UUID id;

		while (true) {
			System.out.println("Please enter a username to apply to or -1 for Exit:");
			String input = sc.nextLine();
			
			if (input.equals("admin")) {
				System.out.println("Restricted username.");
			    return;
			}
			if (input.equals("-1"))
				return;
			if (usernameExists(input)) {
				CustomerAccount otherAccount = CustomerActions.getCustomerAccountByUsername(input);
				id = UtilityActions.getUUID(otherAccount);
				if (id == null)
					return;
				break;
			}
		}
				
		u.apply(curAccount, id);
	}
}
