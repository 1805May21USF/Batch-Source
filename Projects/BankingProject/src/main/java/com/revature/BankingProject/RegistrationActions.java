package com.revature.BankingProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.revature.Utility.UtilityActions;

/*
 * Provides interaction with user login accounts.
 */
public class RegistrationActions {
	private static File filename = new File("UserAccounts.txt");
	private static File bankfilename = new File("BankAccounts.txt");
	private static UserActions u = new UserActions();
	private static CustomerActions c = new CustomerActions();
	private static Scanner sc = App.sc;
	
	/*
	 * Determines what type of user is logged in and displays appropriate options.
	 */
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
	
	/*
	 * Provides employees and admins with options.
	 */
	private void companyOptions(boolean owner) {
		String input;
		while (true) {
			if (!owner) {
				System.out.println("1. Select A Customer Account\n" +
						"2. View Account Applies\n-1 Exit");
				input = sc.nextLine();
				if (input.equals("-1"))
					return;
				if (input.equals("1")) {
					connectToUserAccount(owner);
				} else if (input.equals("2")) {
					UserActions.viewAccountApplies();
				} else {
					System.out.println("Invalid entry");
				}
			} else {		
				System.out.println("1. Select A Customer Account\n" +
						"2. View Account Applies\n3. Create New Employee\n" +
						"4. Close A Bank Account\n-1 Exit");
				input = sc.nextLine();
				if (input.equals("-1"))
					return;
				if (input.equals("1")) {
					connectToUserAccount(owner);
				} else if (input.equals("2")) {
					UserActions.viewAccountApplies();
				} else if (input.equals("3")) {
					App.optionRegister(1);
				} else if (input.equals("4")) {
					closeBankAccount();
				} else {
					System.out.println("Invalid entry");
				}
			}
		}
	}

	/*
	 * Closes a bank account and removes access to it.
	 */
	private void closeBankAccount() {
		while (true) {
			System.out.println("Customer username\n-1 Exit");
			String input = sc.nextLine();
			if (input.equals("-1"))
				break;
			if (RegistrationActions.usernameExists(input) && CustomerActions.getCustomerAccountByUsername(input) != null) {
				//select account num
				int accountNum = u.selectAnAccount(input, true);				
				if (accountNum == -1)
					return;				
				//Close bank account access
				ArrayList<BankAccount> bankAccounts = UserActions.getBankAccounts();
				CustomerAccount customerAccount = CustomerActions.getCustomerAccountByUsername(input);
				UUID idToClose = customerAccount.getBankAccountIDs().get(accountNum);
				for (BankAccount acc : bankAccounts)
					if (acc.getAccountID().equals(idToClose))
						acc.setOpen(false);
				UtilityActions.write(bankAccounts, bankfilename);
				break;
			}
			System.out.println("Invalid username");
		}	
	}

	/*
	 * Allows employees and admins to gain access to a customer's account.
	 */
	private void connectToUserAccount(boolean owner) {
		while (true) {
			System.out.println("Customer username\n-1 Exit");
			String input = sc.nextLine();
			if (input.equals("-1"))
				break;
			if (RegistrationActions.usernameExists(input) && CustomerActions.getCustomerAccountByUsername(input) != null) {
				customerOptions(input, owner);
				break;
			}
			System.out.println("Invalid username");
		}	
	}

	/*
	 * Provides customers with appropriate options.
	 */
	private void customerOptions(String username, boolean owner) {
		String input;
		while (true) {
			if (!owner) {
				System.out.println("1. View Personal Info\n2. Select A Bank Account\n-1 Exit");
				input = sc.nextLine();
				if (input.equals("-1"))
					return;
				if (input.equals("1")) {
					c.viewPersonalInfo(username);
				} else if (input.equals("2")) {
					int accountNum = u.selectAnAccount(username, owner);
					if (accountNum != -1) {
						CustomerAccount customerAccount = CustomerActions.getCustomerAccountByUsername(username);
						UserActions.customerOptions(customerAccount, accountNum, owner);
					}
				} else {
					System.out.println("Invalid entry");
				}
			} else {
				System.out.println("1. View Personal Info\n2. Select A Bank Account\n3. Apply For Joint Account\n-1 Exit");
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
					System.out.println("Invalid entry");
				}
			}
		}
	}
	
	/*
	 * Creates and saves new user login accounts to file.
	 */
	public boolean register(String username, String password, int type) {
		if (usernameExists(username)) {
			System.out.println("User name taken");
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

	/*
	 * Determines if a username is already taken.
	 */
	public static boolean usernameExists(String username) {
		ArrayList<UserAccount> userAccounts = getAccounts();
		
		if (userAccounts != null)
			for (UserAccount userAccount : userAccounts) 
				if (userAccount.getUsername().equals(username)) 
					return true;
		return false;
	}	
	
	/*
	 * Retrieves a user account with the provided username.
	 */
	public UserAccount getUserAccountByUsername(String username) {
		ArrayList<UserAccount> userAccounts = getAccounts();
		
		if (userAccounts != null) 
			for (UserAccount userAccount : userAccounts) 
				if (userAccount.getUsername().equals(username))
					return userAccount;
		return null;
	}
	
	/*
	 * Retrieves all of the user accounts from file.
	 */
	public static ArrayList<UserAccount> getAccounts() {
		return convert(UtilityActions.read(filename));
	}
	
	/*
	 * Converts a generic list to user login accounts.
	 */
	private static ArrayList<UserAccount> convert(ArrayList<?> list) {		
		ArrayList<UserAccount> userAccounts = null;
		
		if (list != null) {
			userAccounts = new ArrayList<UserAccount>();
			for (Object item : list)
				userAccounts.add((UserAccount) item);
		}
		return userAccounts;
	}

	/*
	 * Log a user in if credentials match.
	 */
	public boolean login(String user, String pass) {
		UserAccount userAccount = getUserAccountByUsername(user);
		
		if (userAccount != null)
			if (userAccount.getPassword().equals(pass))
				return true;
		return false;
	}
	
	/*
	 * Allows users to apply for joint ownership of a bank account.
	 */
	private void applyForJointAccount(String username) {
		CustomerAccount curAccount = CustomerActions.getCustomerAccountByUsername(username);
		UUID id;

		while (true) {
			System.out.println("Please enter a username to apply to\n-1 Exit");
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
