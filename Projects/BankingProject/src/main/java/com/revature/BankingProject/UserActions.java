package com.revature.BankingProject;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

import com.revature.Utility.UtilityActions;

/*
 * Provides interaction with user accounts.
 */
public class UserActions {
	private static File bankfilename = new File("BankAccounts.txt");
	private static File cusfilename = new File("CustomerAccounts.txt");
	private static File userfilename = new File("UserAccounts.txt");
	private static Scanner sc = App.sc;
	static NumberFormat formatter = new DecimalFormat("#0.00");
	
	/*
	 * Provides users with bank account options.
	 */
	public static void customerOptions(CustomerAccount customerAccount, int accountNum, boolean owner) {
		while (true) {
			if (!owner) {
				System.out.println("1. Check Balance\n-1 Exit");
				String option = sc.nextLine();
				
				if (option.equals("1")) {
					//Check Balance
					NumberFormat formatter = new DecimalFormat("#0.00");
					double balance = getBalance(customerAccount.getBankAccountIDs().get(accountNum));
					System.out.println("Balance: " + formatter.format(balance));
				} else if (option.equals("-1")) {
					//Exit
					break;
				} else {
					System.out.println("Invalid entry");
				}
			} else {
				System.out.println("1. Check Balance\n2. Withdraw\n3. Deposit\n4. Transfer\n-1 Exit");
				String option = sc.nextLine();
				
				if (option.equals("1")) {
					//Check Balance
					double balance = getBalance(customerAccount.getBankAccountIDs().get(accountNum));
					System.out.println("Balance: " + formatter.format(balance));
				} else if (option.equals("2")) {
					//Withdraw
					optionWithdraw(customerAccount, accountNum);
				} else if (option.equals("3")) {
					//Deposit
					optionDeposit(customerAccount, accountNum);
				} else if (option.equals("4")) {
					//Transfer
					optionTransfer(customerAccount, accountNum);
				} else if (option.equals("-1")) {
					//Exit
					break;
				} else {
					System.out.println("Invalid entry");
				}
			}
		}
	}

	/*
	 * Allows customers to deposit funds into their account.
	 */
	private static void optionDeposit(CustomerAccount customerAccount, int accountNum) {
		UUID bankAccountID = customerAccount.getBankAccountIDs().get(accountNum);
		BankAccount bankAccount = getBankAccountById(bankAccountID);
		
		double amt = UtilityActions.getValidAmount();
		if (amt == -1)
			return;
		
		deposit(bankAccount, amt);	
		App.log.info("Customer: " + customerAccount.getUsername() + 
				" Account #: " + accountNum + 
				" Deposited: " + formatter.format(amt));
	}
	
	/*
	 * Allows customers to withdraw funds from their account.
	 */
	public static void optionWithdraw(CustomerAccount customerAccount, int accountNum) {
		UUID bankAccountID = customerAccount.getBankAccountIDs().get(accountNum);
		BankAccount bankAccount = getBankAccountById(bankAccountID);
		
		double amt = UtilityActions.getValidWithDrawAmount(bankAccountID);
		if (amt == -1)
			return;
		
		withdraw(bankAccount, amt);	
		App.log.info("Customer: " + customerAccount.getUsername() + 
				" Account #: " + accountNum + 
				" Withdrew: " + formatter.format(amt));
	}
	
	/*
	 * Allows customers to transfer funds from their account to another.
	 */
	public static void optionTransfer(CustomerAccount customerAccount, int accountNum) {
		UUID bankAccountID = customerAccount.getBankAccountIDs().get(accountNum);
		
		double amt = UtilityActions.getValidWithDrawAmount(bankAccountID);
		if (amt == -1)
			return;
		
		UUID sender = customerAccount.getBankAccountIDs().get(accountNum);
		UUID receiver = getReceiverUUID();
		if (receiver == null)
			return;
		transfer(sender, receiver, amt);
		App.log.info("Customer: " + customerAccount.getUsername() + 
				" Account #: " + accountNum + 
				" Transfered: " + formatter.format(amt));
	}
	
