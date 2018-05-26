package com.revature.utility;

import java.util.Arrays;

public class ArraysFun {
	public static void main(String[] args) {
		int[] arr = new int[3];
		int [] arr2 = {1,2,3,4,5,6,7,8,9};
		
		arr2[7] = 5;
		
		Arrays.asList(arr2);
		Arrays.sort(arr2);
		printMe(arr2);

	}
	
	static void printMe(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("That's the end!");
	}
	static void printMeGooder(int[] a) {
		for(int i : a) {
			System.out.println(i);
		}
	}

}
