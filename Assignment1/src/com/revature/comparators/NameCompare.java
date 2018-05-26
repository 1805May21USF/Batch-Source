package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.Problem7;

public class NameCompare implements Comparator<Problem7>{

	@Override
	public int compare(Problem7 arg0, Problem7 arg1) {	
		return arg0.getName().compareTo(arg1.getName());
	}
	
}