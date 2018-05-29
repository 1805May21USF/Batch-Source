package com.revature.assignments;

public class Q2 {

		
		//an integer array to hold the first 25 fibonnaci values.
		private static int fibArr[] = new int[25];
		
		
		//Add the first elements of the array
		//there needs to be two values to start with since the 
		//fibonnci formula is Nth  = (N-1)th + (N-2)th
		public static void fibAddFirstTwoElements() {
			fibArr[0] = 0;
			fibArr[1] = 1;
		}
		
		//add the rest of the fibbonaci numbers to the array
		//using a for loop starting at 2.
		public static void fibbonaciAdd() {
		
			//add the values to the current element while the
			//current element is lest than 25
			for(int i= 2; i<25;i++) {
				
				fibArr[i] = fibArr[i-1] + fibArr[i-2];
			
			}	
		}
		
		//print the fibbonaci sequence
		public static void printFibbonaci() {
			for(int item : fibArr) {
				System.out.println(item);
			}
		}
	
		//method that runs the Fibbonci sequence
		public static void RunFibbonaci() {
			
			
			fibAddFirstTwoElements();
			fibbonaciAdd();
			printFibbonaci();
		}
	
}
