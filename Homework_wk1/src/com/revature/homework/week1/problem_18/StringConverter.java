package com.revature.homework.week1.problem_18;

public class StringConverter implements StringSpecialist{
	//this class implements StringSpecialist interface
	
	@Override
		public boolean uppercaseChecker(String str) {
		//this boolean methods accepts a string
		//and returns true or false
		//if uppercase letter exists
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(Character.isUpperCase(c[i])) {
				return true;
			}
		}
		return false;
	}
	
	@Override
		public String convertToUpperCase(String str) {
		//this method converts all the letters in the string
		//to uppercase
			char[] c = str.toUpperCase().toCharArray();
			return new String(c);
	}
	
	@Override
		public String convertString(String str) {
		//this method adds integer to the string and
		//returns the result as string
			Integer i = Integer.parseInt(str);
			i = i + 10;
			return i.toString();
	}

}
