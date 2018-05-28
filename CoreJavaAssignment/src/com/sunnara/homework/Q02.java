package com.sunnara.homework;
/*
 *  Write a program to display the first 25 
 *  Fibonacci numbers beginning at 0.
 */
public class Q02 {
	
	public void start() {
		System.out.println("Question 2:");
		System.out.println("Displaying first 25 Fibonacci numbers");
		int[] fib = createFib(25); //25 numbers with Fibonacci
		printFib(fib);
		System.out.println("\n");
		
	}

	/**
	 * 
	 * @param amount - size of array
	 * @return = returns array filled with fibonacci sequence.
	 */
	public int[] createFib(int amount) {
		int i[] = new int[amount];
		
		switch (amount) {
		case 0:
			break;
		case 2:
			i[1] = 1; //First number always 1
		case 1:
			i[0] = 0; //First number always 0
			break;
		default:
			i[0] = 0;
			i[1] = 1;
			for(int j=2; j < amount; j++) {
				i[j]= i[j-1] + i[j-2]; //Adds the previous 2 numbers to get new value
			}
		}
		return i;
	}
	/**
	 * prints fibonnaci numbers
	 * @param i - array being printed
	 */
	public void printFib(int[] i) {
		
		for(int v : i) {
			System.out.print(v + " ");
		}
	}
}
