package com.revature.assignments;

public class Q18 extends abstract18{

	@Override
	public boolean checkUppercase(String str) {
		// TODO Auto-generated method stub
		boolean hasUpper = !str.equals(str.toLowerCase());
		
		return hasUpper;
	}

	@Override
	public String toUpper(String str) {
		// TODO Auto-generated method stub
		str = str.toUpperCase();
		return str;
	}

	@Override
	public void stringToInt(String str) {
		// TODO Auto-generated method stub
		int myInt = Integer.parseInt(str);
		myInt = myInt + 10;
		System.out.println(myInt);
	
	}
	
	

}
