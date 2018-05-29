package com.revature.assignment0.questions;

import java.util.*;

import com.revature.assignment0.objects.DiceMan;

public class QuestionTwelve {
	public static void Question_Twelve() {
		
		//Store 1 through 100 in a array list
		Integer[] integer_list = DiceMan.getQuestionTweleveNumbers();
		
		//The even_numbers list when we will add the even numbers too
		List<Integer> even_numbers =  new ArrayList<Integer>();
		
		//A for loop to check the 100 array list for even numbers using a remainderunsigned instead of %
		for(int integers : integer_list) {
			if(Integer.remainderUnsigned(integers, 2) == 0) {
				even_numbers.add(integers);
			}
		}		
		
		System.out.println("\r------Question Twelve-------");
		System.out.println("12.) Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.\r");
		
		System.out.println(even_numbers);
	}
}
