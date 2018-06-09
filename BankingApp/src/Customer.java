import java.util.ArrayList;

public class Customer {
 private String firstName;
 private String lastName;
 private String userName;
 private String password;
 private int accountID;

 public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
 
 public Customer(String firstname, String lastName, String username, String password, int accountID) {
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.userName = username;
	 this.password = password;
	 this.accountID = accountID;
	 
 }


public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
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




 public int getAccountID() {
	return accountID;
}

public void setAccountID(int accountID) {
	this.accountID = accountID;
}

public void Customerinfo() {
	
 }
 
}

