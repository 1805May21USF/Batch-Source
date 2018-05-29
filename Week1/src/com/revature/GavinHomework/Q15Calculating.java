package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q15Calculating implements Q15Calculator {

	
	//I implemented a calculator. Still not as cool as my yacc
	//calculator I made. I hope I don't bore you with my late night 
	//asides that I am putting here.
	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiply(int a, int b) {
		return a*b;
	}

	@Override
	public int divide(int a, int b) {	
		return a/b;
	}
	
	@Test
	public void tester() {
		int a = 5;
		int b = 10;
		
		assertEquals(divide(b,a), 2);
		assertEquals(subtraction(b,a),5);
	}

}
