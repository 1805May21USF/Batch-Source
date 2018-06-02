package com.revature.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.daoimpl.CustomerAccountDAOImpl;
import com.revature.driver.Driver;

public class Helpers {
	private static Scanner sc = Driver.sc;
	
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
	
	public static float getValidAmount() {
		float amt;
		
		while (true) {
			System.out.println("Amount: ");
			String input = sc.nextLine();
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
	public static float getValidWithdrawAmount(BankAccount acc) {
		float amt;
		
		//get valid amt against balance
		while (true) {
			//get valid float amt
			amt = getValidAmount();
					
			if (acc.getBalance() >= amt || amt == -1f) {
				return amt;
			}
			System.out.println("Amount greater than balance, please enter a smaller amount.");
		}
	}
}
