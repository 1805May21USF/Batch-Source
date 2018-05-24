package com.revature.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysFun {

	public static void main(String[] args) {
		int[] arr = new int[3];
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
		arr2[7] = 5;
		printMe(arr2);
		printMe2(arr2);
		List<int[]> a = Arrays.asList(arr2); //creates ArrayList version
		Arrays.sort(arr2);
		printMe2(arr2);
		System.out.println(arr2.length);
	}
	
	public static void printMe(int[] a) {
		for(int i = 0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		System.out.println("that's it");
	}
	
	public static void printMe2(int[] a) {
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("that's it");
	}
	
	void printMeBest(int[] yar) throws ArrayIndexOutOfBoundsException {
		System.out.println(yar[3]);
	}
}
