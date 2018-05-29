package com.revature.homework.week1;

import java.util.ArrayList;

public class IntegerProblem {
	//program accepts an arraylist
	//adds the even numbers
	//adds the odd numbers
	//removes the prime numbers
	
	private ArrayList<Integer> list;
	private int n;
	
	
	public IntegerProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IntegerProblem(ArrayList<Integer> list, int n) {
		super();
		this.list = list;
		this.n= n;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}

	public void setN(int n) {
		this.n= n;
	}
	
	public int getN(int n) {
		return n;
	}
	public void printList(ArrayList<Integer> list) {
		//removes the primes and
		//prints the arraylist
		for(int i = 1; i <= 10; i++) {
			list.add(i);
			boolean check = true;
			for(int j = 2; 2*j <= i; ++j) {
				if(i % j == 0) {
					check = false;
				}
			}
			if(!(check)) {
				System.out.print(i + " ");;
			}
		}
		System.out.println();
	}
	
	public int addEven(ArrayList<Integer> list) {
		//finds the even numbers and
		//returns the total of all the even numbers
		int totalEven = 0;
		for(int i = 0; i < list.size(); i++) {
			if(i % 2 == 0) {
				totalEven = totalEven + i;
			}
		}
		return totalEven;
	}
	
	public int addOdd(ArrayList<Integer> list) {
		//finds the odd numbers and
		//returns the total of all odd numbers
		int totalOdd = 0;
		for(int i = 0; i < list.size(); i++) {
			if((i % 2) != 0) {
				totalOdd = totalOdd + i;
			}
		}
		return totalOdd;
		
	}

	
}
