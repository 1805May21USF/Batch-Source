package com.revature.corejava;


public class Q1 
{
	
	private int[] myArray;
	
	public Q1()
	{
		this.myArray = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		
	}
	
	public int[] getArray()
	{
		return this.myArray;
	}
	
	//Method to go through the array and perform the checks if a swap needs to happen
	public void bubbleSortArray()
	{
		boolean swapped = false;
		do 
		{
			swapped = false;
			for(int i = 0; i<this.myArray.length - 1; i++)
			{
				if(this.myArray[i] > this.myArray[i + 1] )
				{
					swapped = true;
					swapTwoNumbers(i, i+1);
				}
			}
			
		}while(swapped);
	}
	//Performs the swaps of two numbers in the array by their index
	private void swapTwoNumbers(int firstIndex, int secondIndex)
	{
		int tempVar = this.myArray[firstIndex];
		this.myArray[firstIndex] = this.myArray[secondIndex];
		this.myArray[secondIndex] = tempVar;
	}
	

}
