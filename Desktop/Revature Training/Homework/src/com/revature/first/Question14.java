package com.revature.first;

import java.lang.Math;
import java.util.Date;

public class Question14 {
	
	public int switchCase(int v) 
	{
		switch(v) 
		{
		case 1: System.out.println(Math.sqrt(169));
		break;
		case 2: System.out.println(new Date());
		break;
		case 3: 
			String first = "I am learning Core Java";
			String[] stringArr = new String[5];
			stringArr[0] = first.substring(0,1);
			stringArr[1] = first.substring(2,4);
			stringArr[2] = first.substring(5,13);
			stringArr[3] = first.substring(14,18);
			stringArr[4] = first.substring(19,23);
			
			for(String stuff : stringArr) 
			{
				System.out.println(stuff);
			}
		break;
		}
		
		return v;
	}

}
