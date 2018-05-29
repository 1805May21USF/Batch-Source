package corejava;

import java.util.Arrays;

public class Q1 {
	public static String Solution() {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		int temp;
		
		//first loop goes through array
		for (int i=0; i < arr.length - 1; i++) {
			//second loop goes through for every spot and compares all numbers to right and swaps if needed
			for (int j=0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j + 1] = temp;
				}
			}
		}
		return Arrays.toString(arr);
	}
}
