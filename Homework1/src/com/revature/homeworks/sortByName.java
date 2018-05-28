package com.revature.homeworks;

import java.util.Comparator;

public class sortByName implements Comparator<Employee>{
	
	public int compareTo(Employee arg0, Employee arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
