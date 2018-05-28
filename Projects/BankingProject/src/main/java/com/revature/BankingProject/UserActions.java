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
		double amt = getAmount();
		
		if (amt == -1)
			return;
		
		deposit(bankAccount, amt);	
	}
	
	public void optionWithdraw(CustomerAccount customerAccount, int accountNum) {
		UUID bankAccountID = customerAccount.getBankAccountIDs().get(accountNum);
		BankAccount bankAccount = getBankAccountById(bankAccountID);
		double amt;
		
		while (true) {
			amt = getAmount();
			
			if (amt == -1)
				break;			
			if (bankAccount.getBalance() >= amt) {
				bankAccount.setBalance(bankAccount.getBalance() - amt);
				break;
			}
			System.out.println("Amount greater than balance, please enter a smaller amount.");
		}
		if (amt == -1)
			return;
		
		withdraw(bankAccount, amt);	
	}
	
	private double getAmount() {
		double depositAmt;
		String input;
		
		while (true) {
			System.out.println("Amount or -1 to Exit: ");
			input = sc.nextLine();
			
			try {			
				depositAmt = Double.parseDouble(input);
				if (input.equals("-1"))
					break;
				if (depositAmt > 0)
					break;
			} catch (NumberFormatException e) {
				
			} 
			System.out.println("Invalid entry, please enter a number.");	
		}
		return depositAmt;
	}

	public static UUID createBankAccount() {
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		BankAccount bankAccount = new BankAccount(); 
		bankAccounts.add(bankAccount);
		
		UtilityActions.write(bankAccounts, filename);
        
        return bankAccount.getAccountID();
	}

	//Get the accounts from the file
	public ArrayList<BankAccount> getBankAccounts() {
		return convertToBankAccounts(UtilityActions.read(filename));
	}
	
	//Convert generic array to BankAccount
	private ArrayList<BankAccount> convertToBankAccounts(ArrayList<?> list) {		
		ArrayList<BankAccount> bankAccounts = null;
		
		if (list != null) {
			bankAccounts = new ArrayList<BankAccount>();
			for (Object item : list)
				bankAccounts.add((BankAccount) item); 
		}
		return bankAccounts;
	}
	
	public BankAccount getBankAccountById(UUID id) {
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

	public double getBalance(UUID id) {	
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
}
