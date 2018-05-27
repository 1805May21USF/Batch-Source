package com.revature.corejava;

import java.util.ArrayList;

public class Q8 
{
	
	private ArrayList<String> myStrings;
	private ArrayList<String> myPalindromes;
	
	public Q8()
	{
		this.myStrings = new ArrayList<String>();
		this.myPalindromes = new ArrayList<String>();
		this.myStrings.add("karan");
		this.myStrings.add("madam");
		this.myStrings.add("tom");
		this.myStrings.add("civic");
		this.myStrings.add("radar");
		this.myStrings.add("jimmy");
		this.myStrings.add("kayak");
		this.myStrings.add("john");
		this.myStrings.add("refer");
		this.myStrings.add("billy");
		this.myStrings.add("did");
		this.findPalindromes();
		
	}
	
	public void findPalindromes()
	{
		//Goes through ArrayList, myString, and calls a method to check for palindrome. If found, the strings are added to ArrayList myPalindromes
		for(int i = 0; i < this.myStrings.size(); i++)
		{
			
			if(checkForPalindrome(this.myStrings.get(i)))
			{
				this.myPalindromes.add(this.myStrings.get(i));
			}
		}
	}
	//Performs the check on a individual string to see if it is a palindrome by reversing the string and comparing it to its original
	private boolean checkForPalindrome(String stringInQuestion)
	{
		StringBuilder reverseString = new StringBuilder();
		for(int i = stringInQuestion.length() - 1; i >= 0; i--)
		{
			reverseString.append(stringInQuestion.charAt(i));
			
		}
		
		return (reverseString.toString().equals(stringInQuestion));
	}
	
	public void displayPalindromes()
	{
		System.out.println(this.myPalindromes);
	}

}
