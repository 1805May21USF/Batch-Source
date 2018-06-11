package com.revature.bankAppApt1;

import java.util.Scanner;

public class Checking extends Options {
	
	public void correctInput(Object one, Object two, Object three, Object four, Boolean x) 
	{
		Scanner input = new Scanner(System.in);
		Options op = new Options();
		Customer c = new Customer();
		LoginCustomer lc = new LoginCustomer();
		
		if (one.equals(two) && three.equals(four)) 
		{
			System.out.println("\n\t\tWelcome! "+c.getFName());
			//op.whatYouWant(lc.getJoiningFirst());
			x = false;
		}
		else 
		{
			System.out.println("Incorrect username and password.");
			System.out.println("Enter username: ");
			lc.setLoginUserName(input.nextLine());
			System.out.println("Enter password: ");
			lc.setLoginPassword(input.nextLine());
		}
	
	}

}
