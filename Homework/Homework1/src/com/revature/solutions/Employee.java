package com.revature.solutions;
import java.util.Comparator;
public class Employee implements Comparator<Employee> {
	private String name;
	private String department;
	private int age;

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public static final Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee a,Employee b) {
			return a.name.compareTo(b.name);
		}
	};
	
	public static final Comparator<Employee> departmentComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee a,Employee b) {
			return a.department.compareTo(b.department);
		}
	};
	
	public static final Comparator<Employee> ageComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee a,Employee b) {
			return a.age-b.age;
		}
	};

	@Override
	public String toString() {
		return "name " +name +"\n" + "department " + department + "\n" + "age " +age; 
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



	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}

}
