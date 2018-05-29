package javaCore;

import java.util.*;

public class q9Prime {
	public static void myArray() {
		ArrayList<Integer> myArrayList = new ArrayList<Integer>(100);
		for (int i=1; i<100; i++) {
			myArrayList.add(i);
			int n = i;
			//boolean r = myPrimeCheck(n);
			 if(myPrimeCheck(n)) System.out.println(n);
		}
	}
	public static boolean myPrimeCheck(int n) {
		    if(n < 2) return false;
		    if(n == 2 || n == 3) return true;
		    if(n%2 == 0 || n%3 == 0) return false;
		    long sqrtN = (long)Math.sqrt(n)+1;
		    for(long i = 6L; i <= sqrtN; i += 6) {
		        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
		    }
		    return true;
}
}