package com.revature.first;

public class Question10 {
	
	public void ternaryOp(int a, int b) 
	{
		int c;
		c = (a < b) ? a : b;
		System.out.println("Using ternary operator to find the minimum of two integers.");
		System.out.println("("+a+" < "+b+" )"+" ? "+c);
	}

}
