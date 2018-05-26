/****************************************************
 * 		Name: SortByName							*
 * 		Purpose: Compares Employee objects based on *
 * 				 the name variable					*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>{
	// Overrides the compare method in Comparator
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}

}
