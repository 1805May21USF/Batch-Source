package com.revature.problem;

public class BubbleSort {
	public static int[] bubbleSort(int[] nums) {
		boolean swapped = true;
		
		while (swapped) {
			swapped = false;
			
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i+1]) {
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
					
					swapped = true;
				}
			}
		}
		return nums;
	}
	
	public static void print(int[] nums) {
		System.out.print("Bubble Sort: ");
		
		for(int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
