package com.sunnara.homework;

/*
 * Write a program to store numbers from 1 to 100 in an array. 
 * Print out all the even numbers from the array. Use the enhanced 
 * FOR loop for printing out the numbers.
 */
public class Q12 {

	int[] storedInts;

	public Q12() {
		storedInts = new int[100];
		storeArray();
	}
	
	public void start() {
		System.out.println("Question 12:");
		System.out.println("From 1-100\nThe even nnumbers are:");
		printEven();
		System.out.println("\n");
	}


	public int[] getStoredInts() {
		return storedInts;
	}

	public void setStoredInts(int[] storedInts) {
		this.storedInts = storedInts;
	}

	public void storeArray() {
		for(int i = 0; i < storedInts.length; i++) {
			storedInts[i] = i+1;
		}
	}

	/**
	 * print the evens in the arraylist
	 */
	public void printEven() {
		for(int num : storedInts) { //for eacn int in the arrayList
			if(num%2 == 0) {
				System.out.print(num + " ");
			}
		}
	}

}


