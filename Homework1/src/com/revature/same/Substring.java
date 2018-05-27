package com.revature.same;

public class Substring {

	public Substring() {
		// TODO Auto-generated constructor stub
	}
	
	public static String substring(String str, int idx) {
		String result = "";
		for(int i = 0; i <= idx; i++) {
			result += str.charAt(i);
		}
		return result;
	}

}
