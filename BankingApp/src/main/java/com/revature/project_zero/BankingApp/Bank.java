package com.revature.project_zero.BankingApp;

import java.util.Scanner;

import com.revature.project_zero.beans.Account;
import com.revature.project_zero.beans.User;

public class Bank {
	
	public static void main(String[] args) {
		
		menu();
	}
	
	public static void menu() {
		char c = '\0';
		
		Scanner input = new Scanner(System.in);
		Account cust1 = new Account();
		Login login = new Login();
		User user = new User();
		
		System.out.println("Enter a name: ");
		String name = input.nextLine();
		System.out.println("Enter username: ");
		String username = input.nextLine();
		System.out.println("Enter password: ");
		String pd = input.nextLine();
		login.Signup(name, username, pd);
		
		System.out.println("===========================================");
		
		System.out.println("Welcome");
		System.out.println("A: Check balance");
		System.out.println("B: Deposit");
		System.out.println("C: Withdraw");
		System.out.println("E: Exit");
		
		do {
			System.out.println("Enter an option: ");
			c = input.next().charAt(0);
			
			switch(c) {
			
			case 'A':
				System.out.println("===========================================");
				System.out.println("Your balance is: $" + cust1.getBalance());
				System.out.println("===========================================");
				break;
				
			case 'B':
				System.out.println("===========================================");
				System.out.println("Enter an amount to deposit: ");
				double amount = input.nextDouble();
				cust1.deposit(amount);
				System.out.println("You have successfully deposited $" + amount);
				System.out.println("Your new balance is: $" + cust1.getBalance());
				System.out.println("===========================================");
				break;
				
			case 'C':
				System.out.println("===========================================");
				System.out.println("Enter an amount to withdraw: ");
				amount = input.nextDouble();
				cust1.withdraw(amount);
				System.out.println("You have succesfully withdrawn $" + amount);
				System.out.println("Your new balance is: $" + cust1.getBalance());
				System.out.println("===========================================");
				break;
				
			default:
				System.out.println("Invalid Option");
				break;
			}
			
		}while(c != 'E');
		System.out.println("===========================================");
		System.out.println("You've been logged out");
		System.out.println("Thank you for your service");
	}
}
