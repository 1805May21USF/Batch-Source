package com.revature.testing;
import com.revature.solutions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class junit {

	@Test
	void testBubble() {
		int expected[] = {0,1,2,3,3,4,5,6,7,8,9};
		int actual[] = {1,0,5,6,3,2,3,7,9,8,4};
		Bubble.bubble(actual);
		assertArrayEquals(expected,actual);
		//fail("Not yet implemented");
	}
	@Test
	void testFib() {
		String fib = "1. 0\n" + 
				"2. 1\n" + 
				"3. 1\n" + 
				"4. 2\n" + 
				"5. 3\n" + 
				"6. 5\n" + 
				"7. 8\n" + 
				"8. 13\n" + 
				"9. 21\n" + 
				"10. 34\n" + 
				"11. 55\n" + 
				"12. 89\n" + 
				"13. 144\n" + 
				"14. 233\n" + 
				"15. 377\n" + 
				"16. 610\n" + 
				"17. 987\n" + 
				"18. 1597\n" + 
				"19. 2584\n" + 
				"20. 4181\n" + 
				"21. 6765\n" + 
				"22. 10946\n" + 
				"23. 17711\n" + 
				"24. 28657\n" + 
				"25. 46368";
		String x = "";
		x = Fib.fib(x);
		assertEquals(fib,x);
	}
	@Test
	void testReverse() {
		String actual ="I am a string";
		String expected = "gnirts a ma I";
		actual = reverseString.reverse(actual);
		assertEquals(expected,actual);
	}
	@Test
	void testFactorial() {
		int actual =5;
		int expected = 120;
		actual = NFactorial.factorial(actual);
		assertEquals(expected,actual);
		
	}
	@Test
	void substrin() {
		
	}
	@Test
	void testEvenInt() {
		boolean expected1 = true;
		boolean expected2 = false;
		int x1 = 10;
		int x2 = 11;
		boolean actual1 = EvenInteger.evenInt(x1);
		boolean actual2 = EvenInteger.evenInt(x2);
		assertEquals(expected1,actual1);
		assertEquals(expected2,actual2);
	}
	
	@Test
	void testTernary() {
		int expected = 7;
		int max = 100;
		int actual = Ternary.ternary(expected, max);
		assertEquals(expected,actual);
	}
	@Test
	void testEvenPrint() {
		EvenPrint.evenPrint();
	}

}
