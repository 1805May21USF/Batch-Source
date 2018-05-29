package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q10Minimum {
	
	
	//Tested to see the minimum between 4 and 5.
	@Test
	public void tester() {
		int a = 5;
		int b = 4;
		int c = min(a,b);
		assertEquals(b,c);
	}
	
	//Didn't know these operators existed. Pretty cool honestly,
	//I like when complicated algorithms get put down to one
	//line.
	public int min(int a, int b) {
		return (a < b) ? a : b;
	}

}
