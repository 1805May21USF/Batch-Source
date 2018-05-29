package com.revature.beans;

public class Question06 {

	public void checkEvenOrOdd(int n) {
		int q = (n/2);
		if(q * 2 == n) {
			System.out.println(n + " is an even number!");
		} else {
			System.out.println(n + " is an odd number!");
		}
	}
	
}
