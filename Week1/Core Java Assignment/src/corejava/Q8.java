package corejava;

import java.util.*;

public class Q8 {
	public static ArrayList Solution() {
		//put our list in arraylist words
		ArrayList<String> words = new ArrayList<String>(
				Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
		
		ArrayList<String> palindromes = new ArrayList<String>();
		 
		//reverse the string and check if it's the same, if so: palindrome list
		for (int i = 0; i < words.size(); i++) {
			String reverse = new StringBuffer(words.get(i)).reverse().toString();
			if (words.get(i).equals(Q3.Solution(words.get(i)))) {
				palindromes.add(words.get(i));
			}
		}
		return palindromes;
	}
}
