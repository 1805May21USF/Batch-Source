package corejava;

public class Q15class implements Q15interface {

	//basic math methods
	@Override
	public int Addition(int a, int b) {
		return a + b;
	}

	//subtracts from the bigger number
	@Override
	public int Subtraction(int a, int b) {
		if (a > b) {return a - b;}
		return b - a;
	}

	@Override
	public double Division(int a, int b) {
		return a / b;
	}

	@Override
	public int Multiplication(int a, int b) {
		return a * b;
	}

}
