package com.revature.homeworks;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome {

	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	
	public ArrayList<String> namesPal()
	{
		//Array lists: one for names and one for palindromes
		ArrayList<String> namesList = new ArrayList<String>();
		ArrayList<String> palinList = new ArrayList<String>();
		
		//Adds all the names to the arrayList
		namesList.addAll(Arrays.asList("Karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did" ));
		
		//for loop to check each name for palindrom validity
		for (int i = 0; i < namesList.size(); i++)
		{
			
			//takes name and checks it with isPalin method
			boolean palin = isPalin(namesList.get(i));
			
			
			//if it is a palindrome add it to namesList
			if (palin == true)
			{
				palinList.add(namesList.get(i));
			}
		}
		
		return palinList;
	}
	
	//method to check if name is a palindrome
	boolean isPalin(String str)
	{
		for(int i = 0; i < (str.length()/2); i++)
		{
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
			{
				return false;
			}
		}

		return true;
		
	}
	
	
	//run method that is called by the main
	 public void run()
		{
				System.out.println("Question Eight: " + newLine + "-----------------------------");
				System.out.println("Printing out the names that are Palindromes");
				System.out.println(namesPal());
				System.out.println("-----------------------------");
				System.out.println();
		}
}
