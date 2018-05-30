package project1;

public abstract class AdminAbstract extends EmployeeAbstract{

	protected abstract void denyApplication(String Username);
	abstract void withdraw(String accountName, int amount);
	abstract void deposit(String accountName, int amount);
	abstract void transfer(String accountName, int amount);
	abstract void cancelAccount(String accountName);
}
