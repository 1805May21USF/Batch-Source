package com.revature.corejava;

import java.time.LocalDate;

public class Q14 
{
	private String[] stringArray;
	
	//Method takes in a number and uses it in the case statements.
	public void displayThreeRequestedItems(int selector)
	{
		switch(selector)
		{
		case 1:
			System.out.println(Math.sqrt(4));
			break;
		case 2:
			LocalDate currentDate = LocalDate.now();
			System.out.println(currentDate);
			break;
		case 3:
			String stringToArray = "I am learning Core Java";
			this.stringArray = stringToArray.split(" ");
			System.out.println(this.stringArray[0] +","+this.stringArray[1] +","+this.stringArray[2]+","+this.stringArray[3]+","+this.stringArray[4]);
			break;
		}
	}
}
