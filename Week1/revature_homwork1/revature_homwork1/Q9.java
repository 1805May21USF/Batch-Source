package revature_homwork1;

import java.util.ArrayList;
import java.util.Arrays;

public class Q9 {
	public static ArrayList<Integer> nums;
	public static ArrayList<Integer> primes;

	public static ArrayList get() {
		nums = new ArrayList<>();
		primes = new ArrayList<>();
		for (int i =1;i<101;i++) {
			nums.add(i);
		}
		for (int num : nums) {
			for (int i=2;i<101;i++) {
				if(num == i) {
					primes.add(i);
					
				}
				if (num %i ==0) {
					break;
				} 
			}
			
		}
		System.out.println(Arrays.deepToString(primes.toArray()));

		return primes;
	}
}
