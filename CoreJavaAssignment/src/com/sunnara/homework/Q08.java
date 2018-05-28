package com.sunnara.homework;

import java.util.ArrayList;

/*
 * Write a program that stores the following strings 
 * in an ArrayList and saves all the palindromes 
 * in another ArrayList.
 * 
 */
public class Q08 {

	private ArrayList<String> words;
	private ArrayList<String> palindromes;

	
	public void start() {
		String[] s = {"karan", "madam", "tom", "civic", 
				"radar", "jimmy", "kayak", "john", 
				"refer", "billy", "did"};
		setWords(s);
		setPalindromes(words);
		System.out.println("Question 8:\nGet palindromes from Arraylist");
		System.out.println(toString());
		System.out.println();

	}

	public Q08(String... s) {
		words = new ArrayList<String>();
		palindromes = new ArrayList<String>();
	}
	/**
	 * Accepts any amount of Strings
	 * @param s -String to be checked for palindromes
	 */
	public void setWords(String... s) {
		for(int i = 0; i < s.length; i++) {
			words.add(s[i]);
		}	
	}

	/**
	 * Adds palindromes to arraylist
	 * @param words - Arraylist containing list of words
	 */
	public void setPalindromes(ArrayList<String> words) {
		for(String s : words) { //checks each string in words arraylist
				if(checkPalindromes(s)) {
					palindromes.add(s);
				}
			}	
	}
	/**
	 * Checks to see if string is a palinedrome (same reverse)
	 * @param s
	 * @return
	 */
	public boolean checkPalindromes(String s) {
		boolean fail = false;
		if(s.length() == 1 || s.length() == 0) { //checks to see if char at each ends match
			return true;
		} else {
			if(s.charAt(0) == s.charAt(s.length()-1)) {
				fail = checkPalindromes(s.substring(1, s.length()-1)); //substring ends out
			}
				return fail;
		}

	}

	@Override
	public String toString() {
		return "Words = " + words + "\nPalindromes = " + palindromes;
	}
}
