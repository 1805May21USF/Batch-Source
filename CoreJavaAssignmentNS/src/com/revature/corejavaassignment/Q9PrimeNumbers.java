package com.revature.corejavaassignment;

import java.util.ArrayList;

/**
 * Find all prime numbers between two values. This is set to 1 - 100
 * for the assignment.
 * @author Nathaniel Simpson
 *
 */
public class Q9PrimeNumbers {
	
	private static int min = 1;
	private static int max = 100;
	private static ArrayList<Integer> numberList = new ArrayList<>(); 
	
	/*
	 * Populates the ArrayList with a range of numbers.
	 * @param min - starting number.
	 * @param max - ending number.
	 */
	private static void populateNumberList(int min, int max) {
		for (int i = min; i <= max; i++) {
			numberList.add(i);
		}
	}
	
	/*
	 * Determines whether or not a number is prime.
	 * @param - number to be checked.
	 * @return true if prime, false otherwise.
	 */
	private static boolean isPrime(int number) {
		if (number < 2)
			return false;
		else if (number == 2)
			return true;
		else if (number % 2 == 0)
			return false;
		else {
			for (int i = 3; i < number; i += 2) {
				if (number % i == 0)
					return false;
			}
		}
		return true;
	}
	
	/*
	 * Compiles all primes from the parameter ArrayList into a new ArrayList.
	 * @param numList - ArrayList to be checked for prime numbers.
	 * @return a new ArrayList with the found prime numbers.
	 */
	private static ArrayList<Integer> primeList(ArrayList<Integer> numList) {
		ArrayList<Integer> primeList = new ArrayList<>();
		
		for (int i : numList) {
			if (isPrime(i))
				primeList.add(i);
		}
		
		return primeList;
	}
	
	/*
	 * Demonstrates finding prime numbers.
	 */
	public static void primeNumberDemo() {
		System.out.println("Q9. PrimeNumbers");
		populateNumberList(min, max);
		System.out.println("\t1-100: " + primeList(numberList).toString());
		System.out.println(); //Making room for Q10
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		primeNumberDemo();
	}
	
	/*
	 * Getter method used in Q19
	 */
	public static boolean getIsPrime(int input) {
		return isPrime(input);
	}

}
