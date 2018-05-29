package com.revature.solutions;

public class AbstractExtension extends stringCheck {

	@Override
	boolean upperCheck(String str) {
		if(str == str.toLowerCase()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	void toInt(String str) {
		int temp = Integer.parseInt(str);
		temp = temp + 10;
		System.out.println(temp);
		
	}

}
