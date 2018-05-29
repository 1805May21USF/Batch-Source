package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Q17Interest {
	
	Scanner input = new Scanner(System.in);
	
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
	


	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(System.out);
	}
	
	
	//Input and output tests just don't work for me. I guess I need a little work
	//On that front.
	@Test
	public void tester() {
		
		double testPrinciple = 100.0;
		double testRate = .1;
		double testTime = 10;
		interest( testPrinciple,  testRate, testTime);
		
		assertEquals(100.0,outContent.toString());
		
	}
	
	//Pretty simple. Input the three doubles and then the simple interest rate is found.
	public void findInterest() {
		double Principle = input.nextDouble();
		double Rate = input.nextDouble();
		double Time = input.nextDouble();
		interest(Principle,Rate,Time);
	}
	
	
	public void interest(double p, double r, double t) {
		System.out.println(r*t*p); 
	}

}
