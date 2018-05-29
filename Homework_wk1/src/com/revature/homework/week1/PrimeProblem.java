package com.revature.homework.week1;

import java.util.ArrayList;

public class PrimeProblem {
	//program that prints the prime member
	//between 1 to 100
	
	private ArrayList<Integer> numList;
	private int num;
	
	public PrimeProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Integer> getNumList() {
		return numList;
	}

	public void setNumList(ArrayList<Integer> numList) {
		this.numList = numList;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public PrimeProblem(ArrayList<Integer> numList, int num) {
		super();
		this.numList = numList;
		this.num = num;
	}

	public void printPrime(ArrayList<Integer> numList) {
		//this method accepts an arraylist of number
		//prints out the prime numbers from the list
		for(int i = 1; i <= 100; ++i) {
			numList.add(i);
			boolean check = true;
			for(int j = 2; j <= i/2; ++j) {
				if(i % j == 0) {
					check = false;
				}
			}
			if(check) {
				System.out.print(i + " ");
			}
		}
	}

}
