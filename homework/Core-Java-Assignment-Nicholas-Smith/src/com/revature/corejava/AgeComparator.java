/**
 * 
 */
package com.revature.corejava;

import java.util.Comparator;

/**
 * @author Nicholas Smith
 *
 */
public class AgeComparator implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2)
	{
		//sort by descending order
		return o2.getAge() - o1.getAge();
	}

}
