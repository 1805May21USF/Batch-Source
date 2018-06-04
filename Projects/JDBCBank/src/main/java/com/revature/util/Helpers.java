package com.revature.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.daoimpl.CustomerAccountDAOImpl;
import com.revature.driver.Driver;

/*
 * Provides helper functionality.
 */
public class Helpers {
	private static Scanner sc = Driver.sc;
	
	/*
	 * Determines if a username already exists in the database.
	 */
	public static boolean usernameExists(String username) {
		CustomerAccountDAOImpl cadi = new CustomerAccountDAOImpl();
		List<CustomerAccount> customerAccounts = null;
		try {
			customerAccounts = cadi.getCustomerAccounts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (customerAccounts != null)
			for (CustomerAccount acc : customerAccounts) 
				if (acc.getUsername().equals(username))
					return true;
		return false;
	}
	
	/*
	 * Retrieves a valid number amount from the user.
	 */
	public static float getValidAmount() {
		float amt;
		
		while (true) {
			System.out.println("Amount:\n-1 Exit ");
			String input = sc.nextLine();	
			if (input.equals("-1"))
				return -1;
			try {
				amt = Float.parseFloat(input);
				if (amt >= 0)
					return amt;
				System.out.println("Please enter a positive number");
			} catch (NumberFormatException e) {
				System.out.println("Invalid number");
			}
		}
	}
	
	/*
	 * Retrieves a valid withdraw amount from user's bank account.
	 */
	public static float getValidWithdrawAmount(BankAccount acc) throws OverdraftException {
		float amt;
		
		//get valid amt against balance
		while (true) {
			//get valid float amt
			amt = getValidAmount();
			if (amt == -1)
				return -1;
			if (acc.getBalance() >= amt || amt == -1f) {
				return amt;
			}
			throw new OverdraftException("Amount greater than balance");
		}
	}
}
