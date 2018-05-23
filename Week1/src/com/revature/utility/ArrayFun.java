package com.revature.utility;
import java.util.Arrays;

public class ArrayFun {

	public static void printMe(int[]a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("The End!");
	}
	
	static void printMeGooder(int[] a) {
		for(int i : a) {
			System.out.println(i);
		}
	}
	
public static void main(String [] Args) {
	
	int [] arr = new int [3];
	int [] arr2 = {1,2,3,4,5,6,7,8,9};
	arr2[7] = 5;
	
	
	//printMe(arr2);
	//printMeGooder(arr2);
//	System.out.println("ArrayLength");777
	System.out.println(arr2.length);
	Arrays.asList(arr2);
	printMeGooder(arr2);
	System.out.println();
	Arrays.sort(arr2);
	printMeGooder(arr2);
}
	
	
}

