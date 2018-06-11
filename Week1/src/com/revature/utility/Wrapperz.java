package com.revature.utility;

public class Wrapperz {
	static int myInt=3;
	static Integer myInteger= 5;
	static Double myDouble= 4.34567;
	static Boolean myBool= true;
	
	@SuppressWarnings("static-access")
	public static int addEmUp(int a, int b) {
		System.out.println(myDouble.getClass());
		System.out.println(myBool.toString(true));
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println(addEmUp(myInteger,myInteger));
	}
}