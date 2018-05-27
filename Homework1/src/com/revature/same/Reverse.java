package com.revature.same;

public class Reverse {

	public Reverse() {
		// TODO Auto-generated constructor stub
	}
	
	public static String reverse(String word) {
		String rev = "";
		int size =  word.length()-1;
		String last = word.charAt(size) + "";
		if(word.length() == 0){
			return null;
		}else if(word.length() == 1){
			rev += word.charAt(size);
			return rev;
		}
		rev += word.charAt(size);
		return rev +reverse(word.substring(0, size));
	}

}
