package com.revature.same;
import java.util.Comparator;

/*
 * A class to compare employees given their name, age, and department
 */
public class Employees implements Comparable<Employees> {
	
	private String name;
	private String department;
	private int age;
	
	/*
	 * compares two employees using their ages
	 * @Param none
	 * @return return the difference in age
	 */
	public static final Comparator<Employees> AgeComparator = new Comparator<Employees>(){
        @Override
        public int compare(Employees arg0, Employees arg1) {
            return arg0.age - arg1.age;
        }   
    };
    
    /*
	 * compares two employees using their Names
	 * @Param none
	 * @return return the difference in name
	 */
    public static final Comparator<Employees> NameComparator = new Comparator<Employees>(){
        @Override
        public int compare(Employees arg0, Employees arg1) {
            return arg0.name.compareTo(arg1.name);
        }
      
    };
    
    /*
	 * compares two employees using their departments
	 * @Param none
	 * @return return the difference in departments
	 */
    public static final Comparator<Employees> DepartmentComparator = new Comparator<Employees>(){
        @Override
        public int compare(Employees arg0, Employees arg1) {
            return arg0.name.compareTo(arg1.name);
        }
      
    };
	
    /*
	 * Prints the name, age, and department of an Employee
	 * @Param none
	 * @return returns a string representation of an Employee
	 */
	@Override
	public String toString() {
		return "\nName: " + name +
				"\nAge: " + age +
				"\nDepartment: " + department;
	}

	/*
	 * A constructor for the Employees class
	 * @Param name: the name of an Employee
	 * @Param department: the department of an employee
	 * @Param age: the age of an Employee
	 * @return 
	 */
	public Employees(String name, String department, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.age = age;
	}

	/*
	 * A method to get the name of an employee
	 * @Param none
	 * @return returns the name of a give employee
	 */
	public String getName() {
		return name;
	}

	/*
	 * A method that sets the name of an employee
	 * @Param none
	 * @return returns the name of a given employee
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * A method to get the department of an employee
	 * @Param none
	 * @return returns the department of a given employee
	 */
	public String getDepartment() {
		return department;
	}

	/*
	 * A method that sets the department of an employee
	 * @Param none
	 * @return returns the department of a given employee
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/*
	 * A method to get the age of an employee
	 * @Param none
	 * @return returns the age of a given employee
	 */
	public int getAge() {
		return age;
	}

	/*
	 * A method that sets the age of an employee
	 * @Param none
	 * @return returns the age of a given employee
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * overrides and implements the comparTo method from comparable
	 */
	@Override
	public int compareTo(Employees arg0) {
		// TODO Auto-generated method stub
		return this.age - arg0.age;
	}

}
