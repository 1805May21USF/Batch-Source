/****************************************************
 * 		Name: Q01									*
 * 		Purpose: Bubble sorts an array of integers  *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import java.util.Arrays;

public class Q01 {
	// Declares and instantiates an integer array
	private static int[] array = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	
	// Bubble sorts the array
	public static void bubbleSort() {
		// Creates a clone of the array to reduce duplicate output
		int[] array2 = array.clone();
		// Prints the initial state of the array
		System.out.println("Pre sorted array: " + Arrays.toString(array));
		// Loops through the arrays to sort the values stored in the array
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				// Swaps array values if the lower array index is greater than the next value
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				// Prints the array if the array has changed
				if(!Arrays.equals(array,  array2)) {
					System.out.println(Arrays.toString(array));
					array2 = array.clone();
				}
			}
		}
		// Prints the array post bubble sort
		System.out.println("Post sort array: " + Arrays.toString(array));
	}
}
