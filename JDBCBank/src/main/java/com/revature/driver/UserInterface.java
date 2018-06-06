package com.revature.driver;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.bs.api.exceptions.IncorrectPasswordException;
import com.revature.bs.api.exceptions.OverdraftException;
import com.revature.daoimpl.AccountDAOimpl;
import com.revature.daoimpl.Bank_CustomerDAOimpl;
import com.revature.model.Account;
import com.revature.model.Bank_Customer;

public class UserInterface {
	public static Scanner input = new Scanner(System.in);
	Bank_Customer currentCustomer = null;
	ArrayList<Bank_Customer> bankCustomers = new ArrayList<Bank_Customer>();
	ArrayList<Account> BankAccounts = new ArrayList<Account>();
	
	public UserInterface()
	{	
		Bank_CustomerDAOimpl bankimplementation = new Bank_CustomerDAOimpl();
		AccountDAOimpl accountimplementation = new AccountDAOimpl();
		try 
		{
			this.bankCustomers = bankimplementation.getCustomerList();
			this.BankAccounts = accountimplementation.getAccountList();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public  boolean login()
	{
		String username = "";
		String password = "";
		
		//System.out.println("Welcome!");
		
		System.out.println("Please Enter your Username");
		username = input.nextLine();
		
		System.out.println("Enter Password");
		password= input.nextLine();
		
		for(Bank_Customer itr: this.bankCustomers) {
			if (itr.getUserName().equals(username)) {
				if(itr.getPassword().equals(password))
				{
					this.currentCustomer = itr;
					return true;
				}
					
					
			}
		}
		return false;
		
	}
	
	
		public boolean register()
		{		boolean usernamefound = false;
			 String userName = "";
			 String password = "";
			
			
			System.out.println("Enter a Username");
			userName = input.nextLine();
			System.out.println("Enter a Password");
			password = input.nextLine();
			
			for (Bank_Customer itr: this.bankCustomers) 
			{
				if(itr.getUserName().equals(userName)) 
				{
					usernamefound = true;
					break;
				}
				
			
			if(!usernamefound) 
			{
				
				bankCustomers.add(new Bank_Customer(userName,password));
				Bank_CustomerDAOimpl bankCustomerDAOImp = new Bank_CustomerDAOimpl();
				try {
					bankCustomerDAOImp.createCustomer(new Bank_Customer(userName,password));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
				
				
			}
			
		}
		return false;
	}
	
	
	
		
	public void start()
	{
		String userinput = "";
		while(!userinput.equals("3"))
			
		{
			System.out.println("1. Login ");
			System.out.println("2. Registration ");
			System.out.println("3. Exit ");
			
			userinput = input.nextLine();
			if (userinput.equals("1"))
			{
				if(login())
				{	
					System.out.println(" You have Successfully Logged in");
					customerBankAccount();
					//TODO TO ACCOUNT PAGE
				}
				else
				{
					throw new IncorrectPasswordException("Incorrect password, please try again");
				}
			}
			if(userinput.equals("2"))
			{
				if(register())
				{
					System.out.println(" You have successfully registered ");
					
				}
				else
				{
					System.out.println(" Failed to Register, please try again ");
				}
			}
			
		}
		
		
	}
		
	 private void customerBankAccount() 
	 {
		//System.out.println("In Customer bank account");
		 String customerInput= "";
		 while(!customerInput.equals("logout")) {	
			 
			 System.out.println("");
			 for(Account itr: this.BankAccounts) {
				 if(itr.getUserName().equals(currentCustomer.getUserName()))
				 {
					 System.out.println(itr.display());
				 }
			 }
			 System.out.println(" create account | deposit | withdraw | delete account ");
			  customerInput = input.nextLine();
			  String[] sepCustomerInput = customerInput.split(" ");
			  if (sepCustomerInput[0].equals("deposit")) 
			  {
				  deposit(sepCustomerInput);
			  }
			
			  
			  if(sepCustomerInput[0].equals("withdraw"))
			  {
				withdraw(sepCustomerInput);
			  }
			  if(sepCustomerInput[0].equals("create"))
			  {
				  createAccount();
			  }
			  if(sepCustomerInput[0].equals("delete"))
			  {
				  deleteAccount(sepCustomerInput);
			  }
		 }
	 }
		
	
			public void deposit(String[] command) 
	 {				
				
				double ammount = Double.parseDouble(command[1]);
				int accountNumber= Integer.parseInt(command[3]);
				for(Account itr:this.BankAccounts)
				{
					if (itr.getAccountID() == accountNumber)
					{
						itr.deposit(ammount);
						AccountDAOimpl adaoimpl = new AccountDAOimpl();
						try {
							adaoimpl.updateAccount(itr);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			}
		public void withdraw(String[] command) 
		{
			
			double ammount = Double.parseDouble(command[1]);
			int accountID = Integer.parseInt(command[3]);
			for(Account itr:this.BankAccounts)
			{
				if (itr.getAccountID() == accountID)
				{
					if (itr.getBalance()<ammount)
					{
						throw new OverdraftException("You ain't got enough cash");
					}
					itr.withdraw(ammount);
					AccountDAOimpl adaoimpl = new AccountDAOimpl();
					try {
						adaoimpl.updateAccount(itr);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		public void createAccount()
		{
			Account newAccount = new Account(0,this.currentCustomer.getUserName(),0,"","");
			AccountDAOimpl newAccountimpl = new AccountDAOimpl();
			try {
				newAccountimpl.createAccount(newAccount);
				this.BankAccounts = newAccountimpl.getAccountList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void deleteAccount(String[] command)
	
		{
			int accountID = Integer.parseInt(command[2]);
			for(Account itr: this.BankAccounts)
			{
				if(itr.getAccountID()==accountID)
				{
					if(itr.getBalance()!=0)
					{
						System.out.println("You need to empty the account before you can delete it, Thank You! ");
						break;
					}
					
					AccountDAOimpl deleteAccount = new AccountDAOimpl();
					try {
						deleteAccount.deleteAccount(itr);
						this.BankAccounts = deleteAccount.getAccountList();
					} catch (SQLException e) {
						// TODO Auto-generated cat
						e.printStackTrace();
					}
					break;
				}
			}
			
		}
}
