package homework1;

public class Q2 {
	//Write a program to display the first 25 Fibonacci numbers beginning at 0.
  
	// start off by creating a integer for numbers
	// create two variable set them to zero and one
	static void printFibonacciNumbers(int n)
    {
		
        int f1 = 0, f2 = 1, i;
     
        if (n < 1)
            return;
     // When the for loop starts the f1 is set to zero and f2 is set to one
     // The second time the loop happens f1 will have added plus one, and f2 will be the same.
     // The third time the loop happens f1 will stay the same and f2 will increase by one.
     
        // Example:	(f1)0+(f2)1 = 1
       //			(f1)1+(f2)1 = 2	 
      //			(f1)1+(f2)2 = 3 
     
        // In other words, f1 will take the last loop value of f2 and f2 will take the sum total.
        // Example: 	(f1 start value)0+(f2 start value )1 = 1(1st sum)
        // 				( 2nd f1)1+(2nd f2)1 = 2(2nd sum)	 
        //				(f1 is set to 2nd f2)1+(f2 is set to 2nd sum )2 = 3 (3rd sum)
        
        
        for (i = 1; i <= n; i++)
        {
            System.out.print(f2+" ");
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
    } 
     
    // test code above
    public static void main(String[] args) 
    {
        printFibonacciNumbers(25);
    }
}
