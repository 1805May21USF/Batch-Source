package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class Q02Fibonacci {
	
	
	//We good
	
	
	
	//This is the fibonacci sequence. Every fifth element is divisible by 5. 
	//I used recursion because I am more comftorable with recursion. I could make this
	//method more efficient with a 1 dimensional array, but for any number under 150 
	//this method works just fine.
	public int fib(int i) {
		if(i == 0) {
			return 0;
		}
		if(i == 1) {
			return 1;
		}
		
		return(fib(i-2)+fib(i-1));
	}
	
	
	//I googled the25th number in the fibonacci sequence and set that equal
	//to my equation finding the fifth fibonanci number.
	@Test
	public void tester() {
		assertEquals(75,025, fib(25));
	}
	
	

}
