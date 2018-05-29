package assign1;

//interface that contains unimplementd method
interface SharedMath{
	
	public void addition(double x, double y);
	public void subraction(double x, double y);
	public void multiplication(double x, double y);
	public void division(double x, double y);
}

public class Quest15 implements SharedMath {
	static {
		// Print to console
		System.out.println("\nQuest15" );
	}

	@Override
	public void addition(double x, double y) {
		// Add vars together
		System.out.println(x + " + " + y + " = " + (x + y));
		
	}

	@Override
	public void subraction(double x, double y) {
		// Subtract vars from each other
		System.out.println(x + " - " + y + " = " + (x - y));
		
	}

	@Override
	public void multiplication(double x, double y) {
		// Multiply vars with each other
		System.out.println(x + " * " + y + " = " + (x * y));
		
	}

	@Override
	public void division(double x, double y) {
		// Divide vars
		System.out.println(x + " / " + y + " = " + (x / y));
		
	}
	
	
	
}
