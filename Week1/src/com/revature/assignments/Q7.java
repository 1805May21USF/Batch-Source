package com.revature.assignments;
import java.util.Comparator;

public class Q7 implements Comparator<Employee> {

	@Override
	public int compare(Employee one, Employee two) {
		// TODO Auto-generated method stub
		
		return one.getAge() - two.getAge();
	
	}
	

	
	
	
}
