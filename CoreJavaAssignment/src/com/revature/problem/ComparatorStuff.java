package com.revature.problem;

import java.util.ArrayList;
import java.util.Collections;

import com.revature.compartors.AgeCompare;
import com.revature.compartors.DepartmentCompare;
import com.revature.compartors.NameCompare;

public class ComparatorStuff {
	public static void sort(ArrayList<Employee> emps) {
		System.out.println("Comparator Sort: ");
		//Before sorting
		printEmployees(emps, "Original");
		
		//By Name
		Collections.sort(emps, new NameCompare());
		printEmployees(emps, "By Name");
		
		//By Department
		Collections.sort(emps, new DepartmentCompare());
		printEmployees(emps, "By Department");
		
		//By Age
		Collections.sort(emps, new AgeCompare());
		printEmployees(emps, "By Age");
	}
	
	private static void printEmployees(ArrayList<Employee> emps, String msg) {
		System.out.print(msg + ": ");
		for (Employee emp : emps) {
			System.out.print(emp);
		}
		System.out.println();
	}
}


