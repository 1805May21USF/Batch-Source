package com.revature.corejavaassignment;

import javax.xml.stream.events.Characters;

public abstract class Q18AbstractClass {
	
	public static boolean hasUpperCase(String str) {
		
		char[] characters = str.toCharArray();
		
		for(char c : characters) {
			if (Character.isUpperCase(c))
				return true;
		}
		return false;
	}
	
	public static String toUpperCase(String str) {
		
		char[] characters = str.toCharArray();
		
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLowerCase(str.charAt(i)))
				characters[i] = Character.toUpperCase(str.charAt(i));
		}
		
		return new String(characters);
		
	}
	
	public static int stringToIntPlus10(String str) {
		return Integer.parseInt(str) + 10;
	}

}
