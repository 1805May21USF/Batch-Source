package assign1;

public class Quest2 {
	static {
		// Print to console
		System.out.println("\nQuest2: " );
	}
	
	public static void DisplayFibonacci() {
		// Create int array
		int[] fibNums = new int[25];
		
		// Set first element to 0 and second element to 1.
		fibNums[0] = 0;
		fibNums[1] = 1;
		
		// Set the array. Current number is equal to the previous two numbers added together.
		for(int i = 2; i < fibNums.length; i++) {
			fibNums[i] = fibNums[i-2] + fibNums[i-1];
		}
		
		for(int i = 0; i < fibNums.length; i++) {
			System.out.println("[" + (i+1) + "] -> " + fibNums[i]);
		}
	}
}
