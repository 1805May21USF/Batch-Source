package com.revature.assignments;
import java.util.Scanner;



public class Q3 {
	//variable myString to hold the inputted String
	//Scanner in is a scanner to read in the values from the keyboard
	private static String myString;
	private static Scanner in = new Scanner(System.in);
	
	public static  void StringReverse() {
		
		//get the next String from the user.
		System.out.println("Enter a String so that I can reverse it!");
		myString = in.nextLine();
		
		//holds the length of the initial string since the 
		//String length will change and the while loop condition will never be met
		int length = myString.length();
		int i= 1;
		
		//while i is less than double the length 
		while( i <= (length -1) * 2) {
		myString = myString.substring(i, i+1) + myString;
		i+=2;
		}
		//substring the front of the string 
		//which is now the string reversed and set the variable myString to that value.
		myString = myString.substring(0,length);
		System.out.println(myString);
		
	}	
}
	


