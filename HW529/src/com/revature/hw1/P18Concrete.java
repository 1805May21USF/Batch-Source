package com.revature.hw1;

//import java.util.Scanner;

public class P18Concrete extends P18Abstract {

	@Override
	public boolean uppercasePresence(String a) {
		// TODO Auto-generated method stub
		for (char ch : a.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String lowercaseConvert(String a) {
		// TODO Auto-generated method stub
		return a.toUpperCase();
	}

	@Override
	public int ordPlusTen(String a) {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		//if (a.matches(".*[a-z].*")) {
			//System.ou
		//}
		//System.out.println(Integer.valueOf(a)+ 10);
		return Integer.valueOf(a)+10;
	}

}
