package com.revature.assignment0.questions;

import com.revature.assignment0.objects.DiceMan;

public class QuestionSix {

		public static void Question_Six() {

			System.out.println("\r------Question Six-------");
			System.out.println("6.) Write a program to determine if an integer is even without using the modulus operator (%).\r");
			
			//Create a random number and store it as a variable
			byte compareable_number = DiceMan.getQuestionSixInteger();

			//Use remainderunsigned to see if a number is even or not. It will return 0 if even, and 1 if odd
			String output = (Integer.remainderUnsigned(compareable_number, 2) == 0) ? compareable_number + " is even!" : compareable_number + " is odd!";
			System.out.println(output);
		}
}
