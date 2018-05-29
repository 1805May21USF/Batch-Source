package com.revature.beans;

public class Question18 extends Question18Super {

	@Override
	public boolean checkUpperCase(String s) {
		int length = s.length();
		for(int i=0; i<length; i++) {
			char c = s.charAt(i);
			if(Character.isUpperCase(c)) {
				System.out.println("Upper case letter found!");
				return true;
			}
		}
		System.out.println("No upper case letters found!");
		return false;
	}

	@Override
	public String convertLowerCase(String s) {
		String upperString = s.toUpperCase();
		System.out.println(s + " converted to " + upperString);
		return upperString;
	}

	@Override
	public void convertToInteger(String s) {
		int number = Integer.parseInt(s);
		System.out.println(number + " + 10 = " + (number+10));
		
	}

}
