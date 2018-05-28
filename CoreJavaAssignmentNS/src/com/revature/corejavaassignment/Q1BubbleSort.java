package com.revature.corejavaassignment;

/**
 * Sorts int arrays using the bubble sort method.
 * @author Nathaniel Simpson
 *
 */
public class Q1BubbleSort {

	// int array to be sorted
	private static int[] rollTideArray = {1,0,5,6,3,2,3,7,9,8,4};

	/*
	 * Method which performs the bubble sort.
	 * @param array - the array to be sorted.
	 */
	private static void bubbleSort(int[] array) {

		// Checker to determine if elements were swapped
		// in the array. If none were swapped during a
		// pass, then the array is finished sorting.
		boolean wasSwapped = true;
		
		while(wasSwapped) {
			
			// Sets wasSwapped to false initially.
			// If a swap occurs, it is set to true again.
			wasSwapped = false;
			
			// Compares each element in the array to the
			// following element. If the preceding element
			// is less than the following element, the
			// elements are swapped. Multiple passes are
			// likely necessary to completely sort the
			// array.
			for (int i = 0; i < array.length - 1; i++) {
				if(array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					wasSwapped = true;
				}
			}
			
		}

		// Sets the rollTideArray to the new sorted array.
		rollTideArray = array;

	}

	/*
	 * Prints the array
	 * @param array - the array to be printed.
	 */
	private static void printArray(int[] array) {
		System.out.print("\t[");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1] + "]");
	}

	/*
	 * Demonstrates the bubbleSort method by outputting
	 * the array before and after being sorted.
	 */
	public static void bubbleSortDemo() {

		System.out.println("Q1. BubbleSort");
		System.out.print("\tBefore bubbleSort: ");
		printArray(rollTideArray);
		bubbleSort(rollTideArray);
		System.out.print("\tAfter bubbleSort: ");
		printArray(rollTideArray);
		System.out.println(); //Making room for Q2

	}

	/*
	 * For testing purposes. All classes will be
	 * accessible from a demo class.
	 */
	public static void main(String[] args) {
		bubbleSortDemo();
	}

}
