package javaCore;

import java.util.*;

public class q8Palindrome {
	public static void arraysNStuff() {
	ArrayList<String> al = new ArrayList<String>(11);
    al.add(0,"karan");
    al.add(1,"madam");
    al.add(2,"tom");
    al.add(3,"civic");
    al.add(4,"radar");
    al.add(5,"jimmy");
    al.add(6, "kayak");
    al.add(7, "john");
    al.add(8, "refer");
    al.add(9, "billy");
    al.add(10, "did");
    
   
    List<Integer> numbers = new ArrayList<Integer>();
    int count = 0;
    int start = 0;
    int end = al.size -1;
    
    for (int i = start; i <= finish; i++) { 
    	numbers.add(i); if(isPalinDrome(i)){ count++; }
    	} 
    System.out.println("[Start value: " + start + "] [End value: " + finish + "] "
    		+ "[Number of PalinDromes: " + count + "]"); }
	 public static boolean isPalinDrome(int n)
	 { String str = Integer.toString(n); 
	 String reverse = new StringBuilder(str).reverse().toString();
	 return str.equals(reverse); } 

    
   /* int i1 = 0;
    int i2 = .length - 1;
    while (i2 > i1) {
        if (word[i1] != word[i2]) {
            return false;
        }
        ++i1;
        --i2;
    }
    return true;
*/
	}
	}
