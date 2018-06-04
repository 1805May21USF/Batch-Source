package homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Q7 extends Employee
{
	
	//Sort two employees based on their name, department, and age using the Comparator interface.
	public Q7(String name, String department, int age) {
		super(name, department, age);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		Employee emp1 = new Employee("Tom", "Math", 20);
		Employee emp2 = new Employee("Rocky", "Dermatologist ", 32);
		Employee emp3 = new Employee("Nichols", " SoftwareEngineer", 24);
		Employee emp4 = new Employee("celney", "Nursing", 25);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		
			
		
		
		// UNSORTED
		System.out.println("*************** Unsorted ******************");
		
		for(Employee emp: list)
			System.out.println(emp);
		System.out.println();
		
		// SORTED BY NAME
		Collections.sort( list, new NameComparator() );
		
		System.out.println("*************** By Name ******************");
		for(Employee emp: list)
			System.out.println(emp);
		System.out.println();
		
		// SORTED BY DEPARTMENT
		Collections.sort( list, new DepartmentComparator() );
		System.out.println("*************** By Dept ******************");
		for(Employee emp: list)
			System.out.println(emp);
		System.out.println();
		
		
		// SORTED BY AGE
		Collections.sort( list, new AgeComparator() );
		System.out.println("*************** By Age ******************");
		for(Employee emp: list)
			System.out.println(emp);
		
		
	}
}