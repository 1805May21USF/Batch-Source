/**
 * Write a substring method that accepts a string str and an integer idx and returns 
 * the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the 
 * existing substring methods in the String, StringBuilder, or StringBuffer APIs.
 * 
 * Completed: Yes
 */
package com.revature.corejava;

import java.util.Arrays;

/**
 * @author Nicholas Smith
 *
 */
public class Q05
{
	//create global variables
	String subString = new String("a");
	
	//create a method that prints the solution to the problem
	public void printSolution(String word) 
	{
		System.out.println("Q5: " + word);
	}
	
	//create a substring method
	//returns a String
	//takes a String str and int idx
	public String subString(String str, int idx) 
	{	
		String originalString = str;
		subString = "";
		String charString = "";
		String testString = "";
		
		//create a char array
		//the size 
		char[] charArray = new char[idx];
				
		//add the characters of the String to the char array up to the idx element
		for(int i = 0; i <= idx-1; i++) 
		{
			//assign element at index i to char at i 
			charArray[i] = originalString.charAt(i);
		}
		
		//convert the charrArray to a string
		charString = Arrays.toString(charArray);
		
		//assign subString to a new String that contains characters from the charArray
		subString = new String(charArray);
		
		return subString;
	}
}
