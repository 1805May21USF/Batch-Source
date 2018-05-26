package com.revature.utility;

public class DogChecker {
	static void check(String[] strs) throws NoDogException {
		for(String s : strs) {
			if (s.contains("dog")) {
				System.out.println("Woo dog!");
			} else {
				throw new NoDogException("No dog in string.");
			}
		}
	}
	
	public static void main(String[] args) {
		String[] strs = {"nodog", "dog", "fail"};
		try {
			check(strs);
		} catch (NoDogException e) {
			e.printStackTrace();
		}
	}
}
