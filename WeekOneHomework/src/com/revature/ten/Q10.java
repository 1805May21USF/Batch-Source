/****************************************************
 * 		Name: Q10									*
 * 		Purpose: Requests two numbers from the user *
 * 				 and states which is smaller    	*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import java.util.Scanner;

public class Q10 {
	public static void minimum(Scanner scan) {
		// Requests a number from the user and assigns the entered value to value1
		System.out.println("Enter a number: ");
		int value1 = scan.nextInt();
		
		// Requests a second number from the user and assigns the entered value to value2
		System.out.println("Enter a second number: ");
		int value2 = scan.nextInt();
		
		// Determins which number is smaller using a ternary operator and states which number is smaller
		int min = (value1 < value2) ? value1 : value2;	
		System.out.println(min + " is the smaller number!");
		
		scan.nextLine();
	}
}
