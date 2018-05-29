package com.revature.hw1;

public class P5Substring {
	public static void substring(String s, int k) {
		String[] sArray = s.split("");
		String subStr = "";
		for (int i = 0; i < k; i++) subStr += sArray[i];
		System.out.println(subStr);
	}
}
