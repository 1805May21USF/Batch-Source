package com.revature.corejavaassignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Uses a switch statement to find the square root of a number,
 * output the current date, or splits a String into a
 * String array, depending on the argument.
 * @author Nathaniel Simpson
 *
 */
public class Q14Switch {

	/*
	 * Uses a switch statement to find the square root of a number,
	 * output the current date, or splits a String into a
	 * String array, depending on the argument.
	 */
	private static void q14Switch(int input) {

		switch (input) {
		case 1: 
			int radicand = 25;
			System.out.println("\tThe square root of " + radicand + " is " + Math.sqrt(radicand));
			break;
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println("\tToday's date is " + dateFormat.format(date));
			break;
		case 3:
			String string = "I am learning Core Java";
			String[] stringArray = string.split(" ");
			System.out.println("\tString to String array:");
			System.out.println("\t\tString - " + string);
			System.out.println("\t\tString array - ");
			for (String s : stringArray) {
				System.out.println("\t\t\t\t" + s);
			}
		}

	}
	
	/*
	 * Demonstrates the switch statement
	 */
	public static void switchDemo() {
		System.out.println("Q14. Switch");
		q14Switch(1);
		q14Switch(2);
		q14Switch(3);
		System.out.println(); //Making room for Q15
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		q14Switch(1);
		q14Switch(2);
		q14Switch(3);
	}

}
