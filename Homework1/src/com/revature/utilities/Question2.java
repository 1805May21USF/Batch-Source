package com.revature.utilities;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question2 {
	
	public static String Question2() {
	int number1 = 1;
	int number2 = 0;
	int fit = 25;
	int currentNumber = 0;
	
	int[] fibonacci = new int[fit];
	fibonacci[0] = number2;
	fibonacci[1] = number1;
	
	for(int i = 0; i< fit -2;i++) {
		currentNumber = number1 + number2;
		number2 = number1;
		number1 = currentNumber;
		
		fibonacci[i+2] = currentNumber;
	}
	return Arrays.toString(fibonacci);
	
	
	
	
	}


}
