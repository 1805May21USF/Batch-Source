package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.User;

public class UserUsernameComparator implements Comparator<User> {

	@Override
	public int compare(User arg0, User arg1) {
		return arg0.getUserName().compareTo(arg1.getUserName());
	}

}
