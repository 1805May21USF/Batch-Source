package com.revature.hw1;

import java.util.Comparator;

public class P7Comparator3 implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getDept().compareTo(o2.getDept());
		   
	}
	

}
