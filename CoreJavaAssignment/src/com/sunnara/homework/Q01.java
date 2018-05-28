package com.sunnara.homework;

/*
 * Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */
public class Q01 {
	
	public void start() {
		int i[] = {1,0,5,6,3,2,3,7,9,8,4}; // original problem

		System.out.println("Question 1:\n(shown steps for bubblesort)");
		printString(i); //print array
		System.out.println();
		i = bubbleSort(i);
		printString(i);
		System.out.println("\n");
	}

	/**
	 * Sorts the array recursively.
	 * Each step is printed out
	 * @param ia
	 * @return - new sorted array is returned;
	 */
	public int[] bubbleSort(int[] ia) {		
		//No need to sort if there is only 1 value
		if(ia.length <= 1) {
			return ia;
		}
		
		boolean switchedOnce = false; //If 2 values switches, we need to sort again 
		int[] iArray = ia; // created to modify param
		for(int i = 0; i < iArray.length-1; i++) {
			if(iArray[i] > iArray[i+1]) { 
				int a = iArray[i];
				int b = iArray[i+1];
				iArray[i] = b; 
				iArray[i+1] = a; 
				switchedOnce = true;
			}
		}
		//Remove comments to show step-by-step
		printString(iArray);
		System.out.println();
		
		
		if(switchedOnce) {
			iArray = bubbleSort(iArray);
		}
		return iArray;
	}
	

	/**
	 * Prints array to console
	 * @param i receives array
	 */
	public void printString(int[] i) {
		for(int a : i) {
			System.out.print(a + " ");
		}
	}
}
