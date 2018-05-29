package com.revature.assignment0.questions;

import com.revature.assignment0.objects.DiceMan;

public class QuestionFour {

		public static void Question_Four() {
			
			//Gets a random factorial number and stores it in a variable
			
			byte factorial_number = DiceMan.getFactorial();
			long factorial_total = 1;
			
			/*
			 * Inserts the factorial number as the starting point then goes in reverse multiplying
			 * each number till it reaches one and outputs the total
			 */
			
			for(int i = factorial_number; i >= 1; i--) {
				factorial_total *= i;
			}
			
			System.out.println("\r------Question Four-------");
			System.out.println("4.)Write a program to compute N factorial.\r");
			System.out.println(factorial_total);
		}
}
