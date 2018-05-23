package com.revature.utility;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysTest {
	
	public static void main(String[] args) {

		int[] arr = new int[3];
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
		arr2[4] = 7;
		
		
		Arrays.sort(arr2);
		
		printMe(arr2);

	}
	
	static void printMe(int[] aArray) {
		for(int i: aArray) {
			System.out.println(i);
		}
	}
	
	static void manyArgs(int x, int... q) {
		
	}

}
