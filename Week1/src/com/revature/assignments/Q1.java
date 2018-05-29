package com.revature.assignments;

public class Q1 {
	
	private static int [] arr = {1,0,5,6,3,2,3,7,9,8,4};
		

		public static void sort() {
			
			//use temp variable to store the integer that is being switched.
			int temp;
			//I used a for loop because we know the array is a set length
			//making it easy to iterate through
			for(int i = 0; i < arr.length - 1; i++) {
				
				for(int j = 0; j<arr.length - i -1;j++) {
					//if the the current element is greater than the next element flip them.
					if(arr[j]>arr[j+1]) {
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
		}
		//print out the elements in the array using an enhanced for loop.
		public static void printSort() {
			for(int item : arr) {
				System.out.print(item);
			}
		}

}
