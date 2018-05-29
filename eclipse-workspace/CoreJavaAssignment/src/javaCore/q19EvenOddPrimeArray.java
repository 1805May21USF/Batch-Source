package javaCore;

import java.util.*;
import java.lang.*;

public class q19EvenOddPrimeArray {
	
	public static void myArray() {
		int evenSum = 0;
		int oddSum = 0;
		ArrayList<Integer> myArrayList = new ArrayList<Integer>(10);
		for (int i=1; i<10; i++) {
			myArrayList.add(i);
			int n = i;
			// if(myPrimeCheck(n)) System.out.println(n);
			if((n / 2)*2==n){
				evenSum = evenSum + i;
		    	
			}else{
				oddSum = oddSum + i;
			}
		}
		System.out.println(evenSum);
    	System.out.println(oddSum);
	}
	
public static void checkPrime() {
	ArrayList<Integer> myArrayListToo = new ArrayList<Integer>(10);
	for (int j=1; j<11; j++) {
		myArrayListToo.add(j);
		/*int n = j;
    if(n < 2) n = n;
    if(n == 2 || n == 3) //myArrayListToo.remove(n);
    if(n%2 == 0 || n%3 == 0) n = n;
    long sqrtN = (long)Math.sqrt(n)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
        if(n%(i-1) == 0 || n%(i+1) == 0) n = n;
    }*/
    Iterator k = myArrayListToo.iterator();
    while (k.hasNext()) {
       Object s = k.next();
       if(j == 2) k.remove();
       if(j == 3) k.remove();
       if(j == 5) k.remove();
       if(j == 7) k.remove();
       
       
       }
    }    System.out.println(myArrayListToo.toString());
    }
}