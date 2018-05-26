package com.revature.beans;
/*Q6. Write a program to determine if an integer is even without using the modulus operator (%)*/

public class Problem6 {
	public static boolean isEven(int n){
		String s = Integer.toBinaryString(n).toString();
		
		if(s.charAt(s.length() -1) == '0'){
			return true;
		}else{
			return false;
		}
	}
}
