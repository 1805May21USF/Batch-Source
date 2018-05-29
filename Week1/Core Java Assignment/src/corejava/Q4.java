package corejava;

public class Q4 {
	public static String Solution() {
		//calcs factorial total
		int factorial = 4;
		int result = 1;
		for (int i = 1; i <= factorial; i++) {
			result *= i;
		}
		return Integer.toString(result);
	}
}
