import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.gen5.api.Test;

import com.revature.DAOImple.UserDAOImple;

public class UserDAOImpleTest {
	UserDAOImple udi = new UserDAOImple();
	@Test
	public void testIsUser() {

		assertTrue(udi.isUserName("dustin"));
	}
	@Test
	public void LoginTest() {
		assertFalse(udi.login("helpme", "notapassword"));
	}
}
