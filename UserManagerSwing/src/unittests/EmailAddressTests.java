package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class EmailAddressTests extends TestCase {

	public void testValidEmailAddress() {
		assertTrue(UserAccount.isEmailValid("don.smith@gmail.com"));
		assertTrue(UserAccount.isEmailValid("don@gmail.com")); //without the .smith
		assertTrue(UserAccount.isEmailValid("don123@gmail.com")); //with numbers
		assertTrue(UserAccount.isEmailValid("don!!!@yahoo.org")); //with symbols
	}
	public void testInvalidEmailAddress() {
		assertFalse(UserAccount.isEmailValid("")); //empty 
		assertFalse(UserAccount.isEmailValid("@gmail.com")); //missing user name
		assertFalse(UserAccount.isEmailValid("don.smith@")); //missing second and top level domain
		assertFalse(UserAccount.isEmailValid("don.smith@.com")); //missing second domain
		assertFalse(UserAccount.isEmailValid("don.smith@gmail")); //missing top domain
		assertFalse(UserAccount.isEmailValid("don.smithgmail.com")); //no @ sign
		assertFalse(UserAccount.isEmailValid("don.smith@gmail..com")); //typo, two periods 
	}

}
