package assign1;

public class Quest13 {
	static {
		// Print to console
		System.out.println("\nQuest13" );
	}
	
	// Display Triangle of 0s and 1s
	public static void DisplayTriangle() {
		
		// Go through the 10 numbers
		for(int i = 1; i < 11; i++) {
			// Print out 0 if i is even number
			if(i % 2 == 0) {
				System.out.print(1);
			}
			else {
				// Print out 1 if i is an odd number
				System.out.print(0);
			}
		}
		System.out.println();
	}
}
