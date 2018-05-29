package com.revature.assignments;
import java.util.ArrayList;

public class Q9 {
	
	ArrayList<Integer> primes = new ArrayList<Integer>();
	
	//create an array of integers. 
	public void addIntegers() {
		for(int i = 1; i <=100 ; i++) {
			primes.add(i);
		}
	}
		
	//print all of the number in the primes arrayList.
	public void print() {
		Outer: for(int item : primes) {
			 for(int i = 2; i < item; i++) {
				 //if the number is divisible by i then continue the loop, therefore not printing the item.
				if(item % i == 0) {
					continue Outer;
				}
			}
			System.out.println(item);
		}
	
	}

}
