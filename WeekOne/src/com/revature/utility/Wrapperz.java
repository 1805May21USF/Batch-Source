package com.revature.utility;

public class Wrapperz {
	 static int myInt=3;
	 static Integer myInteger= 5;
	 static Double myDouble= 4.34567;
	 static Boolean myBool = true;
	
	public static int addEmUp(int a, int b) {
		System.out.println(myDouble.intValue());
		System.out.println(myBool.hashCode(true));
		return a+b;
	}
	public static void main(String[] args) {
		addEmUp(myInt,myInteger);
	}
}
