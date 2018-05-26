package com.revature.toomuchhw;

import java.util.ArrayList;

//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
public class Problem8 {
	
	public Problem8() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean checkPalindrome(String s) {
		int len = s.length();
		String reversies = "";

		for(int i = len-1; i >= 0; i--) {
			reversies = reversies+s.charAt(i);
		}
		
		if(reversies.equals(s)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList<String> findAllPalindromes(ArrayList<String> words){
		ArrayList<String> palindromes = new ArrayList<String>();
		for(String w:words) {
			if(checkPalindrome(w)) {
				palindromes.add(w);
			}
		}
		return palindromes;
	}

}
