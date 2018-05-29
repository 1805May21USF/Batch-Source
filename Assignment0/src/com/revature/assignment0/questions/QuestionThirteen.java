package com.revature.assignment0.questions;

import com.revature.assignment0.objects.DiceMan;

public class QuestionThirteen {
	public static void Question_Thirteen() {
		
		//Gathers the row number by a random byte
		byte row = DiceMan.getQuestionThirteenRow();
		
		System.out.println("\r------Question Thirteen-------");
		System.out.println("13.) Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.\r");
		
		//The first for loop is the row
		for(int i=1;i<=row;i++){
			//Second for loop is the column
		     for(int j=1;j<=i;j++) {
		    	 //For each column, print out a smiley face
		         System.out.print(":)");
		     }
		     System.out.println();
		}
	}
}
