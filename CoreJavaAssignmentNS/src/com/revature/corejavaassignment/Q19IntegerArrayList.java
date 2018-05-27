package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q19IntegerArrayList {

	private static ArrayList<Integer> intArrayList = new ArrayList<>();

	private static void populateArrayList(int min, int max) {
		if(min < max) {
			for(int i = min; i <= max; i++) {
				intArrayList.add(i);
			}
		}
	}
	
	private static int sumOfEvens(ArrayList<Integer> list) {
		int sum = 0;
		for (int i : list) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	private static int sumOfOdds(ArrayList<Integer> list) {
		int sum = 0;
		for (int i : list) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	private static ArrayList<Integer> noPrimesList(ArrayList<Integer> list) {
		ArrayList<Integer> noPrimesArrayList = new ArrayList<>();
		for (int i : list) {
			if (!Q9PrimeNumbers.getIsPrime(i)) {
				noPrimesArrayList.add(i);
			}
		}
		return noPrimesArrayList;
	}
	
	public static void integerArrayListDemo(int min, int max) {
		System.out.println("Q19. IntegerArrayList");
		populateArrayList(min, max);
		System.out.println("\tInitial list: " + intArrayList.toString());
		System.out.println("\tSum of evens in list: " + sumOfEvens(intArrayList));
		System.out.println("\tSum of odds in list: " + sumOfOdds(intArrayList));
		System.out.println("\tNo primes list: " + noPrimesList(intArrayList));
		System.out.println();
	}
	
	public static void main(String[] args) {
		integerArrayListDemo(1, 10);
	}

}
