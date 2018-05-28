package com.sunnara.homework;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Write a program that demonstrates the switch case. 
 * Implement the following functionalities in the cases:java
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display todayÅfs date.
 * Case 3: Split the following string and store it in a string array.
 *      	 ÅgI am learning Core JavaÅh
 */
public class Q14 {
	String[] storeMe;
	public static void main(String[] args) {
		Q14 q14 = new Q14();
		q14.start();
	}
	
	public void start() {
		System.out.println("Question 14:");
		System.out.println("Testing case 1: Show the square root");
		switchMe(1);
		System.out.println("Testing case 2: Display the date");
		switchMe(2);
		System.out.println("Testing case 3: Display String array");
		switchMe(3);
		System.out.println("\n");
	}
	
	public void switchMe(int i) {
		switch (i) {
		case 1:
			int x = 25;
			NumberFormat nf = new DecimalFormat("##.###"); //Show decimals when necessary
			System.out.println("The square root of " + x + " is " + nf.format(Math.sqrt(x)));
			break;
		case 2:
			DateFormat df = new SimpleDateFormat("MMM d, yyyy"); //Formated Month day, year
			Date d = new Date();
			System.out.println("It is " + df.format(d)); //formats Date and print
			break;
		case 3:
			String s = "I am learning Core Java";
			storeMe = s.split(" "); //Splits into array after " "
			System.out.print("[");
			for(int j = 0; j < storeMe.length; j++) {
				if((j+1 == storeMe.length)) {
					System.out.print(storeMe[j]); //removes  , for last in print
				} else {
					System.out.print(storeMe[j] + ",");
				}
				
			}
			System.out.print("]");
		default: 
		}
	}
}
