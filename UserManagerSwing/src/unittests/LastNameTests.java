package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class LastNameTests extends TestCase {

	public void testValidLastName() {
		assertTrue(UserAccount.isFirstNameValid("Smith"));
		assertTrue(UserAccount.isFirstNameValid("smith")); //all lower case is valid
		assertTrue(UserAccount.isFirstNameValid("SMITH")); //all upper case is valid
	}
	
	public void testInvalidLastName() {
		assertFalse(UserAccount.isLastNameValid("")); //empty
		assertFalse(UserAccount.isLastNameValid("Sm1th")); //number
		assertFalse(UserAccount.isLastNameValid("Sm!th")); //symbol
	}

}
