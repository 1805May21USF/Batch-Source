package com.revature.problem;

import java.util.ArrayList;

public class FibNumbers {
	public static String fibNumbers(int size) {
		StringBuilder result = new StringBuilder();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		if (size >= 1) {
			nums.add(0);
			result.append(nums.get(0) + " ");
		} if (size >= 2) {
			nums.add(1);
			result.append(nums.get(1) + " ");
	    } if (size > 2) {
			for (int i = 2; i < 25; i++) {
				nums.add(nums.get(i-2) + nums.get(i-1));
				result.append(nums.get(i) + " ");
			}
		}
		
		return result.toString();
	}
	
	public static void print(String str) {
		System.out.println("Fibonacci Numbers: " + str);
	}
}
