package com.revature.corejava;

import java.util.ArrayList;

public class Q19 
{
	private ArrayList<Integer> initialArrayList;
	
	//Builds the ArrayList of Integer numbers 1-10
	public Q19()
	{
		this.initialArrayList = new ArrayList<>();
		for(int i = 1; i<=10; i++)
		{
			this.initialArrayList.add(i);
		}
	}
	
	//Outputs the ArrayList initialArrayList
	public void displayInitialArrayList()
	{
		System.out.println(this.initialArrayList.toString());
	}
	
	//Goes through the initialArrayList and adds up all even numbers. returns the sum
	public int addAllEvensInArrayList()
	{
		int evenIntsTotal = 0;
		for(int intTemp: this.initialArrayList)
		{
			if(intTemp % 2 == 0)
			{
				evenIntsTotal = evenIntsTotal + intTemp;
			}
		}
		return evenIntsTotal;
		
	}
	
	//Goes through the initialArrayList and adds up all the odd numbers. returns the sum
	public int addAllOddsInArrayList()
	{
		int oddIntsTotal = 0;
		for(int intTemp: this.initialArrayList)
		{
			if(intTemp % 2 != 0)
			{
				oddIntsTotal = oddIntsTotal + intTemp;
			}
		}
		return oddIntsTotal;
	}
	
	//Goes through the initialArrayList and removes and prime numbers. returns the ArrayList
	public String removeAllPrimesInArrayList()
	{
		
		
		Q9 myQ9 = new Q9();
		for(int i = 0; i <= this.initialArrayList.size()-1; i++)
		{
			if((myQ9.isPrime(this.initialArrayList.get(i))))
			{
				this.initialArrayList.remove(i);
			}
		}
		return this.initialArrayList.toString();
	}
}
