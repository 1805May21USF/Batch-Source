/****************************************************
 * 		Name: Q07									*
 * 		Purpose: Sort two employees in an ArrayList *
 * 				 by their name, age, and department	*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import com.revature.storage.Employee;
import com.revature.storage.SortByAge;
import com.revature.storage.SortByDepartment;
import com.revature.storage.SortByName;
import java.util.ArrayList;
import java.util.Collections;

public class Q07 {
	public static void sortEmployees() {
		// Instantiates new employee objects to demonstrate Comparator
		Employee e1 = new Employee();
		e1.setName("John Doe");
		e1.setDepartment("Accounting");
		e1.setAge(27);
		
		Employee e2 = new Employee();
		e2.setName("Jane Doe");
		e2.setDepartment("Development");
		e2.setAge(25);
		
		// Puts the instantiated employees into an ArrayList
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		
		// Prints the unsorted list
		System.out.println("Unsorted ArrayList:");
		print(employees);
		// Prints the list  sorted by name
		System.out.println("Sorted by name:");
		Collections.sort(employees, new SortByName());
		print(employees);
		// Prints the list  sorted by department
		System.out.println("Sorted by department:");
		Collections.sort(employees, new SortByDepartment());
		print(employees);
		// Prints the list  sorted by age
		System.out.println("Sorted by age:");
		Collections.sort(employees, new SortByAge());
		print(employees);
	}
	
	// Prints the contents of an employee ArrayList
	private static void print(ArrayList<Employee> list) {
		for(Employee e : list) {
			System.out.println(e.toString());
		}
	}
}
