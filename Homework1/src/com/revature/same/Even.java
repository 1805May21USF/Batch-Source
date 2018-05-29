package com.revature.same;

import java.util.ArrayList;

/*
 * A class that prints all the even numbers fro 1 to 100
 */
public class Even {

	/*
	 * Constructor for the Even class calls isEven()
	 */
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
	
	/*
	 * A method that prints all the even numbers in an array
	 * @Param numArray: an array containing the numbers from 1 to 100
	 * @return
	 */
	public static void isEven(int[] numArray) {
		for(int num : numArray) {
			if(num % 2 == 0)
				System.out.print(num + " ");
		}
	}

}
