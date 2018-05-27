package com.revature.same;
import java.util.*;

public class SwitchCase {

	public SwitchCase() {
		// TODO Auto-generated constructor stub
		switchcase();
	}
	
	public static void switchcase(){
		for(int i = 0; i <=3; i++) {
			switch(i) {
			case 1: System.out.println(Math.sqrt(4));
					break;
			case 2: System.out.println(new Date());
					break;
			case 3: split();
					break;
			}
		}
	}
	
	public static void split() {
		String word = "I am learning Core Java";
		String[] strArray =  word.split(" ");
		String str = "[ ";
		for(int i = 0; i < strArray.length; i++) {
			str += strArray[i] + ", ";
		}
		System.out.println(str + "]");
	}
}
