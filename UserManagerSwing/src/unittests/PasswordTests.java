package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PasswordTests extends TestCase {

	public void testValidPassword() {
		assertTrue(UserAccount.isPasswordValid("@White0House"));
		assertTrue(UserAccount.isPasswordValid("WhiteHouse0@")); //checking that position does not matter
	}
	public void testInvalidPassword() {
		assertFalse(UserAccount.isPasswordValid("")); //empty
		assertFalse(UserAccount.isPasswordValid("@Whi0")); //less than 6 
		assertFalse(UserAccount.isPasswordValid("WhiteHouse")); //no symbols or numbers
		assertFalse(UserAccount.isPasswordValid("@white0house")); //all lower case
		assertFalse(UserAccount.isPasswordValid("@WHITE0HOUSE")); //all upper case
		assertFalse(UserAccount.isPasswordValid("@WhiteHouse")); //no number
		assertFalse(UserAccount.isPasswordValid("White0House")); //no symbol





	}

}
