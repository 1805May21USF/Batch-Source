package com.revature.assignment0.questions;

public class QuestionFive {

	public void Question_Five() {
		
		System.out.println("------Question Five-------");
		System.out.println("5.) Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.\r");
		
		/*
		 * Create a stringbuilder with a simple word "Snow", them generate a random sub int
		 * from 0 to length -1 and send it to substring_class();
		 */
		StringBuilder name = new StringBuilder("Snow");
		int substring_integer = (int)(Math.floor(Math.random() * name.length()));
		SubString_Class(name, substring_integer);
		
	}
	
	/*
	 * Create a counter from the substring and start removing characters at index 0 till 
	 * substring is less than one
	 */
	public void SubString_Class(StringBuilder name, int substring) {
		int counter = substring;
		while (counter > 0) {
			name.deleteCharAt(0);
			counter--;
		}

		System.out.println("Original name: Snow\r"
				+ "Substring Number: " + substring + "\r" 
				+ "Substring Name: " +  name);
	}
}
