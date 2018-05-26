package com.revature.beans;
/* Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4 */
public class Problem1 {

	public static String arrayToString(int[] iArray){
		int[] sorted = bubbleSortTheArray(iArray);
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < sorted.length; i++){
			if(i == sorted.length - 1){
				sb.append(sorted[i] + "]");
			}else{
				sb.append(sorted[i] + ",");
			}
		}
		
		return sb.toString();
	}
	
	private static int[] bubbleSortTheArray(int[] iArray){
		for(int i = 0; i < iArray.length - 1; i++){
			for(int j = i + 1; j < iArray.length; j++){
				if(iArray[i] > iArray[j]){
					int temp = iArray[j];
					iArray[j] = iArray[i];
					iArray[i] = temp;
				}
			}
		}
		
		return iArray;
	}

}
