import java.util.ArrayList;

class LambdaPractice {
	public static void main(String args[]) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Meow ");

		cat t = (String m, int i) -> {
			int j = 0;
			while (j++ < i) {
				System.out.println(m);
			}
			;
		};
		int i = (int) (Math.random() * 20);
		arr.forEach(n -> t.meow(n, i));
		System.out.println();

	}

	interface cat {
		void meow(String t, int i);
	}
}
