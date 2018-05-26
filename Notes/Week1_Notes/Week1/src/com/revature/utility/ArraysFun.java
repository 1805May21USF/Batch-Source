package com.revature.utility;

import java.util.Arrays;
//var args: 1 to many, var arg has to be last in parameter list
//public static String format(String pattern, Object...arguments);
public class ArraysFun {
	//Yay creating arrays!
	public static void main(String[] args) {
		int [] arr = new int[3];
		int [] arr2 = {1,2,3,4,5,6,7,8,9,10};
		arr2[7] = 5;
		System.out.println(arr2);
		System.out.println(arr2.length);
		
//		printMe(arr2);
//		printMeGooder(arr2);
		//Creates an array list
		Arrays.asList(arr2);
		Arrays.sort(arr2);
		printMe(arr2);
	}
	
	static void printMe(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("That's the end!");
	}
	
	static void printMeGooder(int[] a) {
		for (int x: a) {
			System.out.println(x);
		}
		System.out.println("It's better!");
	}
	
	void printMeBest(int[] yar) throws ArrayIndexOutOfBoundsException{
		System.out.println(yar[1]);
	}
}
