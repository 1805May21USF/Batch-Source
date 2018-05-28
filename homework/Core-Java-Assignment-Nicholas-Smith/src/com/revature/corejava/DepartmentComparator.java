/**
 * 
 */
package com.revature.corejava;

import java.util.Comparator;

/**
 * @author Nicholas Smith
 *
 */
public class DepartmentComparator implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2)
	{
		String department1 = o1.getDepartment();
		String department2 = o2.getDepartment();
		
		//sort by descending order
		return department2.compareTo(department1);
	}

}
