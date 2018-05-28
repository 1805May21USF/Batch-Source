package com.revature.homeworks;

import java.util.Comparator;

public class sortByAge implements Comparator<Employee> {
	
	public int compare(Employee arg0, Employee arg1) {
		return arg1.getAge() - arg0.getAge();
	}

}
