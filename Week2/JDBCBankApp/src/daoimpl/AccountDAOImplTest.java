package daoimpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import app.Account;

class AccountDAOImplTest {

	void testGetAccount() {
		AccountDAOImpl adi = new AccountDAOImpl();
		int accountNum = 3;
		
		try {
			Account account = adi.getAccount(accountNum);
			
			//check that fields are filled
			assertTrue(account.getAccountNum() != 0);
			
			assertNotNull("First Name field is null", account.getFirstName());
			assertNotNull("Last Name field is null", account.getLastName());
			assertNotNull("Username field is null", account.getUsername());
			assertNotNull("Password field is null", account.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void testLoginLogout() {
		AccountDAOImpl adi = new AccountDAOImpl();
		
		assertNotNull(adi.login("Admin", "password"));
		assertNotNull(adi.login("test", "password"));
		assertNotNull(adi.login("bbaxton", "basketball"));
		assertNotNull(adi.login("AK47sandsuch", "vodka"));
		assertNotNull(adi.logout());
	}
	
	void testDepositWithdraw() {
		AccountDAOImpl adi = new AccountDAOImpl();
		Account account = null;
		
		try {
			account = adi.getAccount(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double fund = account.getFunds();
		adi.deposit(account, 100);
		adi.withdraw(account, 100);
		assertSame(fund, account.getFunds());
	}
}
