package com.revature.beans;

public class Question15 implements Calculator {
	
	public void addition(int a, int b) {
		System.out.println(a + " plus " + b + " is: " + (a+b));
	}
	
	public void subtraction(int a, int b) {
		System.out.println(a + " minus " + b + " is: " + (a-b));
	}
	
	public void multiplication(int a, int b) {
		System.out.println(a + " times " + b + " is: " + (a*b));
	}
	
	public void division(int a, int b) {
		System.out.println(a + " divided by " + b + " is: " + (a/b));
	}

}
