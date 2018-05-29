import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q7 {
	/*
	 * Q7. Sort two employees based on their name, department, and age using the
	 * Comparator interface.
	 */
	public static void main(String[] args) {
		System.out.println(
				"Q7. Sort two employees based on their name, department, and age using the Comparator interface.");
		Employee a = new Employee("Timmy Jones", "Retail", 23);
		Employee b = new Employee("James T. Kirk", "Manager", 29);
		Employee c = new Employee("Scottie Engineering", "Engineering", 40);
		ArrayList<Employee> arr = new ArrayList<>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		Collections.sort(arr, new EmployeeNameComparator());
		System.out.println("Employees Sorted by Name: ");
		for (Employee name : arr) {
			System.out.println("Employee: " + name.getName());
		}
		Collections.sort(arr, new EmployeeDptComparator());

		System.out.println("\nEmployees Sorted by Department: ");
		for (Employee dpt : arr) {
			System.out.println("Employee: " + dpt.getName() + " at " + dpt.getDpt());
		}
		Collections.sort(arr, new EmployeeAgeComparator());
		System.out.println("\nEmployees Sorted by Age: ");
		for (Employee age : arr) {
			System.out.println("Employee: " + age.getName() + " at " + age.getAge());
		}

	}

	public static Employee compare(Employee g1, Employee g2, Comparator<Employee> c) {
		if (c.compare(g1, g2) < 0)
			return g1;
		else
			return g2;
	}

}

class EmployeeNameComparator implements Comparator<Employee>, java.io.Serializable {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		String name0 = arg0.getName();
		String name1 = arg1.getName();
		return name0.compareTo(name1);
	}

}

class EmployeeDptComparator implements Comparator<Employee>, java.io.Serializable {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		String dept0 = arg0.getDpt();
		String dept1 = arg1.getDpt();
		return dept0.compareTo(dept1);
	}

}

class EmployeeAgeComparator implements Comparator<Employee>, java.io.Serializable {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		int age0 = arg0.getAge();
		int age1 = arg1.getAge();
		if (age0 < age1) {
			return -1;
		} else {
			return 1;
		}
	}

}

class Employee {
	private String name;
	private String dpt;
	private int age;

	public Employee() {
		super();
	}

	public Employee(String name, String dpt, int age) {
		this.name = name;
		this.dpt = dpt;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDpt() {
		return dpt;
	}

	public void setDpt(String dpt) {
		this.dpt = dpt;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
