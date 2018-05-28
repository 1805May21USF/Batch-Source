package com.revature.BankingProject;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.revature.Utility.UtilityActions;

public class UserActions {
	private static File filename = new File("BankAccounts.txt");
	private static File cusfilename = new File("CustomerAccounts.txt");
	private static Scanner sc = App.sc;
	
	public void customerOptions(CustomerAccount customerAccount, int accountNum) {
		while (true) {
			System.out.println("Select 1 for Check Balance, 2 for Withdraw, 3 for Deposit, 4 for Transfer, -1 for Exit");
			String option = sc.nextLine();
			
			if (option.equals("1")) {
				//Check Balance
				NumberFormat formatter = new DecimalFormat("#0.00");
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
				System.out.println("Invalid entry, ");
			}
		}
	}

	private void optionDeposit(CustomerAccount customerAccount, int accountNum) {
		UUID bankAccountID = customerAccount.getBankAccountIDs().get(accountNum);
		BankAccount bankAccount = getBankAccountById(bankAccountID);
		
		double amt = UtilityActions.getValidAmount();
		if (amt == -1)
			return;
		
		deposit(bankAccount, amt);	
	}
	
	public void optionWithdraw(CustomerAccount customerAccount, int accountNum) {
		UUID bankAccountID = customerAccount.getBankAccountIDs().get(accountNum);
		BankAccount bankAccount = getBankAccountById(bankAccountID);
		
		double amt = UtilityActions.getValidWithDrawAmount(bankAccountID);
		if (amt == -1)
			return;
		
		withdraw(bankAccount, amt);	
	}
	
	public void optionTransfer(CustomerAccount customerAccount, int accountNum) {
		UUID bankAccountID = customerAccount.getBankAccountIDs().get(accountNum);
		
		double amt = UtilityActions.getValidWithDrawAmount(bankAccountID);
		if (amt == -1)
			return;
		
		UUID sender = customerAccount.getBankAccountIDs().get(accountNum);
		UUID receiver = getReceiverUUID();
		if (receiver == null)
			return;
		transfer(sender, receiver, amt);
	}
	
	private UUID getReceiverUUID() {
		String input;

		while (true) {
			System.out.println("Username to transfer funds to, -1 to Exit: ");
			input = sc.nextLine();
			
			if (input.equals("-1"))
				return null;
			
			if (RegistrationActions.usernameExists(input)) {
				CustomerAccount customerAccount = CustomerActions.getCustomerAccountByUsername(input);
				return UtilityActions.getUUID(customerAccount);
			}
		}
	}
	
	public static UUID createBankAccount() {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		BankAccount bankAccount = new BankAccount(); 
		
		if (bankAccounts == null)
			bankAccounts = new ArrayList<BankAccount>();
		bankAccounts.add(bankAccount);
		
		UtilityActions.write(bankAccounts, filename);
        
        return bankAccount.getAccountID();
	}

	//Get the accounts from the file
	public static ArrayList<BankAccount> getBankAccounts() {
		return convertToBankAccounts(UtilityActions.read(filename));
	}
	
	//Convert generic array to BankAccount
	private static ArrayList<BankAccount> convertToBankAccounts(ArrayList<?> list) {		
		ArrayList<BankAccount> bankAccounts = null;
		
		if (list != null) {
			bankAccounts = new ArrayList<BankAccount>();
			for (Object item : list)
				bankAccounts.add((BankAccount) item); 
		}
		return bankAccounts;
	}
	
	public static BankAccount getBankAccountById(UUID id) {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		
		if (bankAccounts != null) 
			for (BankAccount bankAccount : bankAccounts) 
				if (bankAccount.getAccountID().equals(id))
					return bankAccount;
		return null;
	}

	public boolean bankAccountExists(UUID id) {
		BankAccount bankAccount = getBankAccountById(id);
		
		if (bankAccount != null)
			return true;
		return false;
	}

	public static double getBalance(UUID id) {	
		BankAccount bankAccount = getBankAccountById(id);
		
		if (bankAccount != null) 
			return bankAccount.getBalance();
		return 0;
	}

	public void deposit(BankAccount bankAccount, double amt) {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		
		if (bankAccounts != null) 
			for (BankAccount bc : bankAccounts) 
				if (bc.getAccountID().equals(bankAccount.getAccountID()))
					bc.setBalance(bc.getBalance() + amt);

		UtilityActions.write(bankAccounts, filename);
	}

	public void selectAnAccount(String username) {

		CustomerAccount customerAccount = CustomerActions.getCustomerAccountByUsername(username);
		ArrayList<UUID> bankAccountIDs = customerAccount.getBankAccountIDs();
		StringBuilder builder = new StringBuilder();
		
		builder.append("[ ");
		for (int i = 0; i < bankAccountIDs.size(); i++) {
			builder.append(i + " ");
		}		
		builder.append("] or -1 for Exit.");
	
		while (true) {
			System.out.println("Please select an account number: " + builder);
			
			String accountNumInput = sc.nextLine();
			int accountNum = Integer.parseInt(accountNumInput);
			if (accountNum >= 0 && accountNum < bankAccountIDs.size()) {
				customerOptions(customerAccount, accountNum);
			} else if (accountNum == -1) {
				break;
			}
		}
	}

	public void withdraw(BankAccount bankAccount, double amt) {
		ArrayList<BankAccount> bankAccounts = getBankAccounts();
		
		if (bankAccounts != null) 
			for (BankAccount bc : bankAccounts) 
				if (bc.getAccountID().equals(bankAccount.getAccountID())) 
					bc.setBalance(bc.getBalance() - amt);
						
		UtilityActions.write(bankAccounts, filename);
	}

	public void transfer(UUID id, UUID id2, double amt) {
		BankAccount bankAccount = getBankAccountById(id);
		withdraw(bankAccount, amt);
		bankAccount = getBankAccountById(id2);
		deposit(bankAccount, amt);
	}
	
	public void apply(CustomerAccount curAccount, UUID idOfBankAccountToAdd) {
		ArrayList<CustomerAccount> cusAccounts = CustomerActions.getCustomerAccounts();
		
		for (CustomerAccount acc : cusAccounts) 
			if (acc.getUsername().equals(curAccount.getUsername()))
					acc.addApply(idOfBankAccountToAdd);
		
		UtilityActions.write(cusAccounts, cusfilename);
	}
	
	//approve/deny applies
}
