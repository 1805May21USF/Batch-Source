package com.revature.utilities;

public class Question5 {
	public static String Q5(String str, int idx) {
	char[] substring = new char[idx];
	for(int i = 0; i < idx - 1;i++) {
		substring[i]=str.charAt(i);
		
	}
		
		return new String(substring);
	
	}
	public static String Q5() {
		
		return Q5("thisisjdiedekdjd", 5);
	}
}
