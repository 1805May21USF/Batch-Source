package com.revature.assignment0.questions;

import java.util.*;

import com.revature.assignment0.objects.DiceMan;

public class QuestionEight {

	public static void Question_Eight() {
		
		//Gather the palindromes list from the DiceMan class and insert it in to an array list
		String[] temp_palindromes = DiceMan.getQuestionEightPalindromes();
		
		//The lists below are used to split the list in to palindromes and non-palindromes
		List<String> non_Palindromes = new ArrayList<String>();
		List<String> palindromes = new ArrayList<String>();
		
		for(int i = 0; i <= temp_palindromes.length - 1; i++) {
			//Takes the first word in the list and reverses it and stores it in to a temp variable
			StringBuilder reversed_word = new StringBuilder(temp_palindromes[i]).reverse();
			//After reversing it, it checks to see if the word in the temp variable is the same as the one in the array list
			if (reversed_word.toString().compareTo(temp_palindromes[i]) == 0) {
				//If it is the same, store it in palindromes
				palindromes.add(reversed_word.toString());
			} else {
				//If it is different store it in non_palindromes
				non_Palindromes.add(temp_palindromes[i]);
			}
		}
		
		System.out.println("------Question Eight-------");
		System.out.println("8.) Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.\r");
		
		System.out.println("----------");
		System.out.println("Unsorted");
		System.out.println("----------");
		
		System.out.println(Arrays.toString(temp_palindromes));
			
		System.out.println("\r-----------");
		System.out.println("Palindromes");
		System.out.println("-----------");
		
		System.out.println(Arrays.toString(palindromes.toArray()));
		
		System.out.println("\r---------------");
		System.out.println("Non-Palindromes");
		System.out.println("---------------");
		
		System.out.println(Arrays.toString(non_Palindromes.toArray()));
	}
}
