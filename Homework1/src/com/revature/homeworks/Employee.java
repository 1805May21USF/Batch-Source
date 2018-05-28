package com.revature.homeworks;

import java.util.Arrays;


//employee class that has all the varaibles, setters and getters, constructors, and toString method
public class Employee 
{
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	private String name;
	
	private String department;
	
	private int age;

	//Constructor
	public Employee(String name, String department, int age) 
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public Employee()
	{
		
	}
		
	//Setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//prints Employee info
	@Override
	public String toString() {
		return "Employee [Name=" + name + ", Department=" + department + ", Age="
				+ age + "]";
	}
	
	
	
	//run method that is called by the main
	public void run()
	{
		
		//New array of employees
		Employee employee[] = new Employee[2];
		
		
		//Instantiates two new employee objects
		employee[0] = new Employee();
		employee[0].setName("Marcus");
		employee[0].setAge(21);
		employee[0].setDepartment("Software");
		
		employee[1] = new Employee();
		employee[1].setName("Adegboyega");
		employee[1].setAge(22);
		employee[1].setDepartment("Zoology");
		
		System.out.println("Question Seven: " + newLine + "-----------------------------");
		
		
		//calls the array.sort whihc uses the sorting methods defined by the class that implement comparator and then prints out these details
		Arrays.sort(employee, new sortByName());
		System.out.println("Employee sort by Name: ");
		for (int i = 0; i < employee.length; i++)
		{
			System.out.println(employee[i].getName() + "\t"
					+ employee[i].getAge() + "\t" + employee[i].getDepartment());
		}
		
		
		System.out.println();
		Arrays.sort(employee, new sortByAge());
		System.out.println("Employee sort by Age: ");
		for (int i = 0; i < employee.length; i++)
		{
			System.out.println(employee[i].getName() + "\t"
					+ employee[i].getAge()+ "\t" + employee[i].getDepartment());
		}
		
		System.out.println();
		Arrays.sort(employee, new sortByDepartment());
		System.out.println("Employee sort by Department: ");
		for (int i = 0; i < employee.length; i++)
		{
			System.out.println(employee[i].getName() + "\t"
					+ employee[i].getAge()+ "\t" + employee[i].getDepartment());
		}
		
		System.out.println("-----------------------------");
		System.out.println();

	}
	
	
}


