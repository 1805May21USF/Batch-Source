package com.revature.same;
import java.util.Comparator;

public class Employees implements Comparable<Employees> {
	
	private String name;
	private String department;
	private int age;
	
	public static final Comparator<Employees> AgeComparator = new Comparator<Employees>(){
        @Override
        public int compare(Employees arg0, Employees arg1) {
            return arg0.age - arg1.age;
        }   
    };
    
    public static final Comparator<Employees> NameComparator = new Comparator<Employees>(){
        @Override
        public int compare(Employees arg0, Employees arg1) {
            return arg0.name.compareTo(arg1.name);
        }
      
    };
    
    public static final Comparator<Employees> DepartmentComparator = new Comparator<Employees>(){
        @Override
        public int compare(Employees arg0, Employees arg1) {
            return arg0.name.compareTo(arg1.name);
        }
      
    };
	
	@Override
	public String toString() {
		return "\nName: " + name +
				"\nAge: " + age +
				"\nDepartment: " + department;
	}

	public Employees(String name, String department, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.age = age;
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
	public int compareTo(Employees arg0) {
		// TODO Auto-generated method stub
		return this.age - arg0.age;
	}

}
