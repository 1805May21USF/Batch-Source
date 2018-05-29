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
				customerOptions(username, true);
				break;
			case 1:
				companyOptions(false);
				break;
			case 2:
				companyOptions(true);
				break;
		}
	}
	
	private void companyOptions(boolean owner) {
		String input;
		while (true) {
			if (!owner) {
				System.out.println("Select 1 for Select A Customer Account, " +
						"2 for View Account Applies, -1 for Exit.");
				input = sc.nextLine();
				if (input.equals("-1"))
					return;
				if (input.equals("1")) {
					connectToUserAccount(owner);
				} else if (input.equals("2")) {
					UserActions.viewAccountApplies();
				} else {
					System.out.println("Invalid entry, try again");
				}
			} else {		
				System.out.println("Select 1 for Select A Customer Account, " +
						"2 for View Account Applies, 3 for Create New Employee, -1 for Exit.");
				input = sc.nextLine();
				if (input.equals("-1"))
					return;
				if (input.equals("1")) {
					connectToUserAccount(owner);
				} else if (input.equals("2")) {
					UserActions.viewAccountApplies();
				} else if (input.equals("3")) {
					App.optionRegister(1);
				} else {
					System.out.println("Invalid entry, try again");
				}
			}
		}
	}

	private void connectToUserAccount(boolean owner) {
		while (true) {
			System.out.println("Customer username or -1 for Exit: ");
			String input = sc.nextLine();
			if (input.equals("-1"))
				break;
			if (RegistrationActions.usernameExists(input) && CustomerActions.getCustomerAccountByUsername(input) != null) {
				customerOptions(input, owner);
				break;
			}
			System.out.println("Invalid username.");
		}	
	}

	private void customerOptions(String username, boolean owner) {
		String input;
		while (true) {
			if (!owner) {
				System.out.println("Select 1 for View Personal Info, 2 for Select A Bank Account, -1 for Exit.");
				input = sc.nextLine();
				if (input.equals("-1"))
					return;
				if (input.equals("1")) {
					c.viewPersonalInfo(username);
				} else if (input.equals("2")) {
					u.selectAnAccount(username, owner);
				} else {
					System.out.println("Invalid entry, try again");
				}
			} else {
				System.out.println("Select 1 for View Personal Info, 2 for Select A Bank Account, 3 for Apply For Joint Account, -1 for Exit.");
				input = sc.nextLine();
				if (input.equals("-1"))
					return;
				if (input.equals("1")) {
					c.viewPersonalInfo(username);
				} else if (input.equals("2")) {
					u.selectAnAccount(username, owner);
				} else if (input.equals("3")) {
					applyForJointAccount(username);
				} else {
					System.out.println("Invalid entry, try again");
				}
			}
		}
	}
	
	//register
	public boolean register(String username, String password, int type) {
		if (usernameExists(username)) {
			System.out.println("User name taken, try again.");
			return false;
		} else {	
			UserAccount acc = new UserAccount(username, password, type);
			ArrayList<UserAccount> userAccounts = getAccounts();
			if (userAccounts == null) 
				userAccounts = new ArrayList<UserAccount>();
			userAccounts.add(acc);
			
			UtilityActions.write(userAccounts, filename);
		}
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
			
			if (input.equals("-1"))
				return;
			if (usernameExists(input)) {
				CustomerAccount otherAccount = CustomerActions.getCustomerAccountByUsername(input);			
				if (otherAccount == null) {
					System.out.println("Invalid username");
					return;
				}			
				
				id = UtilityActions.getUUID(otherAccount);
				if (id == null)
					return;
				break;
			}
		}			
		u.apply(curAccount, id);
	}
}
