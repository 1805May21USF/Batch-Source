
public class Employee extends BankPerson {

	public Employee(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int loggingIn() {
		// TODO Auto-generated method stub
		return 2;
	}

	
	
	
	public String toString() {
		return "I am an employee and my username is " + userName;
	}
	
	
}
