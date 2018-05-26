package com.revature.problem;

import java.util.ArrayList;

public class Palindromes {
	public static ArrayList<String> palindromes(ArrayList<String> strs) {
		StringBuilder builder = new StringBuilder();
		ArrayList<String> pals = new ArrayList<String>();
		
		for (String str : strs) {
			builder = new StringBuilder();
			
			builder.append(str);
			if (str.equals(builder.reverse().toString())) {
				pals.add(str);
			}
		}	
		return pals;
	}
	
	public static void print(ArrayList<String> strs) {
		System.out.print("Palindromes: ");
		for (String str : strs) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
}
