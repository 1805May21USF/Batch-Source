package com.revature.utilities;

import java.util.ArrayList;

public class Question12 {

	public static ArrayList<Integer> Q12() {
		int[] nums = new int[101];
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		for(int i = 0; i <= 100; i++) {
			
			nums[i]= i;
			
			
		}
		for(int i : nums) {
			
		if(i% 2 == 0 && i !=0) {
			
			
			nums2.add(i);
			
			
		}
			
		}
		return nums2;
		
		
		
		
	}
}
