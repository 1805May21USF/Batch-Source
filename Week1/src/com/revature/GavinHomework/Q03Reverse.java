package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

//We good
public class Q03Reverse {
	
	
	//A simple test using one of my favorite words.
	@Test
	public void tester() {
		
		String a = "emeM";
		String b = "Meme";
		b = reverse(b);
		assertEquals(a, b);
	}
	
	
	//This method set up the recursion reverse algorithm. I did this so anyone could
	//simply use the .reverse(str) method.
	public String reverse(String str) {
		return rev(str,str.length()-1);
	}
	
	//I was not allowed to use a temp variable, but temp variables are crutches anyway.
	//Since I'm hardcore I used recursion. 
	//In all honesty, the way the method works is it returns the last letter first,
	//then adds on the second to last letter second and so on recursively till the whole word is reversed.
	private String rev(String str, int nice) {
		
		if(nice == 0) return Character.toString(str.charAt(0) ) ;
		
		return  Character.toString(str.charAt(nice)) + rev(str, nice-1)  ;
	}
}