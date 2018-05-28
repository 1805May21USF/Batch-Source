package com.sunnara.homework;

import java.util.Scanner;

/*
 * Write a program to display the number of characters 
 * for a string input. The string should be entered as a 
 * command line argument using (String [ ] args).
 */
public class Q16 {
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
	}
	
	public void charAmt(String[] args) {
		int count = 0;
		for(String s : args ) {
			count += s.length();
		}
	}

}
