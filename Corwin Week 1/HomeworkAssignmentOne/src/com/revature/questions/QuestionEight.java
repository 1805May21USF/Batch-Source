package com.revature.questions;

import java.util.ArrayList;

public class QuestionEight {
	
	public QuestionEight() {
		
	}
	/*
	 * Detects if a word is a palindrom by reversing it using
	 * the same solution from question three. Then it adds it 
	 * to a new array list.
	 */
	public void run(ArrayList<String> s) {
		ArrayList<String> palindromes = new ArrayList<String>();
		for(String word:s) {
			if(isPalindrome(word)) {
				palindromes.add(word);
			}
		}
		System.out.println(s);
		System.out.println(palindromes);
	}
	private boolean isPalindrome(String s) {
		QuestionThree q3 = new QuestionThree();
		if(s.equals(q3.run(s))) {
			return true;
		}
		return false;
	}

}
