import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.impl.register.RegisterNewAccount;

class RegisterNewAccountTest {

	@Test
	void alphabetTest() {
		
		String str = "AlphabeticalLettersOnlyWithNoSpacesThisShouldBeTrue";
		assertTrue(RegisterNewAccount.CheckNameIfValid(str));
		
		String str2 = "Alphabetical Letters With Spaces This should be false ";
		assertFalse(RegisterNewAccount.CheckNameIfValid(str2));
		
		String str3 = "Alphabetic23131.";
		assertFalse(RegisterNewAccount.CheckNameIfValid(str3));
		
		String str4 = "@lphabetical Letters With $paces ^ $ymbols. This should be false.*";
		assertFalse(RegisterNewAccount.CheckNameIfValid(str4));
		
		String str5 = "123281231";
		assertFalse(RegisterNewAccount.CheckNameIfValid(str5));
	}
}
