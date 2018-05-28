package com.revature.utilities;

public class Question1   {

public int[] bubble_srt(int array[]) {
	boolean isSorted = false;
	
	while (!isSorted) {
		boolean swap = false;
		
		for(int i = 0; i < array.length - 1; i++) {
			
			if( array[i] > array[i + 1] ) {
				swap = true;
				int temp;
				temp = array[i];
				array[i] = array[i+1];
				array[i +1] = temp;
			}
				
		}
		
		if(!swap) {
			isSorted=true;
		}
			
		
	}
	return array;
}
/* public static void swap(int i, int j, int[] array) {
	 int temp;
	 temp = array[i];
	 array[i] = array[j];
	 array[j] = temp;*/
	 
 }


 


	
	
		
		
	


