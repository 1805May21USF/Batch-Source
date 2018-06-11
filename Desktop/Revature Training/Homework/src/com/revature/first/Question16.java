package com.revature.first;

import java.util.Scanner;

public class Question16 {
	
	public void CountCharacters(String phrase) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("What's your phrase: ");
		String something = input.nextLine();
		
		int number = something.length();
		System.out.println("The number of characters in: "+something+" is: "+number);
		
		
		
	}
	
	
	
	

}
