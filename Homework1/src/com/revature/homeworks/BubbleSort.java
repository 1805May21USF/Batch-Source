package com.revature.homeworks;

public class BubbleSort {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	int[] intArray = { 1,0,5,6,3,2,3,7,9,8,4};
	int temp;
	
	public void bubbleSort ()
	{
		//for loop to iterate through the array starting from the first number
		for (int i = 0; i < intArray.length - 1; i++)
		{	
			//for loop to iterate through the array starting from the second number
			for (int k = 0; k  < intArray.length -i-1; k++)
			{
				if (intArray[k] > intArray[k + 1])
				{
					//store the value of Array[k] in a temp
					//swap the item in temp and the one in intArray[k] ()
					temp = intArray[k];
					intArray[k] = intArray[k + 1];
					intArray[k+1] = temp;
				}
			}
		}
		
	}
	
	//method to print an array
	public void printArray(int intArray[])
	{
		for (int i = 0; i < intArray.length; i++)
		{
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}
	
	
	public void run()
	{
		System.out.println("Question  One: " + newLine + "-----------------------------");
		bubbleSort();
		System.out.println("Sorted Array: ");
		printArray(intArray);
		System.out.println("-----------------------------");
		System.out.println();
	}

}
