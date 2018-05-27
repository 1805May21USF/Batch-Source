package com.revature.corejava;

public class Q7Employee 
{
	
	private	String name;
	private String department;
	private int age;
	
	public Q7Employee(String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	
	
	public String getName() {
		return name;
	}



	public String getDepartment() {
		return department;
	}



	public int getAge() {
		return age;
	}



	@Override
	public String toString()
	{
		return "\n"+this.name+","+this.department+","+this.age;
	}

}
