package javaCore;

public class q3ReverseString {
	String reverseMe = "reverse me!";
	{
	for (int i = 0; i < reverseMe.length(); i++) { 
		reverseMe = reverseMe.substring(1, reverseMe.length() - i) + reverseMe.substring(0, 1) + reverseMe.substring(reverseMe.length() - i, reverseMe.length()); } 
	System.out.println(reverseMe);
	}
}
