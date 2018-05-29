package com.revature.homework.week1.compare;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	//employee comparator implements employee class

	@Override
	public int compare(Employee arg0, Employee arg1) {
		//compare method that accepts two arguments
		return (int) (arg0.getAge() - arg1.getAge());
	}
	
}
