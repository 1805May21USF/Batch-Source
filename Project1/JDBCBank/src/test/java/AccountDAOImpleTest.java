import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccountDAOImpleTest {
	@Test
	void minTest() {

		int a =2;

		int b = 4;

		System.out.println(Math.min(a, b));

		assertEquals(a, (Math.min(b,a)));

	}
/*	@Test
	public void numeric inputTest(()) {
		assertTrue(blah);
	}*/
}
