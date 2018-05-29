package com.revature.solutions;
import java.util.ArrayList;
public class EvenPrinting {
	public static ArrayList<Integer> even = new ArrayList<>();
	public static void evenPrint() {
		for(int i = 1;i<=100;i++) {
			even.add(i);
		}
		for(int i:even) {
			if((i&1)==0) {
				System.out.print(i + " ");
			}
		}
	}
}
