package com.revature.questions;

import java.util.ArrayList;
import java.util.Collections;

import com.revature.util.*;

public class QuestionSeven {
	
	public QuestionSeven() {
		
	}
	/*
	 * Check the comparator classes in com.revature.util.
	 * They should probably be in com.revature.qseven.
	 * 
	 */
	public void run(ArrayList<Employee> e) {
		System.out.println("Sorted by name:");
		ArrayList<Employee> b = e;
		Collections.sort(b, new EmployeeNameComparator());
		System.out.println( b.toString() );
		
		System.out.println("Sorted by department:");
		ArrayList<Employee> c = e;
		Collections.sort(c, new EmployeeDepartmentComparator());
		System.out.println( c.toString() );
		
		System.out.println("Sorted by age:");
		ArrayList<Employee> f = e;
		Collections.sort(f, new EmployeeAgeComparator());
		System.out.println( f.toString() );
	}

}
