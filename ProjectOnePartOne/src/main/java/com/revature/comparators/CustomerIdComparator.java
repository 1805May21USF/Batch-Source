package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.Customer;
import com.revature.beans.User;

public class CustomerIdComparator implements Comparator<Customer>{


	@Override
	public int compare(Customer arg0, Customer arg1) {
		return arg0.getID()-arg1.getID();
	}
}