	/*
	 * Retrieves the id of the transfer receiver's account.
	 */
	private static UUID getReceiverUUID() {
		String input;

		while (true) {
			System.out.println("Username to transfer funds to\n-1 Exit");
			input = sc.nextLine();
	
			if (input.equals("-1") || input.equals("admin"))
				return null;
			
			if (RegistrationActions.usernameExists(input)) {
				CustomerAccount customerAccount = CustomerActions.getCustomerAccountByUsername(input);
				return UtilityActions.getUUID(customerAccount);
			}
		}
	}
	
	/*
	 * Creates a new bank account.
	 */
	public static UUID createBankAccount() {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		BankAccount bankAccount = new BankAccount(); 
		
		if (bankAccounts == null)
			bankAccounts = new ArrayList<BankAccount>();
		bankAccounts.add(bankAccount);
		
		UtilityActions.write(bankAccounts, bankfilename);
        
        return bankAccount.getAccountID();
	}

	/*
	 * Retrieves all bank accounts from file.
	 */
	public static ArrayList<BankAccount> getBankAccounts() {
		return convertToBankAccounts(UtilityActions.read(bankfilename));
	}
	
	/*
	 * Converts a generic list to bank accounts.
	 */
	private static ArrayList<BankAccount> convertToBankAccounts(ArrayList<?> list) {		
		ArrayList<BankAccount> bankAccounts = null;
		
		if (list != null) {
			bankAccounts = new ArrayList<BankAccount>();
			for (Object item : list)
				bankAccounts.add((BankAccount) item); 
		}
		return bankAccounts;
	}
	
	/*
	 * Retrieves a bank account by the id.
	 */
	public static BankAccount getBankAccountById(UUID id) {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		
		if (bankAccounts != null) 
			for (BankAccount bankAccount : bankAccounts) 
				if (bankAccount.getAccountID().equals(id))
					return bankAccount;
		return null;
	}

	/*
	 * Determines if a bank account exists.
	 */
	public boolean bankAccountExists(UUID id) {
		BankAccount bankAccount = getBankAccountById(id);
		
		if (bankAccount != null)
			return true;
		return false;
	}

	/*
	 * Retrieves the current balance of an account.
	 */
	public static double getBalance(UUID id) {	
		BankAccount bankAccount = getBankAccountById(id);
		
		if (bankAccount != null) 
			return bankAccount.getBalance();
		return 0;
	}

	/*
	 * Allows for depositing of funds into a bank account balance.
	 */
	public static void deposit(BankAccount bankAccount, double amt) {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		
		if (bankAccounts != null) 
			for (BankAccount bc : bankAccounts) 
				if (bc.getAccountID().equals(bankAccount.getAccountID()))
					bc.setBalance(bc.getBalance() + amt);

		UtilityActions.write(bankAccounts, bankfilename);
	}

	/*
	 * Selects one of a customer's bank accounts.
	 */
	public int selectAnAccount(String username, boolean owner) {
		CustomerAccount customerAccount = CustomerActions.getCustomerAccountByUsername(username);
		ArrayList<UUID> bankAccountIDs = customerAccount.getBankAccountIDs();
		StringBuilder builder = new StringBuilder();
		
		builder.append("[ ");
		for (int i = 0; i < bankAccountIDs.size(); i++) {
			BankAccount bankAccount = UserActions.getBankAccountById(bankAccountIDs.get(i));
			if (bankAccount.isOpen())
				builder.append(i + " ");
		}		
		builder.append("]\n-1 Exit");
	
		while (true) {
			System.out.println("Please select an account number: " + builder);
			
			String accountNumInput = sc.nextLine();
			int accountNum;
			try {
				accountNum = Integer.parseInt(accountNumInput);
			} catch (NumberFormatException e) {
				break;
			}
			if (accountNum >= 0 && accountNum < bankAccountIDs.size()) {
				BankAccount bankAccount = UserActions.getBankAccountById(customerAccount.getBankAccountIDs().get(accountNum));
				if (bankAccount.isOpen())
					return accountNum;
			} else if (accountNum == -1) {
				break;
			}
		}
		return -1;
	}

	/*
	 * Withdraws funds from a bank account balance.
	 */
	public static void withdraw(BankAccount bankAccount, double amt) {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		
		if (bankAccounts != null) 
			for (BankAccount bc : bankAccounts) 
				if (bc.getAccountID().equals(bankAccount.getAccountID())) 
					bc.setBalance(bc.getBalance() - amt);
						
		UtilityActions.write(bankAccounts, bankfilename);
	}

