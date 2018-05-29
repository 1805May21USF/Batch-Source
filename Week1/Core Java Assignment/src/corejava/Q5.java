package corejava;

public class Q5 {
	
	/*Write a substring method that accepts a string str and an integer idx and returns the 
	substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring 
	methods in the String, StringBuilder, or StringBuffer APIs.*/
	public static String Solution(String str, int idx) {
		char[] substring = new char[idx];
		for (int i = 0; i < idx - 1; i++) {
			substring[i] = str.charAt(i);
		}
		return new String(substring);
	}
}
