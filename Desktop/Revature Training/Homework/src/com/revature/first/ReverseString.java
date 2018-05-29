package com.revature.first;

public class ReverseString {
	
	public void rev(String str) 
	{
		String otherString = ""; //creating an empty string to put the reverse string for later.
		
		for(int i = str.length()-1; i>=0; i--) // starting a
		{
			otherString += str.charAt(i);
		}
		
		System.out.println("The Reverse string of "+str+" is: "+otherString);
	}

}
