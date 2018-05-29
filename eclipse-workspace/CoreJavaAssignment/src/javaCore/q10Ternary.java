package javaCore;

public class q10Ternary {
	int x = 1, y = 2, z = 3;
	int smallestNum = x < y ? (x < z ? x : z) : (y < z ? y : z);
	{
	System.out.println(smallestNum + " is the smallest of the three numbers."); }
}