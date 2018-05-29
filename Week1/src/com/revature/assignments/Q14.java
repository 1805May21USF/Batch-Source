package com.revature.assignments;
import java.lang.Math;
import java.util.Date;

public class Q14 {
	
	//switchcase if (1)print the sqrt using the sqrt function.
	public int switchCase(int val) {
		
		switch(val) {
			
		case 1:{
			
			System.out.println(Math.sqrt(121));
			break;
		}
		
		case 2:{
			//print the new Date
			System.out.println(new Date());
			break;
		}
		
		case 3:{
			//create a string array using the subString
			String firstString = "I am learning core java.";
			String [] stringArray = new String[5];
	
			stringArray[0] = firstString.substring(0, 1);
			stringArray[1] = firstString.substring(2,4);
			stringArray[2] = firstString.substring(5,13);
			stringArray[3] = firstString.substring(14,18);
			stringArray[4] = firstString.substring(19,24);

			//StringArray print ever item
			for(String item : stringArray) {
				System.out.println(item);
				}
			break;
			}
		
		default:{
			System.out.println("Enter a valid number from 1-3");
			break;
		}
			
		}
		return val;
	}
	
}
