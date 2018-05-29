package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q06IsEven {
	
	
	//Gotta test 'em all. 31 is the perfect number to test it because it checks if
	//the logic of how integers work makes sense.
	@Test
	public void tester() {
		
		boolean a = false;
		boolean b;
		int num = 31;
		b = isIt(num);
		assertEquals(a,b);
		
	}
	
	
	//There are many ways this number could have been checked, but I like this way.
	//It uses the fact that odd integers divided by two always round down. Therefore,
	//If x is a round integer, and you divide x by 2 is is actually equal to 
	//(x-1)/2 instead of x/2. Using that I can re-multiply the number. If the number is equal
	//to what it reviously was the number is even. Otherwise it's odd.
	public boolean isIt(int i) {
		return (i == (i/2)*2);
	}

}
