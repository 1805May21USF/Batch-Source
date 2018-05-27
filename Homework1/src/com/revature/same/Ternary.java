package com.revature.same;

public class Ternary {

	public Ternary() {
		// TODO Auto-generated constructor stub
	}

	public static int ternary(int firstNum, int secondNum) {
		int minimum = (firstNum < secondNum) ? firstNum : secondNum;
		return minimum;
	}
}
