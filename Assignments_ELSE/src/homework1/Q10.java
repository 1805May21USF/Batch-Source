package homework1;

public class Q10
{
	// Find the minimum of two numbers using ternary operators.
	//Nothing to now, but be understand what's a ternary statement and how to implement one. 
	public static void main(String[] args)
	{
		int x = 1, y =2 ;
		int smallestNum;
		smallestNum = (x < y)? x : y;
		
		// print out the ternary statement 
		System.out.println(smallestNum + " " + "is the smallest of the two numbers" );
	}
}