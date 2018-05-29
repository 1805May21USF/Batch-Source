package com.revature.beans;

import java.util.Comparator;

public class CompareDepartment implements Comparator<Employee> {
	
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}
