
public class Q15 {
	/*
	 * Q15. Write a program that defines an interface having the following methods:
	 * addition, subtraction, multiplication, and division. Create a class that
	 * implements this interface and provides appropriate functionality to carry out
	 * the required operations. Hard code two operands in a test class having a main
	 * method that calls the implementing class.
	 */
	public static void main(String[] args) {
		Operations a = new Operations();

		System.out.println(a.addition(5, 3));
		System.out.println(a.division(4, 90));

	}

	static class Operations implements Math {

		@Override
		public double addition(double a, double b) {
			return a + b;
		}

		@Override
		public double subtraction(double a, double b) {
			return a - b;
		}

		@Override
		public double multiplication(double a, double b) {
			return a * b;
		}

		@Override
		public double division(double a, double b) {
			/*
			 * When dividing, there has to be a check when dividing by 0. It will instead
			 * print to the user an error message
			 */
			if (b == 0) {
				System.out.println("Error: Division by 0.");
				System.exit(0);
				return 0;
			} else {
				return a / b;
			}
		}
	}

	public static interface Math {
		// Return the addition of two doubles
		public abstract double addition(double a, double b);

		// Return the subtraction of two doubles
		public abstract double subtraction(double a, double b);

		// Return the multiplication of two doubles
		public abstract double multiplication(double a, double b);

		// Return the division of two doubles
		public abstract double division(double a, double b);
	}

}
