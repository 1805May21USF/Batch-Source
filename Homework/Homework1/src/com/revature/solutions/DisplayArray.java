package com.revature.solutions;
import java.util.ArrayList;
public class DisplayArray {
	public static ArrayList<Integer> integers = new ArrayList<>();
	public static void init() {
		for(int i = 1; i<=10;i++) {
			integers.add(i);
		}
	}
	public static void printArrayList() {
		System.out.println(integers);
	}
	public static void addEvenOdd() {
		int countEven = 0;
		int countOdd = 0;
		for(Integer i:integers) {
			if(i%2==0) {
				countEven = countEven+i;
			}else {
				countOdd = countOdd + i;
			}
		}
		System.out.println("The sum of the even numbers is " + countEven);
		System.out.println("The sume of the odd numbers is " + countOdd);
	}
	public static void removePrime() {
		 ArrayList<Integer> integers2 = new ArrayList<>();
		// integers2 = integers;
		for(Integer i:integers) {
			if(i==1||i==2||i==3|i==5|i==7) {
				integers2.add(i);
			}
		}
		integers.removeAll(integers2);
		System.out.println(integers);
	}
}
