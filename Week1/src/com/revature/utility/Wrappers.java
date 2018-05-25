package com.revature.utility;

public class Wrappers {
	static int myInt=3;
	static Integer myInteger = 5;
	static Double myDouble = 5.42313;
	static Boolean myBool = true;
	
	public static int addEmUp(int a, int b) {
		System.out.println(myDouble.getClass());
		System.out.println(myBool.toString());
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println(addEmUp(myInteger, myInteger));
	}
}
