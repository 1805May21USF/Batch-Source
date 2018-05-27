package com.revature.corejava;

public class Q3 
{
	
	private String stringToBeReversed;
	
	public Q3()
	{
		this.stringToBeReversed = "United States Marine Corps";
	}
	
	public String getString()
	{
		return this.stringToBeReversed;
	}
	
	//Reverses the string by starting at the last character - printing it to the screen - repeating this process by walking backwards through the string
	public void reverseTheString()
	{
		for( int i = this.stringToBeReversed.length() -1; i >= 0; i--)
		{
			System.out.print(this.stringToBeReversed.charAt(i));
		}
	}

}
