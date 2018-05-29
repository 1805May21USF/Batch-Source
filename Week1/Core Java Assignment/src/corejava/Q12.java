package corejava;

public class Q12 {
	public static void Solution() {
		int[] numArr = new int[100];
		for(int i = 1; i <= 100; i++) {
			numArr[i - 1] = i;
		}
		//the enhanced for loop
		for (int num : numArr) {
			if (num % 2 == 0) {
				System.out.println(num);
			}
		}
	}
}
