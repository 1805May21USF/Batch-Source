package com.revature.questions;

import java.util.ArrayList;
import java.util.Vector;

public class QuestionNineteen {

	public QuestionNineteen() {
		
	}
	
	public void run() {
		Vector<Integer> numbers = new Vector<Integer>();
		
		for(int i = 0;i<=10;i++) {
			numbers.add(i);
		}
		
		int evensum = 0;
		for(Integer i:numbers) {
			if(i%2==0) {
				evensum+=i;
			}
		}
		System.out.println(evensum);
		
		int oddsum = 0;
			for(Integer i:numbers) {
				if(i%2!=0) {
					oddsum+=i;
				}
			}
		System.out.println(oddsum);
		
		Vector<Integer> primes = new Vector<Integer>();
		for(Integer i:numbers) {
			boolean isPrime = true;
			for(int j = 2;j<i;j++) {
				if(i%j == 0) {
					isPrime = false;
				}
			}
			if(isPrime) {
				primes.add(i);
			}
		}
		
		
		for(int i = 0;i<primes.size();i++) {
			for(int j = 0;j<numbers.size();j++) {
				if (primes.get(i).equals(numbers.get(j))) {
					numbers.remove(j);
				}
			}
		}
		
		System.out.println(numbers.toString());
		
		
	}
}
