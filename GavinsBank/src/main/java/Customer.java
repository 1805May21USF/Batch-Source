import java.util.ArrayList;

public class Customer extends BankPerson {

	
	public Customer(String userName, String password, String first, String last) {
		super(userName, password,first, last);
		accountList = new ArrayList<Account>();
		// TODO Auto-generated constructor stub
	}

	ArrayList<Account> accountList;

	@Override
	public int loggingIn() {
		// TODO Auto-generated method stub
		return 1;
	} 
	
	public String toString() {
		return "I am a customer and my username is " + userName;
	}
	
	public String deepString() {
		return "Name: " + firstName + lastName 
			  +"Number of accounts: " +accountList.size() 
			  +"Username : " +userName;
			  
				
	}
	
	public void addAccount(Account a) {
		accountList.add(a);
	}
	
}
