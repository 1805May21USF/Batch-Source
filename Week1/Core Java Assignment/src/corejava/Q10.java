package corejava;

public class Q10 {
	public static String Solution(int num1, int num2) {
		//determines which number is higher then subtracts lower number from it
		Integer min = num1 < num2 ? num2 - num1 : num1 - num2;
		return min.toString();
	}
}
