package homework1;

public class Q4 extends Q18  {
	
	int factorial(int n)
	  {
	 
	    // solve the problem with one line of code (ternary code). 
		// use the Factorial of a non-negative integer, is multiplication of
		//all integers smaller than or equal to n
	    return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
	 
	  }
	 
	 
	  // test code 
	  public static void main(String args[])     
	  {
		  Q4 obj = new Q4();
	    int num = 0;
	    int num1 = 1;
	    int num2 = 2;
	    int num3 = 3;
	    int num4 = 4;
	    int num5 = 5;
	    int num6 = 6;
	    int num7 = 7;
	    int num8 = 8;
	    int num9 = 9;
	    int num10 = 10;
	    System.out.println("Factorial of " + num + 
	                      " is " + obj.factorial(num));
	    System.out.println("Factorial of " + num1 + 
                " is " + obj.factorial(num1));
	    System.out.println("Factorial of " + num2 + 
                " is " + obj.factorial(num2));
	    System.out.println("Factorial of " + num3 + 
	    		" is " + obj.factorial(num3));
	    System.out.println("Factorial of " + num4 + 
                " is " + obj.factorial(num4));
	    System.out.println("Factorial of " + num5 + 
	    		" is " + obj.factorial(num5));
	    System.out.println("Factorial of " + num6 + 
	    		" is " + obj.factorial(num6));
	    System.out.println("Factorial of " + num7 + 
	    		" is " + obj.factorial(num7));
	    System.out.println("Factorial of " + num8 + 
                " is " + obj.factorial(num8));
	    System.out.println("Factorial of " + num9 + 
	    		" is " + obj.factorial(num9));
		System.out.println("Factorial of " + num10 + 
		      " is " + obj.factorial(num10));
		
	   }


	public boolean hasUpperCase() {
		
		for(int i = 0; i < name.length(); i++)
		{
			if( Character.isUpperCase( name.charAt(i) ) )
				return true ;
		}
		
		return false;
	}


	public void toUpperCase() {
		// TODO Auto-generated method stub
		name = name.toUpperCase();	
	}


	public int addTen() {
		// TODO Auto-generated method stub
		
		return Integer.parseInt(age) + 10;	
	}
	}



