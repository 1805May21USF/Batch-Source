package com.revature.toomuchhw;

//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
public class Problem1 {
	static int temp;
	
	public int[] performBubbleSort(int[] arr) {
		//length of array
		int len = arr.length;
		boolean notdone = true;
		
		while(notdone)
		{
			//if it doesn't swap at all, it's done
			notdone = false;
			for(int i = 0; i < len-1; i++) {
				if(arr[i] > arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]= temp;
					notdone = true;
				}
			}
		}
		
		
		return arr;
	}
	

}
