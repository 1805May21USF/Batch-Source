import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.impl.employee.Employee;

class EmployeeTest {

	@Test
	void test() {
		String str = "AlphabeticalLettersOnlyWithNoSpacesThisShouldBeFalse";
		assertFalse(Employee.checkIfDigit(str));
		
		String str2 = "Alphabetical Letters With Spaces This should be false ";
		assertFalse(Employee.checkIfDigit(str2));
		
		String str3 = "Alphabetic23131.";
		assertFalse(Employee.checkIfDigit(str3));
		
		String str4 = "@lphabetical Letters With $paces ^ $ymbols. This should be false.*";
		assertFalse(Employee.checkIfDigit(str4));
		
		String str5 = "12345123";
		assertTrue(Employee.checkIfDigit(str5));
		
		String str6 = "123451a23";
		assertFalse(Employee.checkIfDigit(str6));
	}

}
