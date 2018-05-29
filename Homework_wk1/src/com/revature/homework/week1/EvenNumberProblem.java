package com.revature.homework.week1;

public class EvenNumberProblem {
	//program accepts an array of numbers and
	//prints out the even numbers
	
	private int[] arr;
	
	
	public EvenNumberProblem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EvenNumberProblem(int[] arr) {
		super();
		this.arr = arr;
	}


	public int[] getArr() {
		return arr;
	}


	public void setArr(int[] arr) {
		this.arr = arr;
	}


	public void printEven(int[] arr) {
		//this method accepts an array of integers and
		//prints out the even numbers
		for(int i = 0; i < 100; ++i) {
			arr[i] = i+1;
		}
		System.out.println("Here are the even numbers between 1-100: ");
		for(int i: arr) {
			if(i%2 == 0)
				System.out.print(i + " ");
		}
	}


}
