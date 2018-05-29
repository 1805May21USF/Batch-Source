/****************************************************
 * 		Name: Q06									*
 * 		Purpose: Retrieve user input and determine  *
 * 				 if the entered number is even or   *
 * 				 odd								*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import java.util.Scanner;

public class Q06 {
	public static void oddOrEven(Scanner scan) {
		// Requests the user enter a number
		System.out.println("Please enter an integer value: ");
		
		boolean flag = true;
		
		while(flag) {
			// Retrieves the entered number and divides it by two before multiplying it by two
			try {
				int i = scan.nextInt();
				int temp = i / 2;
				temp *= 2;
			
				// Tests if the number is even, odd, or zero
				if(i == 0) {
					System.out.println("Zero is neither odd or even!");
					flag = false;
				}
				else if(temp == i) {
					System.out.println(i + " is even!");
					flag = false;
				}
				else {
					System.out.println(i + " is odd!");
					flag = false;
				}
			// Executes if a number is not entered
			}catch(NumberFormatException e){
				System.out.println("That is not a number!");
			}
			
		}
		
		scan.nextLine();
	}
}
