import java.io.Serializable;

public class Admin extends BankPerson implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	/**
	 * 
	 */
	

	
	Admin(String Username,String password) {
		
		super(Username, password);
	}

	@Override
	public int loggingIn() {
		return 3;
	}
	
	public String toString() {
		return "I am an admin and my username is " + userName;
	}
}
