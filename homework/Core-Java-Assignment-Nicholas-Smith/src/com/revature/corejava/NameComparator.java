/**
 * 
 */
package com.revature.corejava;

import java.util.Comparator;

/**
 * @author Nicholas Smith
 *
 */
public class NameComparator implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2)
	{
		String name1 = o1.getName();
		String name2 = o2.getName();
		
		//sort by descending order
		return name2.compareTo(name1);
	}

}
