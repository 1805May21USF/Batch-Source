package com.revature.utility;

public class Wrapperz {
	static int myInt = 3;
	static Integer myInteger = 5;
	static Double myDouble = 4.39234;
	static Boolean myBool = true;
	public static int addEmUp(int a, int b) {
		System.out.println(myBool.toString(true));
		System.out.println(myDouble.intValue());
		return a + b;
	}
	
	public static void main(String[] args) {
		System.out.println(addEmUp(myInt,myInteger));
	}
}
