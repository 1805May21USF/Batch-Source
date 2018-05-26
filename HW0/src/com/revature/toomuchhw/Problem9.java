package com.revature.toomuchhw;

import java.util.ArrayList;

//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
public class Problem9 {
	ArrayList<Integer> storage = new ArrayList<Integer>();
	
	public void printPrime(){
		for(int i = 1; i<101; i++) {
			storage.add(i);
		}
		
		for(int n:storage) {
			if(checkPrime(n))
			{
				System.out.println(n);
			}
		}
	}
	
	public boolean checkPrime(int p) {
		for(int i = 2; i <= p/2; i++) {
			if(p==1||p==2||p==3) {
				return true;
			}
			else if((p%i)==0) {
				return false;
			}
		}
		return true;
	}

}
