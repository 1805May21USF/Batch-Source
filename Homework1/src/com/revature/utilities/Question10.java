package com.revature.utilities;

public class Question10 {

	public static  int Q10() {
		
		int a,b,c,small;
		
		a = 10;
		b=20;
		c=30;
		small = (a<b&& a < c) ? a:(b<c)?b:c;
		
		
	return small;
		
	}
}
