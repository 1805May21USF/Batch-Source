package assign1;

public class Quest12 {
	static {
		// Print to console
		System.out.println("\nQuest12" );
	}
	
	// Print out even numbers from 1 to 100 using enchanced FOR loop
	public static void ArrayEnhancedForLoop() {
		
		int[] arrayNums = new int[100];
		
		// Add numbers from 1 to 100 into arrayNums.
		for(int i = 0; i < 100; i++) {
			arrayNums[i] = i + 1;
			//System.out.println(arrayNums[i]);
		}
		
		// Print out even number using enhanced for loop. 2, 4, 6, ... , 100.
		// Limit i to less than 100 to prevent index out of bounds
		for(int i : arrayNums) {
			if((i < 100) && (arrayNums[i] % 2 == 0)) {
				System.out.print(arrayNums[i] + " ");
			}
		}
		System.out.println();
	}
	
}
