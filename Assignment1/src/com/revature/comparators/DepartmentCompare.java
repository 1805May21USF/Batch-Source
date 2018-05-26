package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.Problem7;

public class DepartmentCompare implements Comparator<Problem7>{
	@Override
	public int compare(Problem7 o1, Problem7 o2) {		
		return o1.getDepartment().compareTo(o2.getDepartment());
	}	
}
