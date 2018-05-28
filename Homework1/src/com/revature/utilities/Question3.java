package com.revature.utilities;

public class Question3 {
	public static String Q3() {
 String orig = "niwdE";
 String rev = "";
 
 for(int i = orig.length()-1;i>=0;i--) {
	 
	 rev+=orig.charAt(i);
	
	 
 }
return rev;
	}
}
