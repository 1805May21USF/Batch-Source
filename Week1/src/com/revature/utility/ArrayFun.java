package com.revature.utility;
import java.util.Arrays;

//var args: 1 to many; var args has to be last in parameter list
//public static String format(String pattern, object... arguments);

public class ArrayFun {

	public static void printMe(int[]a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("The End!");
	}
	
	 void printMeBest(int[] yar) throws ArrayIndexOutOfBoundsException{
		System.out.println(yar[1]);
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
	//converts your array to a list.
	Arrays.asList(arr2);
	printMeGooder(arr2);
	System.out.println();
	Arrays.sort(arr2);
	printMeGooder(arr2);
	}
	
}

