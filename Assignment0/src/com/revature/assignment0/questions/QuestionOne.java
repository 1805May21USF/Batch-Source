package com.revature.assignment0.questions;

import java.util.*;

import com.revature.assignment0.objects.DiceMan;

public class QuestionOne {
	
	public static void Question_One(){
		
		//Create two array list to hold the length of the random list and another list to hold the list itself
		Integer[] numbers = new Integer[DiceMan.getRandomList().length];
		Integer[] integer_array = DiceMan.getRandomList();
		
		for(int i = 0; i <= numbers.length - 1; i++) {
			numbers[i] = integer_array[i];
		}
		
		//Call the bubble sort method
		Question_One_Bubble_Sort(numbers,integer_array);
	}
	
	public static void Question_One_Bubble_Sort(Integer[] new_array, Integer[] old_array ) {
		
		/*
		 * Takes the variable and compares it to adjacent variables and swaps them if the 
		 * number they are comparing against is smaller
		 */
		int temp = 0;
		for(int i = 0; i < new_array.length; i++) {
			for (int k = 1; k < new_array.length-i; k++) {
				if(new_array[k - 1] > new_array[k]) {
					temp = new_array[k - 1];
					new_array[k - 1] = new_array[k];
					new_array[k] = temp;
				}
			}
		}
		
		System.out.println("------Question One-------");
		System.out.println("1.) Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4");
		
		System.out.println("\r-------");
		System.out.println("Orignal");
		System.out.println("-------");
		System.out.println(Arrays.toString(old_array));
		
		System.out.println("\r-------------");
		System.out.println("Bubble Sorted");
		System.out.println("-------------");
		System.out.println(Arrays.toString(new_array));
	}
}
