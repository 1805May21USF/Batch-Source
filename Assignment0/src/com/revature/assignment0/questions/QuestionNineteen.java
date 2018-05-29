package com.revature.assignment0.questions;

import java.util.*;

import com.revature.assignment0.objects.DiceMan;

public class QuestionNineteen {
	public static void Question_Nineteen() {
		
		System.out.println("------Question Nineteen-------");
		System.out.println("19.) Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.\r");
		
		//Creates an Array lise one through ten and stores it in a variable
		List<Integer> array_integers = DiceMan.getQuestionNineteenArrayList();	
		
		//Created two int variables that will keep track of adding the even and odd numbers
		int even_numbers = 0, odd_numbers = 0, counter;

		//This for loop keeps track of the size of the inital array
		for(int i = 1; i <= array_integers.size(); i++) {
			counter = 0;
			
			//This checks to see if it is even or odd
			if (i % 2 == 0) {
				even_numbers += i;
			} else {
				odd_numbers += i;
			}
			
			/*
			 * This for loop allows to check for numbers that divisible from one up to the digit that is be
			 * If it is divisible, then it adds a counter knowing what is divisible by what. 
			 * If the counter is two, then it is a prime number and is removed
			 */
			for(int j = 1; j <= i; j++) {
				if(i % j == 0)
					counter++;
			}
			
			if(counter == 2) {
				int index = array_integers.indexOf(i);
				array_integers.remove(index);
			}
		}
		
		System.out.println("\r------------------------");
		System.out.println("Sorted Out Prime Numbers");
		System.out.println("------------------------\r");
		
		System.out.println(Arrays.toString(array_integers.toArray()));
		
		System.out.println("\r----------");
		System.out.println("Odd Numbers");
		System.out.println("----------\r");
	
		System.out.println(odd_numbers);
		
		System.out.println("\r------------");
		System.out.println("Even Numbers");
		System.out.println("------------\r");
	
		System.out.println(even_numbers);
	}
}
