/****************************************************
 * 		Name: Q11									*
 * 		Purpose: Retrieves float values from another*
 * 				 package, prints them, and then     *
 * 				 modifies them before printing them *
 * 			     again								*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

public class Q11 {
	public static void print() {
		// Prints the values stored in the Storage class in the com.revature.storage package
		System.out.println("Default storage values: ");
		System.out.println(com.revature.storage.Storage.small);
		System.out.println(com.revature.storage.Storage.large);
		
		// Changes the values stored in the Storage class in com.revature.storage
		com.revature.storage.Storage.small = 0.2f;
		com.revature.storage.Storage.large = 9.5f;
		
		// Prints the changed values
		System.out.println("Changed storage values: ");
		System.out.println(com.revature.storage.Storage.small);
		System.out.println(com.revature.storage.Storage.large);
	}
}
