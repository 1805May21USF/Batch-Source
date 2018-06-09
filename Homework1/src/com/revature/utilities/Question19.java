package com.revature.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class Question19 {
 
	public static  void Q19() {
		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for ( int i = 0; i < 10 ;i++) {
			arr.add(i+1);			
		}
		System.out.println(arr);
		
		int evenTotal = 0;
		int oddTotal = 0;
		
		for (int i = 0; i < arr.size();i++) {
			
			if(arr.get(i) % 2 ==0) {
				
				evenTotal += arr.get(i);
			}
			else {
				
				oddTotal += arr.get(i);
			}
		}
		System.out.println(evenTotal);
		System.out.println(oddTotal);
	
		ArrayList<Integer> definitelyNotPrime = new ArrayList<>();
		for(int x : arr) {
			
			boolean dfprime = isPrime(x);
			if(!dfprime)
				definitelyNotPrime.add(x);
			}
	System.out.println(definitelyNotPrime);
	}
		
		  
		
	
	
public static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return false;
    return true;
}

}
	

