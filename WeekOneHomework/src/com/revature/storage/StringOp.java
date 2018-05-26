/****************************************************
 * 		Name: StringOp									*
 * 		Purpose: Inherits and overrides the abstract*
 * 				 methods of StringOperations		*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

public class StringOp extends StringOperations{

	// Tests if there are any uppercase characters in the provided String
	@Override
	public boolean anyUppercase(String s) {
		char[] chars = s.toCharArray();
		for(char c : chars) {
			if(Character.isUpperCase(c))
				return true;
		}
		return false;
	}

	// Converts all the Strings characters into uppercase
	@Override
	public String toUppercase(String s) {
		// Creates an array of characters and an array to hold all uppercase characters
		char[] chars = s.toCharArray();
		char[] upperChars = chars;
		
		for(int i = 0; i < chars.length; i++) {
			// Tests if a character is uppercase and turns it uppercase if it's not
			if(!Character.isUpperCase(chars[i]))
				upperChars[i] = Character.toUpperCase(chars[i]);
		}
		// Returns a new String made up of the uppercase characters
		return new String(upperChars);
	}

	// Converts the String into an integer, add ten, and then display the number
	@Override
	public void addTen(String s) throws NumberFormatException{
		int value = Integer.parseInt(s);
		value += 10;
		System.out.println(value);
	}
	
	
}
