package com.revature.utility;

public class Wrapperz {

	static int myInt = 3;
	static Integer myInteger = 5;
	static Double myDouble = 4.34567;
	
	public static int add(int a, int b) {
		System.out.println(myDouble.hashCode());
		System.out.println(myInteger.toHexString(myInt));
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println(add(myInt, myInteger));
	}
}
