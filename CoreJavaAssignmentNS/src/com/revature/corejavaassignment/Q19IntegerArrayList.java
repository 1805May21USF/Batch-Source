package com.revature.corejavaassignment;

import java.util.ArrayList;

/**
 * Integer ArrayList demo class that has methods for finding
 * the sum of the even numbers, finding the sum of the odd
 * numbers, and returning a new ArrayList of all prime
 * numbers in the initial ArrayList.
 * @author Nathaniel Simpson
 *
 */
public class Q19IntegerArrayList {

	// Initial ArrayList
	private static ArrayList<Integer> intArrayList = new ArrayList<>();

	/*
	 * Populates the initial ArrayList
	 * @param min - first number
	 * @param max - last number
	 */
	private static void populateArrayList(int min, int max) {
		if(min < max) {
			for(int i = min; i <= max; i++) {
				intArrayList.add(i);
			}
		}
	}
	
	/*
	 * Finds the sum of all even numbers in an ArrayList.
	 * @param list - initial ArrayList
	 * @return sum of all even numbers
	 */
	private static int sumOfEvens(ArrayList<Integer> list) {
		int sum = 0;
		for (int i : list) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	/*
	 * Finds the sum of all odd numbers in an ArrayList.
	 * @param list - initial ArrayList
	 * @return sum of all odd numbers
	 */
	private static int sumOfOdds(ArrayList<Integer> list) {
		int sum = 0;
		for (int i : list) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	/*
	 * Creates a new ArrayList with all prime numbers omitted from
	 * the parameter ArrayList.
	 * @param list - initial ArrayList
	 * @return ArrayList with prime numbers omitted
	 */
	private static ArrayList<Integer> noPrimesList(ArrayList<Integer> list) {
		ArrayList<Integer> noPrimesArrayList = new ArrayList<>();
		for (int i : list) {
			if (!Q9PrimeNumbers.getIsPrime(i)) {
				noPrimesArrayList.add(i);
			}
		}
		return noPrimesArrayList;
	}
	
	/*
	 * Demonstrates the ArrayList methods in the class
	 */
	public static void integerArrayListDemo(int min, int max) {
		System.out.println("Q19. IntegerArrayList");
		populateArrayList(min, max);
		System.out.println("\tInitial list: " + intArrayList.toString());
		System.out.println("\tSum of evens in list: " + sumOfEvens(intArrayList));
		System.out.println("\tSum of odds in list: " + sumOfOdds(intArrayList));
		System.out.println("\tNo primes list: " + noPrimesList(intArrayList));
		System.out.println();
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		integerArrayListDemo(1, 10);
	}

}
