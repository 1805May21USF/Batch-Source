package com.test;

import java.util.ArrayList;

import com.revature.exceptions.NewException;

public class TestingEqualsforStuff {

	public static void main(String[] args) {
		int a = 5; int b = 5; 
		String sa = "a";
		String sb = "a";
		Integer aI = 5;

		System.out.println(a == b);
		System.out.println(sa == sb);
		System.out.println(a == aI);
		ArrayList<String> aList = new ArrayList<>();
		
		EvenNumber o = new EvenNumber(5);
		
	}

}