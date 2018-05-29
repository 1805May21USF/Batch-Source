package corejava;

import java.util.Arrays;

public class Q2 {
	public static String Solution() {
		//first two numbers in fibonacci seq
		int fibFirst = 1;
		int fibSecond = 0;
		//how far we're going
		int places = 25;
		//current addition of previous two numbers in seq
		int fibCurrent;
		
		//the array storing the actual sequence
		int[] fibArray = new int[places];
		fibArray[0] = fibSecond;
		fibArray[1] = fibFirst;
		
		//calculating next number and storing it
		for(int i = 0; i < places - 2; i++) {
			fibCurrent = fibFirst + fibSecond;
			fibSecond = fibFirst;
			fibFirst = fibCurrent;
			fibArray[i + 2] = fibCurrent;
		}
		
		return Arrays.toString(fibArray);
	}
}
