package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.Problem7;

public class AgeCompare implements Comparator<Problem7>{

	@Override
	public int compare(Problem7 o1, Problem7 o2) {
		return o1.getAge() - o2.getAge();
	}
	
}