package com.revature.beans;

public class Messages {
	private String introWelcome;
	private String introExit;
	private String introError;
	private String registerWelcome;
	private String registerNewAccountWelcome;
	private String pleaseEnterANumberPrompt;
	private String firstNamePrompt;
	private String lastNamePrompt;
	private String usernamePrompt;
	private String passwordPrompt;
	private String errorUsernameMessage;
	private String errorPasswordMessage;
	private String errorUsernameOrPasswordMessage;
	private String registerExitMessage;
	private String errorNameMessage;
	private String customerPrompt;
	private String employeePrompt;
	private String bankAdminPrompt;

	public Messages() {
		super();
		introWelcome = "Welcome to Tiffany's Banking App.\n"
				+ "\t1 - Register and apply to open a new account\n\t2 - Login to an existing account\n"
				+ "\t3 - Exit program. \n";
		introExit = "Thank you for using Tiffany's Banking App! Have a nice day. ";
		introError = "ERROR: You have entered the wrong option. Please try again. ";
		registerWelcome = "Thank you for choosing to apply for a new account. Please read all the choices carefully. "
				+ "\nAre you:\n\t1 - applying as a new user?\n\t2 - applying as a new user for a joint account? Please note that you are limited to only two users for a joint account at this time."
				+ "\n\t3 - applying for an additional account as a returning user?\n\t4 - return to main menu \n";
		registerNewAccountWelcome = "Thank you for choosing to apply for an account as a new user! \t";
		pleaseEnterANumberPrompt = "Please enter a number on what you would like to do next: ";
		firstNamePrompt = "\tPlease enter your first name: ";
		lastNamePrompt = "\tPlease enter your last name: ";
		usernamePrompt = "\tPlease enter your username: ";
		passwordPrompt = "\tPlease enter your password: ";
		errorUsernameMessage = "Sorry, but the username you entered already exists. ";
		errorPasswordMessage = "Sorry, but the password you entered is not valid. ";
		registerExitMessage = "Thank you for applying for a bank account with Tiffany's Banking App. "
				+ "Your application is currently being reviewed by our employees.\nOnce your account has been approved "
				+ "you should be able to withdraw and deposit funds between accounts. We will now take you "
				+ "to the previous menu.";
		errorNameMessage = "Error: A name does not contain numbers or symbols. Please try again.";
		errorUsernameOrPasswordMessage = "We're sorry. We were unable to find your username or password. Would you like to try again? \n\t1 - retry\n\t2 - exit";
		customerPrompt = "What would you like to do today?\n"
				+ "\t1 - Withdraw from account\n\t2 - Deposit into account\n\t3 - Delete account\n\t4 - Exit account";
		employeePrompt = "What would you like to do today?\n"
				+ "\t1 - Approve/deny open applications\n\t2 - View customer info\n\t3 - Exit account";
		bankAdminPrompt = "What would you like to do today?\n"
				+ "\t1 - Approve/deny open applications\n\t2 - View and edit customer info\n\t3 - Withdraw from"
				+ " an account\n\t4 - Deposit to an account\n\t5 - Cancel an account\n\t6 - Exit menu";
	}

	public String getIntroWelcome() {
		return introWelcome;
	}

	public void setIntroWelcome(String introWelcome) {
		this.introWelcome = introWelcome;
	}

	public String getIntroExit() {
		return introExit;
	}

	public void setIntroExit(String introExit) {
		this.introExit = introExit;
	}

	public String getIntroError() {
		return introError;
	}

	public void setIntroError(String introError) {
		this.introError = introError;
	}

	public String getRegisterWelcome() {
		return registerWelcome;
	}

	public void setRegisterWelcome(String registerWelcome) {
		this.registerWelcome = registerWelcome;
	}

	public String getRegisterNewAccountWelcome() {
		return registerNewAccountWelcome;
	}

	public void setRegisterNewAccountWelcome(String registerNewAccountWelcome) {
		this.registerNewAccountWelcome = registerNewAccountWelcome;
	}

	public String getPleaseEnterANumberPrompt() {
		return pleaseEnterANumberPrompt;
	}

	public void setPleaseEnterANumberPrompt(String pleaseEnterANumberPrompt) {
		this.pleaseEnterANumberPrompt = pleaseEnterANumberPrompt;
	}

	public String getFirstNamePrompt() {
		return firstNamePrompt;
	}

	public void setFirstNamePrompt(String firstNamePrompt) {
		this.firstNamePrompt = firstNamePrompt;
	}

	public String getLastNamePrompt() {
		return lastNamePrompt;
	}

	public void setLastNamePrompt(String lastNamePrompt) {
		this.lastNamePrompt = lastNamePrompt;
	}

	public String getUsernamePrompt() {
		return usernamePrompt;
	}

	public void setUsernamePrompt(String usernamePrompt) {
		this.usernamePrompt = usernamePrompt;
	}

	public String getPasswordPrompt() {
		return passwordPrompt;
	}

	public void setPasswordPrompt(String passwordPrompt) {
		this.passwordPrompt = passwordPrompt;
	}

	public String getErrorUsernameMessage() {
		return errorUsernameMessage;
	}

	public void setErrorUsernameMessage(String errorUsernameMessage) {
		this.errorUsernameMessage = errorUsernameMessage;
	}

	public String getErrorPasswordMessage() {
		return errorPasswordMessage;
	}

	public void setErrorPasswordMessage(String errorPasswordMessage) {
		this.errorPasswordMessage = errorPasswordMessage;
	}

	public String getRegisterExitMessage() {
		return registerExitMessage;
	}

	public void setRegisterExitMessage(String registerExitMessage) {
		this.registerExitMessage = registerExitMessage;
	}

	public String getErrorNameMessage() {
		return errorNameMessage;
	}

	public void setErrorNameMessage(String errorNameMessage) {
		this.errorNameMessage = errorNameMessage;
	}

	public String getErrorUsernameOrPasswordMessage() {
		return errorUsernameOrPasswordMessage;
	}

	public void setErrorUsernameOrPasswordMessage(String errorUsernameOrPasswordMessage) {
		this.errorUsernameOrPasswordMessage = errorUsernameOrPasswordMessage;
	}

	public String getCustomerPrompt() {
		return customerPrompt;
	}

	public void setCustomerPrompt(String customerPrompt) {
		this.customerPrompt = customerPrompt;
	}

	public String getEmployeePrompt() {
		return employeePrompt;
	}

	public void setEmployeePrompt(String employeePrompt) {
		this.employeePrompt = employeePrompt;
	}

	public String getBankAdminPrompt() {
		return bankAdminPrompt;
	}

	public void setBankAdminPrompt(String bankAdminPrompt) {
		this.bankAdminPrompt = bankAdminPrompt;
	}

}
