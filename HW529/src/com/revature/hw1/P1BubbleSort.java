package com.revature.hw1;

public class P1BubbleSort {
	public static int[] bubbleSort(/*int[] array*/) {
		int[] array = {5, 6, 6, 7, 9, 3};
		int placeholder = 0;
		for(int k = 0; k < array.length; k++) {
			for(int i = 0; i < array.length-1; i++) {
				if (array[i]>array[i+1]) {
					placeholder = array[i];
					array[i] = array[i+1];
					array[i+1] = placeholder;
				}
			}
		}
		//System.out.println(array.toString());
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println("");
		return array;
	}
	

/*	public static void main(String[] args) {
	}*/
}
