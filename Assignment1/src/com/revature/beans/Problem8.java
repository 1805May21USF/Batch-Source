package com.revature.beans;

import java.util.ArrayList;

/*Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
*/
public class Problem8 {
		private ArrayList<String> array = new ArrayList<String>();
		private ArrayList<String> palindromeArray = new ArrayList<String>();
		
	public ArrayList<String> giveMePalidromes(String... s){
		
		for(String str: s){
			addElementToArray(str);
			if(isPalindrome(str)){
				addElementToPalindromeArray(str);		
			}
		}
		return getPalindromeArray();
	}

	public ArrayList<String> getArray() {
		return array;
	}

	public void setArray(ArrayList<String> array) {
		this.array = array;
	}

	public ArrayList<String> getPalindromeArray() {
		return palindromeArray;
	}

	public void setPalindromeArray(ArrayList<String> palindromeArray) {
		this.palindromeArray = palindromeArray;
	}
	
	public void addElementToArray(String s){
		this.array.add(s);
	}
	
	public void addElementToPalindromeArray(String s){
		this.palindromeArray.add(s);
	}
	
	public boolean isPalindrome(String s){
		if(s.equals(new StringBuilder(s).reverse().toString())){
			return true;
		}else{
			return false;
		}
	}
}
