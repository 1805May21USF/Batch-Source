package com.revature.utility;

public class Wrapper {
	static int myInt = 3;
	static Integer myInteger = 5;
	static Long l = (long) 0.232;
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		int i = add(myInt, myInteger);
		System.out.println(i);
	}
	
}
