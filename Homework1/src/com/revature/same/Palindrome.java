package com.revature.same;
import java.util.ArrayList;

public class Palindrome {
	public static ArrayList<String> names;
		
	/*
	 * A constructor for the Palindrome class
	 */
	public Palindrome() {
		// TODO Auto-generated constructor stub
		this.names =  new ArrayList<>();
		names.add("karan"); names.add("jimmy"); names.add("did");
		names.add("madam"); names.add("kayak");
		names.add("tom");   names.add("john");
		names.add("civic"); names.add("refer");
		names.add("radar"); names.add("billy");
	}
	
	public static boolean isPalindrome(String word, String reverse) {
		return word.equals(reverse);
	}
	
	/*
	 * A method that checks if the String elements in an array are palindromes
	 * @Param names: an arraylist containing Strings
	 * @return returns an arraylist of all the palindromes
	 */
	public static ArrayList<String> palindrome(ArrayList<String> names){
		ArrayList<String> pal = new ArrayList<String>();
		Reverse rev = new Reverse();
		for(String name : names){
			String reverse = rev.reverse(name);
			boolean isPal = isPalindrome(name, reverse);
			if(isPal)
				pal.add(reverse);
		}
		return pal;
	}

}
