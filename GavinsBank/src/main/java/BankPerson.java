import java.io.Serializable;
import java.util.ArrayList;

public abstract class BankPerson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 834449354198012251L;
	/**
	 * 
	 */
	
	protected String firstName;
	protected String  lastName;

	protected String userName;
	private String password;
	public ArrayList<Account> accountList;
	
	public BankPerson(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public BankPerson(String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public abstract int loggingIn();
	
	public String getUser() {
		return userName;
	}

	public boolean checkPass(String possiblePass) {
		return (possiblePass .equals(password));
	}
	
	
	
	
}
