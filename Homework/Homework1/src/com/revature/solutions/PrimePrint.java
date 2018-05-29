package com.revature.solutions;
import java.util.ArrayList;
public class PrimePrint {
	public static void evenPrint() {
		ArrayList<Integer> numberList = new ArrayList<>();
		for(int i = 1;i<=100;i++) {
			numberList.add(i);
			
			for(int j =2;j<=i;j++) {
				if(j==i||i==1) {
					System.out.println(i + " is a prime");
					break;
				}
				if(i%j==0){
					break;
				}
			}
		}
	}
	
}
