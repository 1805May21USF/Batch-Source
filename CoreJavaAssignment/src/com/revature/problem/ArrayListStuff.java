package com.revature.problem;

import java.util.ArrayList;

public class ArrayListStuff {
	public static void arrayListStuff(ArrayList<Integer> ints) {
		StringBuilder bd = new StringBuilder();
		//Original
		for (int i : ints) {
			bd.append(i + " ");
		}
		System.out.println("Original: " + bd.toString());
		
		//Even Sum
		int sum = 0;
		for (int i : ints) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("Even Sum: " + sum);
		
		//Odd Sum
		sum = 0;
		for (int i : ints) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println("Odd Sum: " + sum);
		
		//Remove Primes
		bd = new StringBuilder();
		ArrayList<Integer> primes = Primes.primes(ints);
		for (int i : ints) {
			if (!primes.contains(i))
				bd.append(i);
		}
		System.out.println("Without Primes: " + bd.toString());
	}
}
