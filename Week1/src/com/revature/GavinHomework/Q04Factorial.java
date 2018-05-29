package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//We good
public class Q04Factorial {

	
	//The test is simple. I figured out 7! and I set
	//5040 equals to 7 in my factorial function.
	@Test
	public void tester() {
		
		int a = 5040;
		int b = 7;
		b = fac(b);
		assertEquals(a, b);
	}
	
	
	
	//This works recursively. It asks for the given number to me multiplied by the number
	//one below it with a basis of fac(1) = 1.
	
	public int fac(int n) {
		if(n == 1) return 1;
		return n * fac(n-1);
	}
	
}
