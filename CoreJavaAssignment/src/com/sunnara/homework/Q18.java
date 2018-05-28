package com.sunnara.homework;

/*
 * Write a program having a concrete ;subclass that inherits 
 * three abstract methods from a superclass.  Provide the 
 * following three implementations in the subclass corresponding 
 * to the abstract methods in the superclass:
 * 
 *  
 * 1. Check for uppercase characters in a string, and return ÅetrueÅf
 *    or ÅefalseÅf depending if any are found.
 *  
 * 2. Convert all of the lower case characters to uppercase in the 
 *    input string, and return the result.
 *    
 * 3. Convert the input string to integer and add 10, output the
 *     result to the console.
 *     
 * Create an appropriate class having a main method to test the above setup.
 */
public class Q18 extends Q18Abstract {

	public static void main(String[] args) {
		Q18 e = new Q18();
		System.out.println("Question 18:");
		System.out.println("checkUpper(\"aSa\") results:");
		System.out.println(e.checkUpper("aSa"));
		System.out.println("cmakeAllUpper(\"uppercase this\") results:");
		System.out.println(e.makeAllUpper("uppercase this"));
		System.out.println("stringToIntP10(\"25\") results:");
		System.out.println(e.stringToIntP10("25"));
		System.out.println();
	}

	/**
	 * checks uppercase
	 */
	@Override
	boolean checkUpper(String s) {
		// TODO Auto-generated method stub
		for(int i = 0; i < s.length(); i++) {
			if(s.toLowerCase().equals(s)) { //If there is 1 uppercase, this should be false
				return false;
			}
		}
		return true;
	}

	/**
	 * makes string uppercase
	 */
	@Override
	String makeAllUpper(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

	@Override
	int stringToIntP10(String s) {
		// TODO Auto-generated method stub
		boolean letters = true;
		int i = 0;
		while(letters) {
			try {
				Integer.parseInt(s);
				letters = false;
			} catch(NumberFormatException e) {
				System.out.print("String contains letter (Default will be represent 0)");
				return 0 + 10;
			}
		}
		return Integer.parseInt(s) + 10;
	}

}
