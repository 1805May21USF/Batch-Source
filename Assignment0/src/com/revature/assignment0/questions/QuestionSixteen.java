package com.revature.assignment0.questions;

import java.util.Arrays;

public class QuestionSixteen {
	public static void Question_Sixteen(String[] args) {
		
		System.out.println("\r------Question Sixteen-------");
		System.out.println("16.) Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).\r");
		
		//Using the args command to print out the name
		System.out.println("-------------");
		System.out.println("Original Name");
		System.out.println("-------------\r");
		
		System.out.println(Arrays.toString(args));
		
		//Using the args command to print out the length of the name
		System.out.println("\r------");
		System.out.println("Length");
		System.out.println("------\r");
		
		System.out.println(Arrays.toString(args).length());
	}
}
