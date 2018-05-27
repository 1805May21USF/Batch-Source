package com.revature.corejavaassignment;

public class Q12EnhancedForLoop {

	//Used to determine if the last element has been reached
	//to avoid adding an unnecessary comma 
	private static int counter = 0;
	
	private static int[] numbers = new int[100];
	
	private static void populateIntArray() {
		for (int i = 1; i <= 100; i++) {
			numbers[i-1] = i;
		}
	}
	
	private static void printEvens() {
		System.out.print("\t[");
		for (int i : numbers) {
			if (i % 2 == 0) {
				if ((counter += 2) != (numbers.length))
					System.out.print(i + ", ");
				else
					System.out.print(i);
			}
		}
		System.out.println("]");
	}
	
	private static void printArray() {
		System.out.print("\t[");
		for (int i = 0; i < numbers.length - 1; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println(numbers[numbers.length - 1] + "]");
	}
	
	public static void enhancedForLoopDemo() {
		populateIntArray();
		System.out.println("Q12. EnhancedForLoop");
		System.out.print("\tInitial array: ");
		printArray();
		System.out.print("\tEvens array: ");
		printEvens();
		System.out.println(); //Making room for Q13
	}
	
	public static void main(String[] args) {
		populateIntArray();
		printEvens();
	}
	
}
