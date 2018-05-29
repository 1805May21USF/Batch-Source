package corejava;
import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee emp0, Employee emp1) {
		if (emp0.age < emp1.age) { return 0; } 
		return 1;
	}

}
