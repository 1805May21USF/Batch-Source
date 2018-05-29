package com.revature.first;

import java.util.List;

public class Question19 {
	
	public static int sum(List<Integer> list) 
	{
		int sum =0;
		for(int i : list) 
		{
			sum += i;
		}
		return sum;
	}

}
