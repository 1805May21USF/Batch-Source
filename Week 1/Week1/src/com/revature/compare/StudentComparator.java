package com.revature.compare;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	//Method 2 from notes- comparing GPAs
	@Override
	public int compare(Student arg0, Student arg1) {
		
		return (int) (arg0.getGpa() - arg1.getGpa());
	}

}
