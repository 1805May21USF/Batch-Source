package com.revature.util;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.department.compareTo(o2.department);
	}
	
}
