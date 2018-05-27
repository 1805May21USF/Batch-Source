package com.revature.corejava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q7
{
	//Had to create a separate file to make the class for this Question. Q7Employee.java
	private List<Q7Employee> employees;
			
	public Q7()
	{
		List<Q7Employee> employees = new ArrayList<>();
		employees.add(new Q7Employee("John Doe", "Science", 41));
		employees.add(new Q7Employee("Lilian Smart","Human Resources",32));
		this.employees = employees;
	}
	
	public void sortOnName()
	{
		this.employees.sort(Comparator.comparing(Q7Employee::getName));
	}
	
	public void sortOnDepartment()
	{
		this.employees.sort(Comparator.comparing(Q7Employee::getDepartment));
	}
	
	public void sortOnAge()
	{
		this.employees.sort(Comparator.comparing(Q7Employee::getAge));
	}
	
	public void displayListOfEmployees()
	{
		System.out.println(this.employees);
	}

}