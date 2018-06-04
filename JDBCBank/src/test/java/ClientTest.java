import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.beans.Client;

class ClientTest {
	Client client = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testSelectedAccountNotNull() {
		
		client = new Client(1,"Kmart","pass","first","last");
		assertNotEquals(client , null);
		
	}
		
	@Test
	public void test() {
		client = new Client(2,"Kmart","pass","first","last");
		client.getAccountList().add(new Account(1,1,20.0));
		client.getAccountList().add(new Account(2,2,40.0));
		client.printAccounts();
		assertEquals(client.getAccountList().size() , 2);
	}

	
}
