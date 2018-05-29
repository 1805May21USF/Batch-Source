package com.revature.first;

public class BubbleSort {
	
	
   public void BubbleSort(int[] x) //go through the array and sort from smallest to highest
   {
	    int n = x.length; //getting the length of the array
	    int temp = 0; //temporary variable for swapping later

	    for (int i = 0; i < n; i++) //inner loop variable
	    {
	    	for (int j = 1; j < (n - i); j++) //outer loop variable
	        {
	            if (x[j - 1] > x[j]) //if the left index is greater than the right
	            {
	                temp = x[j - 1]; //if the left index IS greater than the one on the right then it will store the left index in the temporary variable
	                x[j - 1] = x[j]; //now 
	                x[j] = temp; //now setting the current index the temporary 
	            }
	        }
	    }
	}
   
   
	
	public void printBubbleSort(int[] b) 
	{
		int len1 = b.length;
		System.out.print("The Sorted Array: ");
		for(int i=0; i<len1; i++) 
		{
			System.out.print(b[i]+" ");
		}
	}
	

}
