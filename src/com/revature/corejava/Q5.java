package com.revature.corejava;

public class Q5 
{
	
	private String constructedSubString;
	
	public Q5()
	{
		this.constructedSubString = "";
	}
	
	//Creates and returns a substring by starting at index 0 and concatenating the characters up to the submitted index
	public String subString(String input, int index)
	{
		if(index < 1)
		{
			return "Index must be >= 1";			
		}
		
		for(int i = 0; i< index; i++)
		{
			this.constructedSubString = this.constructedSubString + input.charAt(i);
		}
		
		return this.constructedSubString;
	}

}
