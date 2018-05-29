package com.revature.hw1;

import java.util.ArrayList;

public class P8Palindrome {
	public static void palindromeChecker() {
		boolean mySwitch = false;
		String[] arr = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		//addAll?
		ArrayList<String> arrList =new ArrayList<String>();
		ArrayList<String> no = new ArrayList<String>();
		ArrayList<String> palArray = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) arrList.add(arr[i]);
		
		//if items for example 0-1 match 4-3 and it's odd, it's a palindrome
		for (String j : arrList) {
			//System.out.println("current "+ j);
			char[] charray = j.toCharArray();
			if(charray.length % 2 == 1) {
				for(int k =0; k < (charray.length-1)/2;k++) {
					if(charray[k] != charray[charray.length-1-k]) {
						no.add(j);
						break;
					}
				}
			}
			else {
				for (int k = 0; k < charray.length/2; k++) {
					if (charray[k] != charray[charray.length-1-k]) {
						no.add(j);
						break;
					}
				}
			}
		}
		for(String l : arrList) if (!no.contains(l)) palArray.add(l);
		for(String m : palArray) System.out.print(m+ " ");
		System.out.println("");
		
	}
}
