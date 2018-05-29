package com.revature.assignment0.questions;

import java.util.*;

import com.revature.assignment0.objects.DiceMan;

public class QuestionNine {

	public static void Question_Nine() {
	
		System.out.println("\r------Question Nine-------");
		System.out.println("9.) Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.\r");
		
		//Creates an array integers and stores 1 though 100 in it
		List<Integer> array_integers = DiceMan.getQuestionNine();
		
		int counter;

		//Iterates through all the numbers in the array_integers
		for(int i = 1; i <= array_integers.size(); i++) {
			counter = 0;
			
			/*
			 * Takes the number it is testing and inserts it as the highestr number the second for loop it can reach to
			 * to be able to test the prime number formula on it. Once the formaula allows the numbers to 
			 * increase their counter to two or more I take the non-orime number and remove it from the array list
			 */
			for(int j = 1; j <= i; j++) {
				if(i % j == 0)
					counter++;
			}
			
			if(counter != 2) {
				int index = array_integers.indexOf(i);
				array_integers.remove(index);
			}
		}
		
		System.out.println("------------------------");
		System.out.println("Sorted Out Prime Numbers");
		System.out.println("------------------------\r");
		
		System.out.println(Arrays.toString(array_integers.toArray()));
	}
}
