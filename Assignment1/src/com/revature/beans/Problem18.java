package com.revature.beans;

import java.util.regex.Pattern;

import com.revature.abstractclasses.Problem18Abstract;

public class Problem18 extends Problem18Abstract{

	@Override
	public boolean checkForUpperCaseLetters(String s) {	
		boolean b = false;
		for(int i = 0; i < s.length(); i++){
			if (Character.isUpperCase(s.charAt(i))){
				return true;
			}
		}

		return b;
	}

	@Override
	public String stringToUpperCase(String s) {
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < s.length();i++){
			if(Character.isLowerCase(sb.charAt(i))){
				sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
			}
		}
		return sb.toString();
	}

	@Override
	public Integer add10ToNumberReturnString(String s) {
		Integer returnValue = 0;
		try {
			return returnValue = Integer.parseInt(s) + 10;
			
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
		return null;
	}
	
}
