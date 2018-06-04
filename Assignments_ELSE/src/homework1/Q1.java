package homework1;

public class Q1 {
	//Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
		//method should start off with a integer array
		void q1(int arr[])
	    {
	        int n = arr.length;
	        //  need to create a nested loop for the array, 
	        //so the bubble sort can keep track of the number order in the list.
	        //
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (arr[j] > arr[j+1])
	                {
	                    // switch between vers and arr[i]
	                    int vers = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = vers;
	                }
	    }
	 
	    /* Now call the print array */
	    void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	    
	    //Due to its simplicity, bubble sort is often used to introduce the concept of a sorting algorithm.
	   // In computer graphics it is popular for its capability to detect a very small error (like swap of 
	   // just two elements) in almost-sorted arrays and fix it with just linear complexity (2n).

	//Now test the code above
	public static void main(String args[])
	{
	    Q1 ob = new Q1();
	    int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
	    ob.q1(arr);
	    System.out.println("returned bubble sort");
	    ob.printArray(arr);
	}
	}