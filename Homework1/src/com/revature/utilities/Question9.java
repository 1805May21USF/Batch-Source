package com.revature.utilities;

import java.util.ArrayList;
import java.util.List;

public class Question9 {
 public static List<Integer> Q9() {
	List<Integer> primeNums = new ArrayList<Integer>();
	
	for (int index = 2; index < 100; index++ ) {
		
		boolean isPrime = true;
		
		for(int i =2; i< index; i++)
			if(index%i == 0) isPrime = false;
		
		if(isPrime)
		{
			System.out.print (index + " "); 
            primeNums.add(index);
		}
	}  return primeNums;

	 
	 
 }

private static String toStrings(int index) {
	// TODO Auto-generated method stub
	return null;
}
}
