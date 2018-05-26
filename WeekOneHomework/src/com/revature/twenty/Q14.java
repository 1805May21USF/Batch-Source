/****************************************************
 * 		Name: Q14									*
 * 		Purpose: Uses String input from the user    *
 * 				 to execute a switch statement      *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Q14 {
	public static void stringSwitch(Scanner scan) {
	// Requests input from the user
		System.out.println("What do you want to do?\n" + 
						   "(Enter square to find the square root of a number, date to display the current date, \n" +
						   "and anything else to print a broken up string.");
		
		// Retrieves the users input
		String input = scan.nextLine();
		
		// Uses a switch statement to process user input
		switch(input) {
			// Prints the current date and time if the user enters date
			case("date"): 	System.out.println(new SimpleDateFormat("yyyy.dd.mm | hh.mm.ssa").format(new Date()));
						  	break;
			// Requests the user enter a number if the user enters square
			case("square"): boolean flag = true;
							while(flag) {
								System.out.println("Please enter a number: ");
								
								// Tests if the user entered a number or not
								try {
									double value = Double.parseDouble(scan.nextLine());
									// Prints the square root of the entered number
									System.out.println(Math.sqrt(value));
									flag = false;
								}catch(NumberFormatException e) {
									// Lets the user know the entered value wasn't a number
									System.out.println("That is not a number!");
								}
							}
							break;
			// Splits a String into a String array and prints it if the user enters anything else
			default:		String sentence = "I am learning Core Java";
							String[] words = sentence.split(" ");
							System.out.println(Arrays.toString(words));
		}
	}
}
