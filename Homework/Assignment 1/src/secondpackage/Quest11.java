package secondpackage;

public class Quest11 {
	
	// Static code block gets called once max.
	static {
		// Print to console
		System.out.println("\nQuest11:" );
	}
	// Save two float numbers
	private float firstNumber = 1.234567f;
	private float secondNumber = 5.65432f;
	
	
	// getters and setters for the private float variables
	public float getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(float firstNumber) {
		this.firstNumber = firstNumber;
	}
	
	public float getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(float secondNumber) {
		this.secondNumber = secondNumber;
	}
	
	
}
