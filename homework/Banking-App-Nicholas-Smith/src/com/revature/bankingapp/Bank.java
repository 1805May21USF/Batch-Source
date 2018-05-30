/**
 * This class is a representation of a banking application. 
 */
package com.revature.bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nicholas Smith
 *
 */
public class Bank
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//create a Scanner object to take user input
		Scanner input = new Scanner(System.in);
		
		//how it will work:
		//User applies for account
		//Employee reads application
		//Employee will approve or deny application
		//If approved, customer registers for an account
		//The customer can interact with Scanner now
		
		//Create some sample customers.
		Customer cust1 = new Customer("Mike", 758331245, 41);
		Customer cust2 = new Customer("Joe", 288471212, 16);
		Customer cust3 = new Customer("Terry", 874251254, 21);
		
		//Create some sample employees.
		Employee emp1 = new Employee("Malissa", 7889);
		Employee emp2 = new Employee("Richard", 6121);
		
		//view customer information
		//cust1.printCustomer();
		//cust2.printCustomer();
		//cust3.printCustomer();
		
		//Customers apply.
		Application cust1App = cust1.apply();
		Application cust2App = cust2.apply();
		Application cust3App = cust3.apply();
		
		//Employees review the application.
		emp1.readApplication(cust1App);
		emp2.readApplication(cust2App);
		emp1.readApplication(cust3App);
		
		//Mike and Terry can register because they are older than 18.
		Account account1 = cust1.register("mike", "123");
		Account account2 = cust2.register("terry", "789");
		
		//Greet the user.
		System.out.println("Welcome to Bank.");
		
		//Prompt user to enter user name.
		System.out.println("Please enter username: ");
		
		String username1 = input.next();
				
		//Prompt user to enter password
		System.out.println("Please enter password");
		
		String password1 = input.next();
		
		//Mike attempts to login. Use "mike" for username and "123" for password.
		if(username1.equals(account1.getUsername()) && password1.equals(account1.getPassword()))
		{
			System.out.println("Hello " + cust1.getName());
			
			System.out.println("View balance: Press 1");
			System.out.println("Deposit: Press 2");
			System.out.println("Withdraw: Press 3");
			System.out.println("Transfer: Press 4");
			
			//number is assigned to what Mike enters
			int number = input.nextInt();
			
				if(number == 1) 
				{
					account1.printBalance();
				}
				if(number == 2) 
				{
					System.out.println("Enter amount: ");
					double amount = input.nextDouble();
					account1.deposit(amount);
				}
				if(number == 3) 
				{
					System.out.println("Enter amount: ");
					double amount = input.nextDouble();
					account1.withdraw(amount);
				}
				if(number == 4) 
				{
					System.out.println("Enter amount: ");
					double amount = input.nextDouble();
					cust1.transfer(account1, account2, amount);
				}
				if(number == 5) 
				{
					System.out.println("Goodbye.");
				}
			
			
		}
		else 
		{
			System.out.println("Incorrect username and password. Goodbye.");
		}
	}
}
