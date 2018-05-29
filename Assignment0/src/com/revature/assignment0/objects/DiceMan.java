package com.revature.assignment0.objects;

import java.util.*;

public class DiceMan {
	//All the private fields below are used to reduce code clutter on the actual question .java
	private static final Integer[] RANDOM_LIST = {1,0,5,6,3,2,3,7,9,8,4};
	private static final StringBuffer QUESTION_THREE_NAME = new StringBuffer("Robert");
	private static final byte QUESTION_FOUR_FACTORIAL;
	private static final byte QUESTION_SIX_INTEGER;
	private static final String[] QUESTION_EIGHT_PALINDROMES = new String[] {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
	private static final List<Integer> QUESTION_NINE = new ArrayList<Integer>();
	private static final List<Integer> QUESTION_TEN_DICE = new ArrayList<Integer>();
	private static final byte QUESTION_ELEVEN_FLOAT_A;
	private static final byte QUESTION_ELEVEN_FLOAT_B;
	private static final Integer[] QUESTION_TWELEVE_NUMBERS = new Integer[100];
	private static final byte QUESTION_THIRTEEN_ROW;
	private static final byte QUESTION_FOURTEEN_NUMBER;
	private static final float QUESTION_FIFTHTEEN_NUMBER_A;
	private static final float QUESTION_FIFTHTEEN_NUMBER_B;
	private static final List<Integer> QUESTION_NINETEEN_ARRAY_LIST = new ArrayList<Integer>();

	//This allows once the object is first instantiated to use the functions that are inside the static block to fill the final fields
	static {		
		QUESTION_FOUR_FACTORIAL = (byte)(Math.floor(Math.random() * 10) + 1);
		QUESTION_SIX_INTEGER = (byte)(Math.floor(Math.random() * 100) + 1);
		for(int i = 0; i < 2; i++) {
			QUESTION_TEN_DICE.add((int)(Math.floor(Math.random() * 10) + 1));
		}
		for(int i = 1; i <= 100; i++) {
			QUESTION_NINE.add(i);
		}
		QUESTION_ELEVEN_FLOAT_A = (byte)(Math.random() * 10);
		QUESTION_ELEVEN_FLOAT_B = (byte)(Math.random() * 10);
		for(int i = 1; i <= 100; i++) {
			QUESTION_TWELEVE_NUMBERS[i -1] = i;
		}
		QUESTION_THIRTEEN_ROW = (byte)(Math.floor(Math.random() * 3) + 1);
		QUESTION_FOURTEEN_NUMBER = (byte)(Math.floor(Math.random() * 3) + 1);
		QUESTION_FIFTHTEEN_NUMBER_A = (float)(Math.floor(Math.random() * 100) + 1);
		QUESTION_FIFTHTEEN_NUMBER_B = (float)(Math.floor(Math.random() * 100) + 1);
		for(int i = 1; i <= 10; i++) {
			QUESTION_NINETEEN_ARRAY_LIST.add(i);
		}
	}
	
	//All the getter and setters below are used to gather the data without giving access to the private variables
	
	public static Integer[] getQuestionTweleveNumbers() {
		return QUESTION_TWELEVE_NUMBERS;
	}
	
	public static List<Integer> getQuestionNine() {
		return QUESTION_NINE;
	}
	
	public static List<Integer> getQuestionNineteenArrayList() {
		return QUESTION_NINETEEN_ARRAY_LIST;
	}
	
	public static float getQuestionFifthteenNumberA() {
		return QUESTION_FIFTHTEEN_NUMBER_A;
	}

	public static float getQuestionFifthteenNumberB() {
		return QUESTION_FIFTHTEEN_NUMBER_B;
	}

	public static byte getQuestionThirteenRow() {
		return QUESTION_THIRTEEN_ROW;
	}

	public static byte getQuestionSixInteger() {
		return QUESTION_SIX_INTEGER;
	}

	public static byte getQuestionElevenFloatA() {
		return QUESTION_ELEVEN_FLOAT_A;
	}

	public static byte getQuestionElevenFloatB() {
		return QUESTION_ELEVEN_FLOAT_B;
	}
	
	public static List<Integer> getQuestionTenDice() {
		return QUESTION_TEN_DICE;
	}

	public static Integer[] getRandomList() {
		return RANDOM_LIST;
	}
	
	public static String[] getQuestionEightPalindromes() {
		return QUESTION_EIGHT_PALINDROMES;
	}
	
	public static byte getFactorial() {
		return QUESTION_FOUR_FACTORIAL;
	}
	
	public static StringBuffer getName() {
		return QUESTION_THREE_NAME;
	}

	public static byte getQuestionFourteenNumber() {
		return QUESTION_FOURTEEN_NUMBER;
	}
}
