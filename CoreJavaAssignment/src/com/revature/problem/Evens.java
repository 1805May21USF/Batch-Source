package com.revature.problem;

public class Evens {
	public static int[] evens(int[] nums) {
		int[] evenNums = new int[50];
		int count = 0;
		
		for (int num : nums) {
			if (num % 2 == 0) {
				evenNums[count] = num;
				count += 1;
			}
		}
		
		return evenNums;
	}
	
	public static void print(int[] nums) {
		StringBuilder builder = new StringBuilder();
		
		for (int num : nums) {
			builder.append(num + " ");
		}
		
		System.out.println("Array Evens: " + builder.toString());
		
	}
}
