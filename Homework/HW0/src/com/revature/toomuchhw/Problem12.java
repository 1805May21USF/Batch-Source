package com.revature.toomuchhw;

import java.util.ArrayList;

//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all
//the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
public class Problem12 {
	ArrayList<Integer> storage = new ArrayList<Integer>();
	
	public void printEven(){
		for(int i = 1; i<101; i++) {
			storage.add(i);
		}
		
		for(int n:storage) {
			if(n%2 == 0) {
				System.out.print(n+" ");
			}
		}
	}
}
