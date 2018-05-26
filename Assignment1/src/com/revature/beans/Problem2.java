package com.revature.beans;

public class Problem2 {
	
	public static String returnFirst25(){
		StringBuilder sb = new StringBuilder("[");
		int[] returnNumbers = first25Fib();
		for(int i = 0; i < returnNumbers.length; i++){
			
			if(i == returnNumbers.length -1){
				sb.append(returnNumbers[i] + "]");
			}else{
				sb.append(returnNumbers[i] + ",");
			}
		}		
		return sb.toString();
	}
	
	private static int[] first25Fib(){
		int[] iArray = new int[25];
		iArray[0] = 0;
		iArray[1] = 1;	
		int a = 0;
		int b = 1;
		
		for(int i = 2; i < 25; i++){
			iArray[i] = a + b;
			a = b;
			b = iArray[i];			
		}
		return iArray;
	}
}
