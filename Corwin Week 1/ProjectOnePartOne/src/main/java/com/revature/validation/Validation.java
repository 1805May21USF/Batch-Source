package com.revature.validation;

import java.util.regex.Pattern;

public class Validation {
	public static boolean isNotNullOrEmpty(String s) {
		try {
			if (s!=""||s!=null){
				return true;
			}else {
				System.out.println("The string was empty!");
				return false;
			}
		}catch(NullPointerException e) {
			System.out.println("The string was null!");
			return false;
		}
	}
	public static boolean isOnlyLetters(String s) {
		String regex = "[a-zA-Z]+";
		if(s.matches(regex)) {
			return true;
		}else {
		System.out.println("The string not only letters!");
		return false;
		}
	}
	
	public static boolean isOnlyNumbers(String s) {
		String regex = "[0-9]+";
		if(s.matches(regex)) {
			return true;
		}else {
		System.out.println("The string was not only numbers!");
		return false;
		}
	}
	
	public static boolean isDollar(String s) {
		String regex = "^\\$(([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))(\\.\\d\\d)?$";
		if(s.matches(regex)) {
			return true;
		}
		System.out.println("The string was not a valid dollar amount!");
		return false;
	}
	
	public static boolean noSpecialCharacters(String s) {
		String regex = "^[a-zA-Z0-9]+$";
		if(s.matches(regex)) {
			return true;
		}else {
		System.out.println("The string has special characters!");
		return false;
		}
	}
	
	public static boolean validateUsername(String s) {
		if(isNotNullOrEmpty(s)) {
			if(noSpecialCharacters(s)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean validatePassword(String s) {
		if(isNotNullOrEmpty(s)) {
			if(noSpecialCharacters(s)) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public static boolean validateName(String s) {
		if(isNotNullOrEmpty(s)) {
			if(noSpecialCharacters(s)) {
				if(isOnlyLetters(s)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean validateDollar(String s) {
		if(isNotNullOrEmpty(s)) {
			if(isDollar(s)) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}
