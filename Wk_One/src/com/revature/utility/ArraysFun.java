package com.revature.utility;

import java.util.Arrays;
//var args: 1 to many, var arg has to be last in parameter list
//public static String format(String pattern, object... arguments);

public class ArraysFun {
	
	int [] arr3 = {1, 2, 3};
	public static void main(String[] args) {
		
		int [] arr = new int[3];
		int [] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		arr2[7] = 5;
		
		//System.out.println(arr2.toString());
		System.out.println("The array size is = " + arr2.length);
		//printArray(arr2);
		System.out.println("The array is: ");
		printArrayFly(arr2);
		Arrays.sort(arr2);
		System.out.println("Here's the array after sorting: ");
		printArrayFly(arr2);
		Arrays.asList(arr2);
		System.out.println("The size of the other array is = " + arr.length);
		printArray(arr);
	}
	
	static void printArray(int[] a) {
		//printing array using for loop
		System.out.println("Here's the other array: ");
		for(int i = 0; i <a.length; i++) {
			if(i > 0) { //prints comma after each value of the array
				System.out.print(", ");
			}
			System.out.print(a[i]);
		}
	}
	
	static void printArrayFly(int[] a) {
		//printing array using for each loop
		for(int i: a) {
			if(i > 1 || i == 0) { //prints comma after each value of the array
				System.out.print(", ");
			}
			System.out.print(i);
		}
		System.out.println();
	}
	
	 void printArrayBest(int[] yar) throws ArrayIndexOutOfBoundsException{
		System.out.println(yar[1]);
	}
}
