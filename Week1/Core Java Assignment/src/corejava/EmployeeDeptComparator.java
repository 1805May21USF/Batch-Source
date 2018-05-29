package corejava;

import java.util.Comparator;

public class EmployeeDeptComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp0, Employee emp1) {
		if (emp0.department.charAt(0) < emp1.department.charAt(1)) { return 0; }
		return 1;
	}

}
