package com.revature.impl;

public class CheckPassword {

	public boolean CheckPasswordIfValid(String str) {
		if (str.length() < 5 || str.length() > 15) {
			return false;
		} else {
			return true;
		}
	}
}
