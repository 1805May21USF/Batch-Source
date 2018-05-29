/**
 * Write a program that stores the following strings in an ArrayList and 
 * saves all the palindromes in another ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 * 
 * Completed: Yes
 */
package com.revature.corejava;

import java.util.ArrayList;

import java.util.Arrays;

/**
 * @author Nicholas Smith
 *
 */
public class Q08
{
	//create global variables
	private ArrayList<String> originalArray = new ArrayList<String>();
	private ArrayList<String> palindromeArray = new ArrayList<String>();
	
	//create a method to populate the array
	public ArrayList<String> makeArray()
	{
		originalArray.add("karan");
		originalArray.add("madam");
		originalArray.add("tom");
		originalArray.add("civic");
		originalArray.add("radar");
		originalArray.add("jimmy");
		originalArray.add("kayak");
		originalArray.add("john");
		originalArray.add("refer");
		originalArray.add("billy");
		originalArray.add("did");
		
		return originalArray;
	}
	//create a method that determines if the String is a palindrome
	public boolean isPalindrome(String word) 
	{
		
		//a word is a palindrome if it is the same word when reversed
		//compare the first character and last character of the string
		//if they are different, return false
		//otherwise, move on to the next element, and compare it to the second to last element
		//create a char to traverse the array easily
		
		//add the string to the char array
		char[] charArr = word.toCharArray();
				
		//the number of loops is equal to the length of the word
		//NOTE: be careful that variables are not resetting their values in the for loop
		int lastIndex = charArr.length - 1; 
		for(int i = 0; i <= charArr.length-1; i++) 
		{
			char c1 = charArr[i];
			//the last index is located at length - 1
			char c2 = charArr[lastIndex];
						
			if (c1 != c2)
			{
				return false;
			}
			
			lastIndex --;
		}
		
		//as long as the condition above isn't met, then the word is a palindrome
		return true;
	}
	
	//create a method to add Palindrome words to a new array
	public ArrayList<String> makePalindromeArray()
	{
		//check each string of the originalArray
		//if it is palindrome, add it to palindromeArray
		
		//loop over the originalArrayList
		for(int i = 0; i <= originalArray.size() - 1; i ++) 
		{			
			//call the isPalindrome method
			//assign it to a boolean named p
			
			//get the current word from the original array
			String pWord = originalArray.get(i);
						
			boolean p = isPalindrome(pWord);
			
			if (p == true) 
			{
				//add pWord to palindromeArray
				palindromeArray.add(pWord);
			}
		}
		//temp
		return palindromeArray;
	}
	
}
