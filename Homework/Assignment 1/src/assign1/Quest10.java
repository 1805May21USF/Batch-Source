package assign1;


public class Quest10 {
	// Static code block gets called once max.
	static {
		// Print to console
		System.out.println("\nQuest10:" );
	}
	
	// Find the minimum of two numbers
	public static void FindMin(int num1, int num2) {
		
		// Ternary operator
		
		// is num 1 is less than num2, assign true to num1min, else assign false to num1min
		boolean num1Min = (num1 < num2) ? true : false;
		
		// Print out if num1Min is true, which means num1 is smaller than num2
		if(num1Min == true) {
			System.out.println(num1 + " is smaller than " + num2);
		}
		else {
			// Print out if num2 is smaller than num1
			System.out.println(num2 + " is smaller than " + num1);
		}
	}
}
