package com.revature.console;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.service.*;

public class TransactionsView {
	Scanner input = new Scanner (System.in);
	Service service = new Service();
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	public void createAccount(String username)
	{
		double initialAmount = 0.0;
		System.out.println("Enter an intial amount.");
		initialAmount = input.nextDouble();
		service.createAccount(username, initialAmount);
		System.out.println("You have successfully created an account!");
		
	}
	
	public void checkAccounts(String username)
	{
		List <Account> acc = service.getAccounts(username);
		
		System.out.println(newLine + "Your accounts are:");
		for(Account a: acc )
		{
			System.out.println("Account Number: "+ a.getAccountId() +newLine+ "Balance: " + a.getBalance());
			System.out.println();
		}
		
	}
	
	public void withdraw(String username)
	{
		
		double w;
		boolean wAmountIsValid = false;
		System.out.println("You can withdraw as much vibrainum as you have.");
		checkAccounts(username);
		System.out.println("Which account would you like to withdraw from?");
		int accountId = input.nextInt();
		System.out.println("Your current balance is " + service.getAccountBalance(username, accountId) + " V");
		
		do
		{
			System.out.println("How much do you want to withdraw?");
			while(!input.hasNextDouble())
		     {
		    	 String input1 = input.next();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter a valid number.", input1);
		     }
		     w = input.nextDouble();
		     if (w < 0)
			{
					System.out.println("input is invalid");
			}
		     else
		    {
				wAmountIsValid = true;
				
				if (service.withdraw(w, username, accountId) == true)
				{
					double balance = service.getAccountBalance(username, accountId);
					System.out.println("Your withdrawal was successful. You now have a balance of "+ balance + " V");
					if (balance == 0.0)
					{
						System.out.println("Would you like to close this account? Enter yes or no");
						String decision = input.next();
						if(decision.equalsIgnoreCase("yes"))
						{
							service.closeAccount(username, accountId);
							System.out.println(newLine + "Your account has been deleted successfully.");
						}
						else if (decision.equalsIgnoreCase("no"))
						{
							System.out.println("Alright, returning to menu...");
						}
						else
						{
							System.out.println("Invalid option.");
						}
					}
				}
				else
				{
					System.out.println("Withdrawal amount exceeded account balance");
				}
			}
		}while(wAmountIsValid == false);
	}
	
	public void deposit(String username)
	{
		double d;
		boolean dAmountIsValid = false;
		checkAccounts(username);
		System.out.println("Which account would you like to deposit to?");
		int accountId = input.nextInt();
		System.out.println("Your current balance is " + service.getAccountBalance(username, accountId) + " V");
		System.out.println("You can deposit as much vibrainum as you have.");
		
		do
		{
			System.out.println("How much do you want to deposit");
			while(!input.hasNextDouble())
		     {
		    	 String input1 = input.next();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter a valid number.", input1);
		     }
			d = input.nextDouble();
			if (d < 0)
			{
				System.out.println("input is invalid");
			}
			else
			{
				dAmountIsValid = true;
				if (service.deposit(d, username, accountId) == true)
				{
					System.out.println("Your deposit was successful. You now have a balance of "+ service.getAccountBalance(username, accountId) + " V");
				}
				else
				{
					System.out.println("Amount must be greater than 0.");
				}
			}
		}while(dAmountIsValid == false);
	}
	
	public void closeAccount(String username)
	{
		
		int accountId;
		String decision = null;
		
		checkAccounts(username);
		System.out.println("Which account would you like to deposit close?");
		accountId = input.nextInt();
		System.out.println("You have selected to close account "+ accountId + " with a balance of "+ service.getAccountBalance(username, accountId));
		System.out.println("Are you sure? Enter yes or no");
		decision = input.next();
		if(decision.equalsIgnoreCase("yes"))
		{
			service.closeAccount(username, accountId);
			System.out.println(newLine + "Your account has been deleted successfully.");
		}
		else if (decision.equalsIgnoreCase("no"))
		{
			System.out.println("Alright, returning to menu...");
		}
		else
		{
			System.out.println("Invalid option.");
		}
		
	}

}
