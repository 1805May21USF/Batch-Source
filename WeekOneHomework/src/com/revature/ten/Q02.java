/****************************************************
 * 		Name: Q02									*
 * 		Purpose: Prints the first 25 fibonacci      *
 * 				 numbers                        	*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

public class Q02 {
	public static void fibonacci() {
		// Provides the first two fibonacci numbers
		int value = 0;
		int value2 = 1;
		
		// Prints the first two fibonacci numbers
		System.out.println(value + "\n" + value2);
		// Calculates and prints the remaining twenty three fibonacci numbers
		for(int i = 0; i < 23; i++) {
			int temp = value;
			value = value2;
			value2 += temp;
			System.out.println(value2);
		}
	}
}
