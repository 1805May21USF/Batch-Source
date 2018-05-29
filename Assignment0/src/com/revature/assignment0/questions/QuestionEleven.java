package com.revature.assignment0.questions;

import com.revature.assignment0.objects.DiceMan;

public class QuestionEleven {

		public static void Question_Eleven() {
			
			/*
			 * Goes to another package and gathers the proper dice data and stores it in to float
			 * variables and then simply prints it out
			 */
			float dice_a = DiceMan.getQuestionElevenFloatA();
			float dice_b = DiceMan.getQuestionElevenFloatB();
			
			System.out.println("\r------Question Eleven-------");
			System.out.println("11.) Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.\r");
			
			System.out.println("1st Float: " + dice_a + " 2nd Float: " + dice_b);
		}
}
