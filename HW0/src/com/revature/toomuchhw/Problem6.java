package com.revature.toomuchhw;

//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
public class Problem6 {
	
	public boolean isEven(int n) {
		//Bitwise to check if first bit is 1 or not
		if((n & 1) == 1) {
			return false;
		}
		else
		{
			return true;
		}
	}

}
