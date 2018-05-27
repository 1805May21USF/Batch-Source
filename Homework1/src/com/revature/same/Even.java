package com.revature.same;

import java.util.ArrayList;

public class Even {

	public Even() {
		// TODO Auto-generated constructor stub
		ArrayList<Integer> numbers = new ArrayList<>();
		int[] numArray = new int[100];
		for(int i = 0; i < 100; i++){
			numArray[i] = i+1;
		}
		System.out.print("The even numbers from 1 to 100 are: ");
		isEven(numArray);
		System.out.println();
	}
	
	public static void isEven(int[] numArray) {
		for(int num : numArray) {
			if(num % 2 == 0)
				System.out.print(num + " ");
		}
	}

}
