package com.revature.beans;
/*Q16. Write a program to display the number of characters for a string input. The string 
 * should be entered as a command line argument using (String [ ] args).*/
public class Problem16 {
	public static int getNumberOfCharsInString(String[] args){
		int a = 0;
		for(String s: args){
			a += s.length();
		}
		return a;
	}
}
