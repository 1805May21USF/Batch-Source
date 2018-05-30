package project1;

public abstract class CustomerAbstract {

	abstract void register(String Username, String Password);
	abstract void openAccount(String Username, String Password);
	abstract void openJointAccount(String Username, String Password);
	abstract void withdraw(String accountName, int amount);
	abstract void deposit(String accountName, int amount);
	abstract void transfer(String accountName, int amount);
}
