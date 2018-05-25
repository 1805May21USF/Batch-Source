package com.revature.utility;

import java.util.Arrays;

public class ArraysFun {
	public static void main(String[] args) {
		int[] IntArray = new int[3];
		int[] arr2 = {1,3,2,4,5,6,7,8,9,10};
		arr2[7] = 5;
		
		Arrays.asList(arr2);
		Arrays.sort(arr2);
		
		System.out.println(arr2.length);
		printMe(arr2);
		printMeGooder(arr2);
	}
	
	static void printMe(int[] a) {
		for(int i=0;i <a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("That's the end!");
	}
	
	static void printMeGooder(int[] a) {
		for(int i : a) {
			System.out.println(i);
		}
	}
	
	 void printMeBest(int[] yar) throws ArrayIndexOutOfBoundsException{
	}
}
