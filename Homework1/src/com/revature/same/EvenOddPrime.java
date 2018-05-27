package com.revature.same;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class EvenOddPrime {

	public EvenOddPrime() {
		// TODO Auto-generated constructor stub
		
		ArrayList<Integer> newList = new ArrayList<>();
		for(int i = 0; i <= 9; i++){
			newList.add(i+1);//[i] = i+1;
		}
		
		System.out.println(newList);
		int even = 0; int odd = 0;
		for(Integer x : newList) {
			if(x % 2 == 0)
				even += x;
			else
				odd += x;
			
		}
		
		ArrayList<Integer> notPrime = new ArrayList<>();
		for(int x : newList){
			boolean isPr = isPr(x);
			if(!isPr)
				notPrime.add(x);	
		}
		
		System.out.println("The sum of odd numbers from 1 to 10 is " + odd);
		System.out.println("The sum of even numbers from 1 to 10 is " + even);
		System.out.println("The non-prime numbers in 1 to 10 are " + notPrime);
	}
	
	public static boolean isPr(int number) {
        if (number < 2) 
        	return false;
        else if (number == 2) 
        	return true;
        else if (number % 2 == 0) 
        	return false;
        for (int i = 3; i * i <= number; i += 2)
            if (number % i == 0) 
            	return false;
        return true;
	}
}
