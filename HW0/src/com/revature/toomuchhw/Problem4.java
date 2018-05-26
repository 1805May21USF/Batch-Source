package com.revature.toomuchhw;

public class Problem4 {

	//Q4. Write a program to compute N factorial.
	public int factMe(int n) {
		
		int fact = 1;
		
		for(int i = n; i >= 1; i--)
		{
			fact = fact * i;
		}
		
		return fact;
	}
}