	/*
	 * Allows for transfer of funds from one account to another.
	 */
	public static void transfer(UUID id, UUID id2, double amt) {
		BankAccount bankAccount = getBankAccountById(id);
		withdraw(bankAccount, amt);
		bankAccount = getBankAccountById(id2);
		deposit(bankAccount, amt);
	}
	
	/*
	 * Add an application for a bank account to a customer account.
	 */
	public void apply(CustomerAccount curAccount, UUID idOfBankAccountToAdd) {
		ArrayList<CustomerAccount> cusAccounts = CustomerActions.getCustomerAccounts();
		
		for (CustomerAccount acc : cusAccounts) 
			if (acc.getUsername().equals(curAccount.getUsername()))
					acc.addApply(idOfBankAccountToAdd);
		
		UtilityActions.write(cusAccounts, cusfilename);
	}

	/*
	 * Approves a bank account to access to the customer.
	 */
	public static void approveAccount(UUID id, CustomerAccount cus) {
		ArrayList<CustomerAccount> cusAccounts = CustomerActions.getCustomerAccounts();
		ArrayList<BankAccount> bankAccounts = UserActions.getBankAccounts();
		
		//Add new account to customer
		for (CustomerAccount acc : cusAccounts) {
			if (acc.getUsername().equals(cus.getUsername())) {
				acc.addBankAccountID(id);	
				//remove id from applies
				Iterator<UUID> i = acc.getApplies().iterator();
				while (i.hasNext()) {
				   UUID applyId = i.next();
				   if (applyId.equals(id))
					   i.remove();
				}
			}
		}
		UtilityActions.write(cusAccounts, cusfilename);
		
		//Change status of bank account to open
		for (BankAccount acc : bankAccounts) 
			if (acc.getAccountID().equals(id))
				acc.setOpen(true);
		UtilityActions.write(bankAccounts, bankfilename);
	}
	
	/*
	 * Denies access to a bank account for a customer. 
	 */
	public static void denyAccount(UUID id, CustomerAccount cus) {
		ArrayList<CustomerAccount> cusAccounts = CustomerActions.getCustomerAccounts();
		ArrayList<BankAccount> bankAccounts = UserActions.getBankAccounts();
		ArrayList<UserAccount> userAccounts = RegistrationActions.getAccounts();
		
		//Delete bankaccount
		Iterator<BankAccount> j = bankAccounts.iterator();
		while (j.hasNext()) {
			BankAccount acc = j.next();
		    if (acc.getAccountID().equals(id))
			   j.remove();
		}
		UtilityActions.write(bankAccounts, bankfilename);
		
		//Delete customer
		Iterator<CustomerAccount> i = cusAccounts.iterator();
		while (i.hasNext()) {
		   CustomerAccount acc = i.next();
		   if (acc.getUsername().equals(cus.getUsername()))
			   i.remove();
		}
		UtilityActions.write(cusAccounts, cusfilename);
		
		//Delete user account
		Iterator<UserAccount> k = userAccounts.iterator();
		while (k.hasNext()) {
			UserAccount acc = k.next();
		    if (acc.getUsername().equals(cus.getUsername()))
			   k.remove();
		}
		UtilityActions.write(userAccounts, userfilename);
	}

	/*
	 * View all customer account applications for accounts.
	 */
	public static void viewAccountApplies() {
		ArrayList<CustomerAccount> cusAccounts = CustomerActions.getCustomerAccounts();
		
		if (cusAccounts == null )
			return;
		
		for (CustomerAccount cus : cusAccounts) {
			for (UUID id : cus.getApplies()) {			
				System.out.println("Customer: [ " + cus.getUsername() + " ] has applied for an account.");
				System.out.println("1. Approve\n2. Deny\n-1 Exit");
				String input = sc.nextLine();
				if (input.equals("-1"))
					return;
				else if (input.equals("1")) 
					approveAccount(id, cus);
				else if (input.equals("2"))
					denyAccount(id, cus);
				else
					System.out.println("Invalid entry");
			}
		}
	}
}
