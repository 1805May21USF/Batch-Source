package project1;

public abstract class EmployeeAbstract {

	protected abstract void viewAccountInfo(String Username);
	protected abstract void viewAccountBalance(String Username);
	protected abstract void viewPersonalInformation(String Username);
	protected abstract void approveApplication(String Username);
	protected abstract void denyApplication(String Username);
}
