package corejava;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp0, Employee emp1) {
		if (emp0.name.charAt(0) < emp1.name.charAt(0)) { return 0; }
		return 1;
	}

}
