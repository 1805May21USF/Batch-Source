package com.revature.assignments;
import java.util.ArrayList;
import java.lang.*;


public class Q8 {
	//create two arrayLists one two hold the initial array
	//and another to hold the palindromes. 
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<String> palindromes = new ArrayList<String>();
	
	//add the words to the arrayLIst
	public void AddWords() {
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
	}
	
	//check the words in the list to see if they are palindromes
	public void checkWords() {
		int middle;
		int begin;
		int end;
		//for each item 
		for(String item : words) {
				middle = (item.length()  /2);
				begin = 0;
				end = item.length() -1;
			
				//check the characters starting at zero with the characters at the end of the word
				while(begin != middle) {
					if(item.charAt(begin) == item.charAt(end)) {
						begin+=1;
						end-=1;
						continue;
					}
					else {
						break;
					}
				}
				
				if(begin == end) {
					palindromes.add(item);
				}
		}
		
	}
	
	public void printPalindromes() {
		System.out.println("\n\nPalindromes\n");
		for(String item: palindromes) {
			System.out.println(item);
		}
	}
	
	public void printWords() {
		for(String item: words) {
			System.out.println(item);
		}
		
	}

}
