package com.revature.beans;

import java.util.ArrayList;

public class Question08 {
	
	public void findPalindromes(String [] str) {
		int length = str.length;
		
		//store all strings into first array list
		ArrayList<String> list1 = new ArrayList<String>();
		for(int i=0; i<length; i++) {
			list1.add(str[i]);
		}
		
		//find palindromes and store in second array list
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i=0; i<list1.size(); i++) {
			String reverse = "";
			int strLength = list1.get(i).length();
			for(int j=strLength-1; j>=0; j--) {
				reverse += list1.get(i).charAt(j);
			}
			if(list1.get(i).equals(reverse)) {
				System.out.println(list1.get(i) + " is a palindrome! Storing in palindromes array list...");
				list2.add(list1.get(i));
			} else {
				System.out.println(list1.get(i) + " is not a palindrome!");
			}
		}
		System.out.println("\nPalindromes array list: ");
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i));
		}
 	}
	

}
