package corejava;

public class Q7 {
	public static void Solution() {
		//our employees
		Employee emp1 = new Employee("Bill", "Billiards", 30);
		Employee emp2 = new Employee("Will", "Williards", 40);
		
		//the array to sort
		Employee[] empArr = {emp1, emp2};
		
		//call the comparators
		EmployeeAgeComparator ageComp = new EmployeeAgeComparator();
		EmployeeDeptComparator deptComp = new EmployeeDeptComparator();
		EmployeeNameComparator nameComp = new EmployeeNameComparator();
		
		//running the comparisons
		if (ageComp.compare(emp1, emp2) == 1) { 
			empArr[0] = emp2;
			empArr[1] = emp1; }
		
		System.out.println(empArr[0].name + "'s age comes before " + empArr[1].name);
		
		if (deptComp.compare(emp1, emp2) == 1) {
			empArr[0] = emp2;
			empArr[1] = emp1;
		}
		
		System.out.println(empArr[0].name + "'s department comes before " + empArr[1].name);
		
		if (nameComp.compare(emp1, emp2) == 1) {
			empArr[0] = emp2;
			empArr[1] = emp1;
		};
		
		System.out.println(empArr[0].name + "'s name comes before " + empArr[1].name);
	}
}
