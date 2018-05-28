package com.sunnara.homework;

import java.util.ArrayList;

/*
 * Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. Add all the even numbers up and 
 * display the result. Add all the odd numbers up and display 
 * the result. Remove the prime numbers from the ArrayList
 * and print out the remaining ArrayList.
 */
public class Q19 {

	ArrayList<Integer> oneToTen;

	public Q19() {
		oneToTen = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			oneToTen.add(i);
		}
	}
	
	public void start() {
		System.out.println("Question 19:\nMade array list from 1-10");
		printList();
		sumOfEven();
		sumOfOdd();
		System.out.println("Removing Primes from ArrayList");
		removePrime();
		printList();
	}
	
	public void printList() {
		System.out.print("[ ");
		for(int i : oneToTen) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}

	/**
	 * Adds all the evens
	 */
	public void sumOfEven() {
		int sum = 0;
		System.out.print("Sum of Even: ");
		for(int i : oneToTen) {
			if(i%2==0) { //If value % 2 has no remainders, it's even
				System.out.print(i + " + ");
				sum+=i;
			}
		}
		System.out.print(" = " + sum);
		System.out.println();
	}

	/**
	 * Adds all odds
	 */
	public void sumOfOdd() {
		int sum = 0;
		System.out.print("Sum of Odd: ");
		for(int i : oneToTen) {
			if(i%2!=0) { //If value % 2 has remainders, it's odd
				System.out.print(i + " + ");
				sum+=i;
			}
		}
		System.out.println(" = " + sum);
	}

	/**
	 * removes all primes from arraylist
	 */
	public void removePrime() {
		boolean prime = true;
		ArrayList<Integer> temp = oneToTen;
	
		
		for(int i = 0; i < oneToTen.size(); i++) {
			if(oneToTen.get(i) == 1) {
				prime = false;
			}
			// Only needs to search through half for multiples
			for(int j = 2; j <= oneToTen.get(i)/2; j++) {
				if( oneToTen.get(i) % j == 0) { //value%j == 0 means not prime
					prime = false;
				}
				
				if(prime) {
					temp.remove(i);
					break;
				}
				prime = true;
			}
		}
		oneToTen = temp;
	}

}
