package com.revature.BankingProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.revature.Utility.UtilityActions;

/*
 * Provides interactions with customer accounts.
 */
public class CustomerActions {
	private static File filename = new File("CustomerAccounts.txt");

	/*
	 * Creates a new customer account with personal fields.
	 */
	public static CustomerAccount createCustomerAccount(String username, String name, String address, String age) {
		ArrayList<CustomerAccount> customerAccounts = getCustomerAccounts();
		CustomerAccount customerAccount = new CustomerAccount(name, address, age, username);
		
		if (customerAccounts == null)
			customerAccounts = new ArrayList<CustomerAccount>();
		customerAccounts.add(customerAccount);
		
		UtilityActions.write(customerAccounts, filename);
		
		return customerAccount;
	}
	
	/*
	 * Retrieves a customer account associated with the given username.
	 */
	public static CustomerAccount getCustomerAccountByUsername(String username) {
		ArrayList<CustomerAccount> customerAccounts = getCustomerAccounts();
		
		if (customerAccounts != null) 
			for (CustomerAccount customerAccount : customerAccounts) 
				if (customerAccount.getUsername().equals(username))
					return customerAccount;
		return null;
	}
	
	/*
	 * Retrieves all of the customer accounts.
	 */
	public static ArrayList<CustomerAccount> getCustomerAccounts() {
		return convertToCustomerAccounts(UtilityActions.read(filename));
	}
	
	/*
	 * Converts a generic list to customer accounts.
	 */
	private static ArrayList<CustomerAccount> convertToCustomerAccounts(ArrayList<?> list) {		
		ArrayList<CustomerAccount> customerAccount = null;
		
		if (list != null) {
			customerAccount = new ArrayList<CustomerAccount>();
			for (Object item : list)
				customerAccount.add((CustomerAccount) item);
		}
		return customerAccount;
	}
	
	/*
	 * Saves new customer accounts to file.
	 */
	public static void saveCustomerAccount(CustomerAccount customerAccount) {
		ArrayList<CustomerAccount> customerAccounts = getCustomerAccounts();
		
		for (CustomerAccount cus : customerAccounts)
			if (cus.getUsername().equals(customerAccount.getUsername()))
				cus.setApplies(customerAccount.getApplies());
		
		UtilityActions.write(customerAccounts, filename);
	}

	/*
	 * Retrieves and displays customer account personal information.
	 */
	public void viewPersonalInfo(String username) {
		CustomerAccount customerAccount = getCustomerAccountByUsername(username);
		System.out.println("Name: " + customerAccount.getName());
		System.out.println("Address: " + customerAccount.getAddress());
		System.out.println("Age: " + customerAccount.getAge());
		System.out.println("Username: " + customerAccount.getUsername());
		
		int openAccounts = 0;
		for (int i = 0; i < customerAccount.getBankAccountIDs().size(); i++) {
			if (UserActions.getBankAccountById(customerAccount.getBankAccountIDs().get(i)).isOpen())
				openAccounts++;
		}		
		System.out.println("Number of Accounts: " + openAccounts);
	}
}
