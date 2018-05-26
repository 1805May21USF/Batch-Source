/****************************************************
 * 		Name: SortByDepartmnet						*
 * 		Purpose: Compares Employee objects based on *
 * 				 the department variable			*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

import java.util.Comparator;

public class SortByDepartment implements Comparator<Employee>{
	// Overrides the compare method in Comparator
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}
