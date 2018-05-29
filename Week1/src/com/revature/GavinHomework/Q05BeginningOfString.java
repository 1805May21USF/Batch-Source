package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


//We good
public class Q05BeginningOfString {
	
	
	//Simple test. I'm starting to think I'm not supposed to comment on top of EVERY
	//test function I do or even keep them in there. Please let me know on your response
	//to this assignment. If you read this atleast ;)
	@Test 
	public void tester(){
		String a = "Do";
		String b = "Door";
		b = beg(b,2);
		assertEquals(a, b);

		
		
	}

	
	//Another recursive function. This one has similar logic to the reverse function.
	//The function inputs a string, and the word up to however many beginning letters of
	//the word the coder is looking for. It adds the letters recursively with i going down
	//one more for every letter no longer needed.
	String beg(String str, int i) {
		
		if(i==1) {return Character.toString(str.charAt(i-1));}
		
		return beg(str, i -1)+ Character.toString(str.charAt(i-1));
	}
	
	
}
