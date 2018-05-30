package com.revature.bankAppApt1;

import java.util.Scanner;

public class Options extends Customer{
	
	public String firstName;
	public String lastName;
	public double with;
	public double balCh;
	public double balSav;
	public int options;
	public double depo;
	
	//
	
	public void whatYouWant(String first, String last, double ch, Object sav) 
	{
		
		Scanner input = new Scanner(System.in);
		Boolean keepGoing = true;
		
		
		while(keepGoing) 
		{
			
			System.out.println("Enter 1: Create a Joint Account");
			System.out.println("Enter 2: View Account");
			System.out.println("Enter 3: Withdraw");
			System.out.println("Enter 4: Deposit");
			System.out.println("Enter 5: Transfer Money between accounts");
			System.out.println("Enter 0: Exit");
			System.out.print("\nHere are your options: ");
			options = input.nextInt();
			
			
			if(options == 1) 
			{
				System.out.print("Enter First and Last Name: ");
				first = input.nextLine();
				firstName = first;
				/*System.out.print("Enter Last Name: ");
				last = input.nextLine();
				lastName = last;*/
				System.out.println("\nThanks,"+firstName+" you have created a joint account.\n");
			}
			else if(options == 2) 
			{
				System.out.println("\n\t\tWelcome, "+first+"!");
				System.out.println("\nCheckings: $"+ch);
				System.out.println("Savings: $"+sav+"\n");
			}
			else if(options == 3) 
			{
				System.out.print("\nHow much do you want to withdraw: ");
				with = input.nextDouble();
				do 
				{
					if(with >= 0.00) 
					{
						balCh = ch - with;
						System.out.println("\nYour new checking balance is: $"+balCh+"\n");
						ch = balCh;
						break;
					}
					else 
					{
						System.out.println("\nInvalid: Negative Input.");
						System.out.print("Enter amount > 0.00: ");
						with = input.nextDouble();
					}
					
					System.out.println("\n");
				}
				while(with >= 0.00);
				
			}
			else if(options == 4) 
			{
				System.out.print("\nHow much do you want to deposit?: ");
				depo = input.nextDouble();
				balCh = balCh + depo;
				System.out.println("Your new checking balance is: $"+balCh+"\n");
				ch = balCh;
				
			}
			else if(options == 5) 
			{
				System.out.print("\nHow much would you like to transfer?: ");
				with = input.nextDouble();
				balCh = ch - with;
				System.out.println("Amount Transfered: $"+with);
				System.out.println("Remaining Checking Balance: $"+balCh+"\n");
				
			}
			else 
			{
				System.out.println("\nByeeee\n");
				break;
				//keepGoing = false;
			}
		}
	}
	
	public double getCh() 
	{
		return balCh;
	}

}

