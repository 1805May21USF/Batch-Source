package com.revature.GavinHomework;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;



//We good
public class Q09Primess {
	
	//This was a pain because I guessed from my personal knowledge all of the primes from 1 to 100
	//instead of looking them up.My Hubris lead to many failed tests. I had 91 as a prime, however it is
	//7*13. Pesky 7 and 13 messing it all up. Fortunately my pride is less than my skeptisism so I 
	//googled 1 to 100 and it worked out alright.
	@Test
	public void tester() {
	/*	int i = 100;
		ArrayList<Integer>  a = new ArrayList<Integer>(); 
		Integer[] arr = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97}; 
		
		a.addAll(Arrays.asList(arr));
		
		ArrayList<Integer> b = primeArray(i);
	
		assertArrayEquals(a.toArray(),b.toArray());*/
		assertEquals(false, isPrime(4));
	}

	//Here is my extremely inefficient prime search machine. It works and is
	//good enough to check numbers under 1000 to see if they are prime. That's 
	//all I need.
	public boolean isPrime(int n) {
		if(n==0||n==1) return false;
		
		for(int i = 1; i < n ; i++ ) {
			if(i == 1) continue;
			if(n%i ==0) return false;
		}
		return true;
	}
	
	
	//Pretty simple. If the number is prime I add it to the list. Then I return the list
	public ArrayList<Integer> primeArray(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();	
		
		for(int i= 0; i < n; i ++) {
			if(isPrime(i)) arr.add(i);
		}	
		return arr; 	
	}
	
	
	
	
	
}
