package assign1;

public class Quest4 {
	static {
		// Print to console
		System.out.println("\n\nQuest4: " );
	}
	
	//Comput factorial using int passed into method
	public static void ComputeNFactorial(int num) {
		int total = num;
		int firstNum = num;
		
		// Condition, Limit i so it will not be less than the given number since i starts at 0
		// Condition, make sure that num-1 will not equal 0 or less. (if num = 1, then num - 1 = 0.
			// Total would be multiplied by 0 and total would become 0.
		for(int i = 0; (i < firstNum) && ((num-1) > 0); i++, num--) {
			//System.out.println("\nnum: " + num);
			//System.out.println("total: " + total);
			total= total * (num -1);
			//System.out.println("total: " + total);
			
		}
		
		System.out.println(firstNum + "! factorial = " + total);
	}
}
