package com.revature.beans;

/*Q7. Sort two employees based on their name, department, and age using the Comparator interface.
 * uses comparators in com.revature.comparators*/
public class Problem7 {
	private String name;
	private String department;
	private int age;
	
	public Problem7(String name, String department, int age){
		setName(name);
		setDepartment(department);
		setAge(age);
	}

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

}
