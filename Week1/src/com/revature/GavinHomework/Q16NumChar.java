package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q16NumChar {
	
	
	//I passed this test like I'm gunna pass the test this 
	//upcoming Tuesday.
	@Test
	public void tester() {
		String str = "This is a testing method";
		assertEquals(20,howMany(str));
		
	}
	

	//This algorithm goes through every letter and adds one to the counter if the letter
	//is a character.
	public static int howMany(String str) {
		Character temp;
		int charCount = 0;
		
		for( int i = 0; i < str.length( ); i++ )
		{
		    temp = str.charAt( i );
		    if( Character.isLetter(temp) )
		        charCount++;
		}	
		return charCount;
	}

	//Ideally I take out this class. If I didn't it's because I got too tired to code.
	public static void main(String[] args) {
		
		System.out.println("There are " + howMany(args[0]) + " characters from the command line");
	}
	
}
