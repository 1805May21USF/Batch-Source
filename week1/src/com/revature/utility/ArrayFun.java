
package com.revature.utility;

import java.util.Arrays;
// var args: 1 to many, var arg has to be last in parameter list
//public static string format(String pattern, Object ... arguments);

public class ArrayFun {
	int [] arr3= {1,2,3};
	
	public static void main(String[] args) {
	
		int[] arr =new int[3];
		int [] arr2 = {1,2,3,4,5,6,7,8,9,10};
	
		arr2[7]=5;
		Arrays.asList(arr2);
		Arrays.sort(arr2);
		printMe(arr2);
		System.out.println(arr2.toString());
		System.out.println(arr2.length);
	
	}
	static void printMe(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("The World is big");
	}
	 
	static void printMeGooder(int[] a) {
		for(int i : a) {
			System.out.println(i);
		}
	}
	static void printMeBest(int[] yar) throw ArrayIndexOutOfBoundsException{
		System.out.println(x);
	}
}
