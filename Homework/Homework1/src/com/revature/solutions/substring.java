package com.revature.solutions;

public class substring {
	public static String sub(String str,int idx) {
		String rstr = "";
		char ch[] = str.toCharArray();
		for(int i = 0;i<idx;i++) {
			rstr = rstr + ch[i];
		}
		return rstr;
	}

}
