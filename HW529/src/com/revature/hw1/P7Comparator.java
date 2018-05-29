package com.revature.hw1;

import java.util.ArrayList;
import java.util.Comparator;

public class P7Comparator implements Comparator<Employee>{
	//Employee emp1 = new Employee("John", "Sales", 60);
	//Employee emp2 = new Employee("Steph", "Not doin Shit", 3);
	
/*	public int compareN(Employee a, Employee b)
	{

	   
	}
	public int compareD(Employee a, Employee b)
	{
c 
	}
	public int compareA(Employee a, Employee b)
	{
		return (int)a.getAge()-b.getAge();
	   
	}*/

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
	//int i = compare(emp1, emp2);
}
