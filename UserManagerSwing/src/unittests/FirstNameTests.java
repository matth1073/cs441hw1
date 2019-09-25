package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class FirstNameTests extends TestCase {

	public void testValidFirstName() {
		assertTrue(UserAccount.isLastNameValid("John"));
		assertTrue(UserAccount.isLastNameValid("john")); //all lower case is valid
		assertTrue(UserAccount.isLastNameValid("JOHN")); //all upper case is valid
	}
	public void testInvalidFirstName() {
		assertFalse(UserAccount.isLastNameValid("")); // empty string
		assertFalse(UserAccount.isLastNameValid("J0hn")); //number
		assertFalse(UserAccount.isLastNameValid("J@hn"));  //symbol
	}
}
