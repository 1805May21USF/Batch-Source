package revature_homwork1;

import java.util.Comparator;

import com.revature.compare.Employee;

public class Q7 implements Comparator<Employee>  {
		
	
	
	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.name.compareTo(arg1.name) + arg0.dept.compareTo(arg1.dept) + arg0.age-arg1.age;
	}

}
