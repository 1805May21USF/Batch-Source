package com.revature.main;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.beans.UserTransaction;
import com.revature.daoimpl.BankAccountDAOImpl;
import com.revature.daoimpl.CustomerAccountDAOImpl;
import com.revature.daoimpl.UserTransactionDAOImpl;
import com.revature.driver.Driver;
import com.revature.util.Helpers;

/*
 * Provides main banking functionalities.
 */
public class BankingActions {
	private static Scanner sc = Driver.sc;
	private static BankAccountDAOImpl badi = Driver.badi;
	private static CustomerAccountDAOImpl cadi = Driver.cadi;
	private static UserTransactionDAOImpl uadi = Driver.uadi;
	private static NumberFormat formatter = new DecimalFormat("#0.00");
	
	/*
	 * Provides customers with account options.
	 */
	public static void userOptions(CustomerAccount cus) {
		while (true) {
			System.out.println("1. View Personal Info\n2. Select A Bank Account\n3. Create A Bank Account\n-1 Exit");
			String input = sc.nextLine();
			if (input.equals("-1"))
				return;
			if (input.equals("1")) {
				viewPersonalInfo(cus);
			} else if (input.equals("2")) {
				int selection = selectAnAccount(cus);
				if (selection != -1)
					customerOption(selection, cus);
			} else if (input.equals("3")) {
				try {
					badi.createBankAccount(new BankAccount(0, 0, cus.getUser_ID()));
					System.out.println("Bank Account Creation Success");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Invalid entry");
			}
		}
	}
	
	/*
	 * Provides customers with main banking functionalities with their bank account.
	 */
	private static void customerOption(int bankAccountID, CustomerAccount cus) {
		while (true) {
			System.out.println("1. Check Balance\n2. Withdraw\n3. Deposit\n4. View Recent Transactions\n5. Close Account\n-1 Exit");
			String option = sc.nextLine();
			
			BankAccount acc = getBankAccount(bankAccountID);
			
			if (option.equals("1")) {
				//Check Balance
				optionBalance(acc);
			} else if (option.equals("2")) {
				//Withdraw
				optionWithdraw(cus.getUser_ID(), acc);
			} else if (option.equals("3")) {
				//Deposit
				optionDeposit(cus.getUser_ID(), acc);
			} else if (option.equals("4")) {
				//View Transactions
				optionViewTransactions(bankAccountID, cus);
			} else if (option.equals("5")) {
				//Close Account
				if (optionClose(acc))
					return;				
			} else if (option.equals("-1")) {
				//Exit
				break;
			} else {
				System.out.println("Invalid entry");
			}
		}
	}
	
	private static void optionViewTransactions(int bankAccountID, CustomerAccount cus) {
		try {
			List<UserTransaction> userTransactions = uadi.getUserTransactions(new UserTransaction(0, cus.getUser_ID(), bankAccountID, ""));
			for (UserTransaction userTransaction : userTransactions) 
				System.out.println(userTransaction.getMessage() + " Bank Account ID: " + userTransaction.getBankAccountID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Displays the current bank account's balance.
	 */
	private static void optionBalance(BankAccount acc) {
		float balance = 0.0f;
		balance = acc.getBalance();
		System.out.println("Balance: " + formatter.format(balance));
	}

	/*
	 * Deletes the current bank account if the balance is 0.
	 */
	private static boolean optionClose(BankAccount acc) {
		float balance = 0.0f;
		balance = acc.getBalance();
		if (balance == 0) {
			try {
				badi.deleteBankAccount(acc);
				System.out.println("Account closed");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Can't close account with a positive balance.");
		}
		return false;
	}

	/*
	 * Returns a bank account by ID.
	 */
	private static BankAccount getBankAccount(int bankAccountID) {
		BankAccount acc = null;
		try {
			acc = badi.getByID(bankAccountID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return acc;
	}
	
	/*
	 * Allows customers to deposit funds into their bank account.
	 */
	private static void optionDeposit(int user_id, BankAccount acc) {
		float amt = Helpers.getValidAmount();
		if (amt == -1)
			return;
		
		acc.setBalance(acc.getBalance() + amt);
		try {
			badi.updateBankAccount(acc);
			System.out.println("Deposit successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Driver.log.info("Bank Account: " + acc.getBank_account_ID() +
				" Deposited: " + formatter.format(amt));
		try {
			uadi.createUserTransaction(new UserTransaction(0, user_id, acc.getBank_account_ID(), "Deposited " + amt + " into"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Allows customers to withdraw funds from their bank account.
	 */
	private static void optionWithdraw(int user_id, BankAccount acc) {
		float amt = Helpers.getValidWithdrawAmount(acc);
		if (amt == -1)
			return;
		
		acc.setBalance(acc.getBalance() - amt);
		try {
			badi.updateBankAccount(acc);
			System.out.println("Withdraw successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Driver.log.info("Bank Account: " + acc.getBank_account_ID() +
				" Withdrew: " + formatter.format(amt));
		try {
			uadi.createUserTransaction(new UserTransaction(0, user_id, acc.getBank_account_ID(), "Withdrew " + amt + " from"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Allows customers to choose what bank account they want to interact with.
	 */
	private static int selectAnAccount(CustomerAccount cus) {
		List<BankAccount> bankAccounts = null;
		try {
			//need to get customer's bank accounts, not all
			bankAccounts = badi.getCustomerBankAccounts(cus.getUser_ID());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//build account selection string
		StringBuilder bd = new StringBuilder();
		int size = bankAccounts.size();
		for (int i = 0; i < size; i++) {
			bd.append(i + " ");
		}
		//select an account
		int accNum;
		while (true) {
			System.out.println("Select an account: [ " + bd + "]" + "\n-1 to Exit");
			String accInput = sc.nextLine();
			if (accInput.equals("-1"))
				return -1;
			try {
				accNum = Integer.parseInt(accInput);
				if (accNum < size && accNum >= 0)
					return bankAccounts.get(accNum).getBank_account_ID();
			} catch (NumberFormatException e) {
				System.out.println("NumberFormatException was caught.");
			}
			System.out.println("Invalid entry");
		}
	}
	
	/*
	 * Allows customers to display their personal account info.
	 */
	private static void viewPersonalInfo(CustomerAccount cus) {
		System.out.println("Name: " + cus.getFirstname() + " " + cus.getLastname());
		System.out.println("Username: " + cus.getUsername());
		try {
			System.out.println("# of Accounts: " + badi.getCustomerBankAccounts(cus.getUser_ID()).size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Displays admin options.
	 */
	public static void AdminOptions() {
		while (true) {
			System.out.println("1. Select A Customer Account\n2. Delete A Customer Account\n3. Create A Customer Account\n-1 Exit");
			String input = sc.nextLine();
			if (input.equals("-1"))
				return;
			if (input.equals("1")) {
				optionAdminSelect();
			} else if (input.equals("2")) {
				optionAdminDelete();
			} else if (input.equals("3")) {
				optionAdminCreate();
			} else {
				System.out.println("Invalid entry");
			}
		}
	}

	/*
	 * Allows the admin to create a new customer account.
	 */
	private static void optionAdminCreate() {
		Driver.optionRegister();
	}
	
	/*
	 * Allows the admin to delete a customer account.
	 */
	private static void optionAdminDelete() {
		System.out.println("Please select a user account by username:\n-1 Exit ");
		String user = sc.nextLine();
		if (user.equals("-1"))
			return;
		if (Helpers.usernameExists(user)) {
			List<CustomerAccount> customerAccounts = null;

			try {
				customerAccounts = cadi.getCustomerAccounts();
				for (CustomerAccount cus : customerAccounts) 
					if (cus.getUsername().equals(user))
						cadi.deleteCustomerAccount(cus);
				System.out.println("Customer deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid username");
		}
	}

	/*
	 * Allows the admin to select a customer account to view/edit.
	 */
	private static void optionAdminSelect() {
		System.out.println("Please select a user account by username:\n-1 Exit ");
		String user = sc.nextLine();
		if (user.equals("-1"))
			return;
		if (Helpers.usernameExists(user)) {
			List<CustomerAccount> customerAccounts = null;

			try {
				customerAccounts = cadi.getCustomerAccounts();
				for (CustomerAccount cus : customerAccounts) 
					if (cus.getUsername().equals(user))
						userOptions(cus);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid username");
		}
	}
}
