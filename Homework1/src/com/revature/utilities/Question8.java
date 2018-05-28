package com.revature.utilities;

import java.util.ArrayList;

public class Question8 {
    
	public static boolean isPalindrome(String word, String reverse) {
        return word.equals(reverse);
    }

    public static ArrayList<String> palindrome(ArrayList<String> names){
        ArrayList<String> pal = new ArrayList<String>();
                for(String name : names){
            String reverse = Q3(name);
            boolean isPal = isPalindrome(name, reverse);
            if(isPal)
                pal.add(reverse);
        }
        
        return pal;
        
    }
    public static String Q3(String str) {
    	 String orig = "niwdE";
    	 String rev = "";
    	 
    	 for(int i = str.length()-1;i>=0;i--) {
    		 
    		 rev+=str.charAt(i);
    		
    		 
    	 }
    	return rev;
}}
