package com.revature.assignments;
import java.util.Scanner;

public class Q5 {
	
	
	//create a subString using the inputted string from the user
	//and the index of where the substring will end.
	public String SubString(String str, int index) {
		char [] oldString = str.toCharArray();
		String newString = "";
		
		
		for(int i = 0; i<=index;i++) {
			newString  += oldString[i];
		}
		
		
		return newString;
	}

}
