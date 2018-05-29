package com.revature.solutions;
import java.util.ArrayList;
public class Palindromes {
	public static ArrayList<String> normal = new ArrayList<>();
	public static ArrayList<String> pal = new ArrayList<>();
	public static void palindrome(String str) {
		normal.add("karan");normal.add("madam");normal.add("tom");normal.add("civic");
		normal.add("radar");normal.add("jimmy");normal.add("kayak");
		normal.add("john");normal.add("refer");normal.add("billy");normal.add("did");
		//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

	//	ArrayList<String> normal = new ArrayList<>();
	// 	ArrayList<String> pal = new ArrayList<>();
		for(String s:normal) {
			int left = 0;
			int right = s.length() -1;
			while(left!=right) {
				if(s.charAt(left)!=s.charAt(right)) {
					//normal.add(s);
					break;
				}
				left++;
				right--;
				if(left==right) {
					pal.add(s);
					break;
				}
			}
		}
		System.out.println("The Palindrormes are: "+pal);
		
	}

}
