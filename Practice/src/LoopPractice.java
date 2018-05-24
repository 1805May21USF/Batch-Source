import java.util.ArrayList;
import java.util.Arrays;

public class LoopPractice {

	public static void main(String[] args) {
		int[] t = {3, 2, 1, 53};
		System.out.println(Arrays.toString(t));
		ArrayList<String> t1 = new ArrayList<>();
	}

	static int loop(int x) {
		if (x > 2) {
			do {
			} while (x++ < 12);
		} else {

			while (x <= 10) {
				x++;
			}
		}
		switch (x) {
		case 0: System.out.println("HI"); break;
		case 3: System.out.println("Value is 1");
		case 13: System.out.println("It's exactly 13"); break;
		default: System.out.println(x + " asdddddddddddddd");
		}
		return x;
	}

}
