package com.revature.homeworks;

import java.util.Comparator;

public class sortByDepartment implements Comparator<Employee> {
	
	public int compareTo(Employee arg0, Employee arg1) {
		return arg0.getDepartment().compareTo(arg1.getDepartment());
	}

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
