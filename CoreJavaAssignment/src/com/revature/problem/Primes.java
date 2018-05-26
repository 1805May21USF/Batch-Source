package com.revature.problem;

import java.util.ArrayList;

public class Primes {
	public static ArrayList<Integer> primes(ArrayList<Integer> ints) {
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		
		for (int i : ints) {
			if (isPrime(i))
				primeNums.add(i);
		}
		
		return primeNums;
	}
	
	private static boolean isPrime(int num) {
	    for (int i = 2; 2 * i <= num; i++) {
	        if (num % i == 0)
	            return false;
	    }
	    
	    return true;
	}
	
	public static void print(ArrayList<Integer> ints) {
		System.out.print("Primes: ");
		for (int i : ints) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
