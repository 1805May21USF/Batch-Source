package com.revature.assignment0.questions;

import com.revature.assignment0.abstracts.QuestionEighteenAbstract;

public class QuestionEighteen extends QuestionEighteenAbstract{
	public void Question_Eighteen() {
		Integer integer = (int)(Math.floor(Math.random() * 100) + 1);
		boolean uppercase = checkForUppercase("Jerry");
		String lowercase = convertToLowerCase("Sarah");
		int integer_add = convertAndAddTen(integer.toString());
		
		System.out.println("\r------Question Eighteen-------\r");

		System.out.println("1) Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.\r" +
				"Is there a capital in the string?\r");
		
		System.out.println(uppercase);
		
		System.out.println("\r2) Convert all of the lower case characters to uppercase in the input string, and return the result.\r");
		
		System.out.println("--------");
		System.out.println("Original");
		System.out.println("---------\r");
		
		System.out.println("Sarah");
		
		System.out.println("---------");
		System.out.println("LowerCase");
		System.out.println("---------\r");
		
		System.out.println(lowercase);
		
		System.out.println("\r3) Convert the input string to integer and add 10, output the result to the console.\r");
		
		System.out.println("--------");
		System.out.println("Original");
		System.out.println("---------\r");
		
		System.out.println("\"" + integer + "\"");
		
		System.out.println("-------------------------");
		System.out.println("Convert To Int and add 10");
		System.out.println("-------------------------\r");
		
		System.out.println(integer_add);
		System.out.println();
	}
	
	//Checks for an Uppercase letter
	public boolean checkForUppercase(String name){
		boolean output = false;
		/*
		 * Makes a string a char array and then goes through each letter checking if it is an uppercase
		 * If it has gone through all of them, then it is false
		 */
		char[] char_array = name.toCharArray();
		for(char character : char_array) {
			output = (Character.isUpperCase(character)) ? true : false;
			if (output)
				break;
		}
		return output;
	};
	
	//Converts to all letters to lowercase
	public String convertToLowerCase(String name) {
		/*
		 * Takes the string and uses toLowerCase() method to lower letters
		 */
		return name.toLowerCase();
	}
	
	//Converts the number string and adds 10
	public int convertAndAddTen(String number) {
		return Integer.parseInt(number) + 10;
	}
}
