package assign1;

import java.util.ArrayList;

public class Quest9 {
	static {
		// Print to console
		System.out.println("\n\nQuest9: " );
	}
	
	// create array list with values from 1-100 and print out prime numbers
	public static void ArrayListPrimeNums() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			nums.add(i + 1);
		}
		
		for(int i = 0; i < 100; i++) {
			System.out.print(nums.get(i) + " ");
			
			
		}
		
	
		System.out.println();
	}
}
