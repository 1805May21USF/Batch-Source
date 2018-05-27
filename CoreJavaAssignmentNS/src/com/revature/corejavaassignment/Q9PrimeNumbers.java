package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q9PrimeNumbers {
	
	private static ArrayList<Integer> numberList = new ArrayList<>(); 
	
	private static void populateNumberList() {
		for (int i = 1; i <= 100; i++) {
			numberList.add(i);
		}
	}
	
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
	
	private static ArrayList<Integer> primeList(ArrayList<Integer> numList) {
		ArrayList<Integer> primeList = new ArrayList<>();
		
		for (int i : numList) {
			if (isPrime(i))
				primeList.add(i);
		}
		
		return primeList;
	}
	
	public static void primeNumberDemo() {
		System.out.println("Q9. PrimeNumbers");
		populateNumberList();
		System.out.println("\t1-100: " + primeList(numberList).toString());
		System.out.println(); //Making room for Q10
	}
	
	public static void main(String[] args) {
		primeNumberDemo();
	}
	
	/*
	 * Getter method for Q19
	 */
	public static boolean getIsPrime(int input) {
		return isPrime(input);
	}

}
