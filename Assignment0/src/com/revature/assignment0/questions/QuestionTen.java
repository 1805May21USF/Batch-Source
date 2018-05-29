package com.revature.assignment0.questions;

import com.revature.assignment0.objects.DiceMan;

public class QuestionTen {
	public static void Question_Ten() {
		
		//Generates two random dice numbers and inserts them in to variables
		int dice_a = DiceMan.getQuestionTenDice().get(0);
		int dice_b =  DiceMan.getQuestionTenDice().get(1);
		
		/*
		 * Use the compare operator to check to see dice_a is larger/even/smaller.
		 * If the number is even it will produce a 0.
		 * If the number is larger it will produce a 1.
		 * If the number is smaller it will produce a -1.
		 * I used the ternary operator with the else if statement to use the compare method
		 */
		String output = (Integer.compare(dice_a, dice_b) == 0) ?  "They are equal!" : (Integer.compare(dice_a, dice_b) == -1) ?  dice_a + " is the smallest" :  dice_b + " is the smallest"; 
		
		System.out.println("\r------Question Ten-------");
		System.out.println("10.) Find the minimum of two numbers using ternary operators.\r");
		System.out.println(output + " out of the two numbers, \"Dice_A: " + dice_a + "\" and \"Dice_B: " + dice_b + "\"");
	}
}
