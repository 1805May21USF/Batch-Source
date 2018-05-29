package com.revature.hw1;

import java.util.Comparator;

public class P7Comparator2 implements Comparator<Employee>{
	@Override
	public int compare(Employee a, Employee b)
	{
		return (int)a.getAge()-b.getAge();
	   
	}
}
