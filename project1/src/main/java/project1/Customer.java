package project1;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Account{

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	Account account;
	private int accountBalance;
	private String accountNumber;
	ArrayList<Customer> List;// = new ArrayList;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
		//this.List = new ArrayList<>();
	}
	
	public Customer(String password, int accountBalance) {
		super();
		this.password = password;
		this.account = new Account();
		this.List = new ArrayList<>();
		this.accountBalance = account.getAccountBalance();
		this.accountNumber = account.getAccountNumber();
	}
	
	public Customer(String userName, String Password) {
		super();
		this.account = new Account();
		Customer cus = getCustomer(userName);
		//this.List = new ArrayList<>();
		for(Customer c : List) {
			if(userName.equals(c.getUserName()))
				cus = c;
		}
		//this.List = account.accountList; 
		this.firstName = cus.firstName;
		this.lastName = cus.lastName;
		this.userName = userName;
		this.password = Password;
		this.accountBalance = cus.accountBalance; //getAccountBalance(); //account.getAccountBalance();
		this.accountNumber =  cus.accountNumber;//getAccountNumber(); //account.getAccountNumber();
	}

	public Customer(String firstName, String lastName, String userName, String password) {
		// TODO Auto-generated constructor stub
		this.List = new ArrayList<>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.account = new Account();
		this.accountBalance = account.getAccountBalance();
		this.accountNumber = account.getAccountNumber();
	}
	
	public Customer(String firstName, String lastName, String userName, String password, String accountNumber, int accountBalance){
		// TODO Auto-generated constructor stub
		this.List = new ArrayList<>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.account = new Account();
		this.accountBalance = accountBalance;
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addToList(Customer cus){
		this.List.add(cus);
	}
	
	public Customer getCustomer(String userName){
		for(Customer cus : List){
			if(userName.equals(cus.getUserName())){
				return cus;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "\nFirstName: " + firstName +
		"\nLastName: " + lastName +
		"\nUsername: " + userName +
		"\nPassword: " + password +
		"\nAccount Number: " + accountNumber +
		"\nAccount Balance: " + accountBalance ;
//		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
//				+ password;
	}
}
