/**
 * Reverse a string without using a temporary variable.  
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 * 
 * Completed: No
 */
package com.revature.corejava;

import java.util.Arrays; 

/**
 * @author Nicholas Smith
 *
 */
public class Q03
{
	private String reversedString;
	
	//create a method called reverse.
	//method takes in a String as an argument.
	public String reverse(String wordString) 
	{
		//examine each character of the string
		//find the length of the string
		//store the last character of the string in the 
		//first index of a new char array
		
		//assign length to the length of whatever is passed in
		int length = wordString.length();
		
		//create a new charArray
		char[] charArray = new char[length];
		
		//loop over the array
		int i = 0;
		while (length != 0) 
		{
			//assign the first element in the array to the last character in the string 
			charArray[i] = wordString.charAt(length - 1);
			
			//subtract 1 from length 
			length --;
			i ++;
		}	
				
		//assign reversedString to the charArray
		reversedString = new String(charArray);
			
		//return the String
		return reversedString;
	}
	
	//create a method to print the solution to the problem
	public void printSolution(String word) 
	{
		System.out.println("Q3: " + word);
	}
	
}
