package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//We good

public class Q12PrintEven {

	
	ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
	
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(System.out);
	}
	
	//I cannot for the life of me test output. I never get the formatting
	//completely correct. The output is correct but I cannot get the test to work.
	@Test
	public void tester() { 
		iterableEvens();
		assertEquals("2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 " +
		"52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98 100 ",outContent.toString());
	}
	
	//Doing that thing where i use previous made Methods. I almost feel like
	//there is a pattern y'all are trying to get me to adopt.
	Q06IsEven Q6 = new Q06IsEven();
	
	//This method is quite simple. If the number is even I print
	//it out. I used the enhanced for like requested. 
	public void iterableEvens() {
		
		int iterators[] = new int[100];
		
		for(int i = 0; i < 100; i++) {
			iterators[i]=i+1;
		}
		
		for(int i : iterators) {
			if(Q6.isIt(i)) System.out.print(i + " ");
		}
	}
	
	
	
	
	
}
