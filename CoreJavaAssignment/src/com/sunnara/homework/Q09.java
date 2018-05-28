package com.sunnara.homework;

import java.util.ArrayList;

/*
 * Create an ArrayList which stores numbers from 1 to 
 * 100 and prints out all the prime numbers to the console.
 * ==================================================================
 */
public class Q09 {
	ArrayList<Integer> numbers;

	
	
	public Q09() {
		numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}

	}

	public void start() {
		System.out.println("Question 9:");
		System.out.println("The prime numbers from 1-100 are");
		printPrimes(numbers);
		System.out.println("\n");
	}
	
	/**
	 * Prints the prime numbers from n Arraylist
	 * @param n
	 */
	public void printPrimes(ArrayList<Integer> n) {
		boolean prime = true;
		for(int j : n) {
			if(j == 1) { //1 isn't a prime
				prime = false;
			}
			for(int i = 2; i <= j/2; i++) {//goes through Half of value to to see multiple
				if(j % i == 0) {
					prime = false;
				}
			}
			if(prime) {
				System.out.print(j + " ");
			}
			prime = true;
		}
	}

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}


}
