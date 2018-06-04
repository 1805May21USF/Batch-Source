package com.revature.utility;

public class Wrappers {
	static int myInt = 3;
	static Integer myInteger = 5;
	static Double myDouble = 04.34567;
	
	public static int addEmUp(int a, int b) {
		System.out.println(myDouble.getClass());
		System.out.println();
		return a+b;
		}
	
	public static void main(String[] args) {
		
		System.out.println(addEmUp(myInt,myInteger));
	}

}
