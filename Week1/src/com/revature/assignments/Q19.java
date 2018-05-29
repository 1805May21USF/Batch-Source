package com.revature.assignments;
import java.util.ArrayList;
import java.util.Iterator;

public class Q19 {
	
	ArrayList<Integer> integerList = new ArrayList<Integer>();
	
	//initialize the list
	public void initList() {
		
		for(int i = 1; i <=10; i++) {
			integerList.add(i);
		}
	}
	
	//print the list
	public void printList() {
		for(Integer item : integerList) {
			System.out.print(item);
		}
		System.out.println();
	}
	
	//Add up all of the evens
	public void addEvens() {
		Integer total = 0;
		for(Integer item : integerList) {
			if(item % 2 == 0) {
				total += item;
			}
		}
		System.out.println(total);
	}
	
	//add up all of the odds
	public void addOdds() {
		Integer total = 0;
		for(Integer item : integerList) {
			if(item % 2 != 0) {
				total += item;
			}
		}
		System.out.println(total);
	}
	
	//remove primes and print
	public void removePrimes() {
		Iterator<Integer> it = integerList.iterator();
		Integer current = it.next();
		Outer: while(it.hasNext()){
			int i;
			current = it.next();
			 for(i = 2; i < current ; i++) {
					if(current % i == 0) {
						
						continue Outer;
					}
			 }
			 if(i+1 != current) {
				 it.remove();
			 }
			}
	}
	
	public void runQ19() {
		initList();
		printList();
		addEvens();
		addOdds();
		removePrimes();
		printList();
	}
	
	
}
