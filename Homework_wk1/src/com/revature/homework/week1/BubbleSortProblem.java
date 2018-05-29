package com.revature.homework.week1;

public class BubbleSortProblem {
	//sort an array of integers using bubble sort algorithm
	
	private int [] arr;

	public BubbleSortProblem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int[] getArr() { //getter
		return arr;
	}

	public void setArr(int[] arr) { //setter
		this.arr = arr;
	}

	public void sortArray(int[] arr) {
		//this method takes in an array of integer
	       boolean swapped = true;
	        for(int i=0; i<arr.length-1; i++) {
	            swapped = false;
	            for(int j=0; j<arr.length-(i+1); j++) {
	                if(arr[j] > arr[j+1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                    swapped = true;
	                }
	            }
	            if(swapped == false)
	                break;
	        } 
	}
	
	public void printArray(int[] arr) {
		//this method takes in an array
		//prints out the array before and after sorting
		for(int i=0; i<arr.length; i++) {
			if(i > 0) { //prints comma after each value of the array
				System.out.print(", ");
			}
            System.out.print(arr[i]);
        }
	}
}
