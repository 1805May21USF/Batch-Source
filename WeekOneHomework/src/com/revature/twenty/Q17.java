/****************************************************
 * 		Name: Q17									*
 * 		Purpose: Calculates the interest collected  *
 * 				 on an amount of money where the    *
 * 				 user enters the principal amount,  *
 * 				 the interest rate and how long the *
 * 				 principal has been collecting      *
 * 				 interest							*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

import java.util.Scanner;

public class Q17 {
	public static void interest(Scanner scan) {
		boolean flag = true;
		
		// Executes until the user is finished
		while(flag) {
			// Requests a principal amount and loops until one is provided
			System.out.println("Please enter the principal amount: ");
			
			String input = scan.nextLine();
			
			try {
				double principal = Double.parseDouble(input);
				
				while(flag) {
					// Requests the yearly interest rate and loops until one is provided
					System.out.println("Please enter the yearly interest rate: ");
				
					input = scan.nextLine();
				
					try {
						// Multiplies the interest rate by .01 in order to get the percentage
						double rate = Double.parseDouble(input) * 0.01;
						
						while(flag) {
							// Requests the number of years the money has been collecting interest and loops until it's provided
							System.out.println("Please enter the number of years the money has been collecting interest: ");
							
							input = scan.nextLine();
							
							try {
								int years = Integer.parseInt(input);
								
								// Prints the initial amount, the amount of interest, and the current amount
								System.out.println("The initial amount was $" + principal);
								System.out.println("The amount of interest collected was $" + (principal * rate * years));
								System.out.println("The current amount is $" + (principal + (principal * rate * years)));
								flag = false;
							}catch(NumberFormatException e) {
								System.out.println("That is not a number!");
							}
						}
					}catch(NumberFormatException e) {
						System.out.println("That is not a number!");
					}
				}
			}catch(NumberFormatException e) {
				System.out.println("That is not a number!");
			}
		}
	}
}
