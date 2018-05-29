package com.revature.homework.week1;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeArrayList {
	//program accepts arraylist of strings
	//and returns arraylist containing palindromes

	private ArrayList <String> stringList;
	private String str;

	
	public PalindromeArrayList() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PalindromeArrayList(ArrayList<String> stringList, String str) {
		super();
		this.stringList = stringList;
		this.str = str;
	}


	public ArrayList<String> getStringList() {
		return stringList;
	}


	public void setStringList(ArrayList<String> stringList) {
		this.stringList = stringList;
	}


	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}

	public ArrayList<String> findPalindrome(ArrayList<String> stringList, ArrayList<String> palindromeList) {
		//this method accepts two types of arraylist
		//one arraylist contains the string
		//other arraylist saves the palindromes
		for(String s: stringList) {
			if(isPalindrome(s)) {
				palindromeList.add(s);
			}
		}
		return palindromeList;
	}
	
	public boolean isPalindrome(String str) {
		//boolean method to check if a string is palindrome
		//returns true if there's a palindrome
		//returns false if there's no palindrome
		
		char[] c = str.toCharArray();
		int i = 0;
		int j = c.length -1;
		
		while(j > i) {
			if(c[i] != c[j]) {
				return false;
			}
			++i;
			--j;
		}
		
		return true;
	}
	
	
}
