package com.revature.corejava;
import java.lang.Character;

//extending abstract class Q18Abstract.java
public class Q18 extends Q18Abstract
{
	//Checks for uppercase chars, returns true when it finds one, otherwise false
	@Override
	public boolean checkForUpperCaseChars(String theString) 
	{
		char[] tempCharArray = theString.toCharArray();
		for(int i = 0; i < tempCharArray.length; i++)
		{
			if(Character.isUpperCase(tempCharArray[i]))
			{
				return true;
			}
		}
		return false;
		
	}
	
	//Converts the entire string to uppercase
	@Override
	public String convertCaseLowerToUpper(String theString) 
	{
		
		return theString.toUpperCase();
	}
	
	//parses the string of numbers to int and then adds 10
	@Override
	public int convertStringToInteger(String theString) 
	{
		
		return Integer.parseInt(theString) + 10;
	}
	
}
