/****************************************************
 * 		Name: SortByAge									*
 * 		Purpose: Compares Employee objects based on *
 * 				 the age variable				    *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee>{
	// Overrides the compare method in Comparator
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getAge() - e2.getAge();
	}

}
