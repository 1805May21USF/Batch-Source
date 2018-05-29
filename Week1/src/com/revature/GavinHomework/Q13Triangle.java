package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Q13Triangle {

/*	
	0
	10
	101
	0101
0101010101
*/
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
	
	//Another example of test outputs just not working for me.
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(System.out);
	}
	
	//Oddly enough, figuring out an algorithm to print out these 1's and 0's
	//was the hardest algorithm I made. My brain for the life of me did not
	//understand until an hour after I started that the 1's and 0's swap
	//between which are there.
	public void tri() {
		int j=0;
		int z = 0;
		for(int i = 0; i < 10; i++) {
		
			if(j==z) {
				j++;
				System.out.println();
				z=0;
			}
			System.out.print(i%2);
		
			z++;
		}
		
		System.out.println();
	}
	
	//I don't know how to test this.
	@Test
	public void tester() {
		tri();
		assertEquals("\n0" 
					+"10" 
					+"101"
					+"0101",outContent.toString());
	}
	
	
	
}
