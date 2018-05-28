package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.Application;

public class ApplicationIdComparator implements Comparator<Application>{

	public int compare(Application o1, Application o2) {
		return o1.getID()-o2.getID();
	}

}
