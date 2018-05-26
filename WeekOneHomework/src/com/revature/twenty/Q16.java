/****************************************************
 * 		Name: Q16									*
 * 		Purpose: Takes the args parameter and prints*
 * 				 the length of each argument        *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

public class Q16 {
	public static void main(String[] args) {
		// Prints each argument and number of characters in each
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i] + " has " + args[i].length() + " characters!");
		}
	}
}
