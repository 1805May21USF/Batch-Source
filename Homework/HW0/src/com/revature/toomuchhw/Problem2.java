package com.revature.toomuchhw;

//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
public class Problem2 {
	//Attributes - 25 sized int array
	static int[] a = new int[25];
	
	public int[] fibMe() {
		int len = a.length;
		a[0] = 0;
		a[1] = 1;
		
		//take 2 numbers add them, next 2 numbers add them, etc
		for(int i = 2; i<len; i++) {
			a[i] = a[i-1]+a[i-2];
		}
		return a;
	}
}
