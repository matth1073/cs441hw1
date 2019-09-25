package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class UserNameTests extends TestCase {

	public void testValidUserName() {
		assertTrue(UserAccount.isUserNameValid("admin"));
		assertTrue(UserAccount.isUserNameValid("adm1n")); //numbers are allowed as long as they are not first character
	}
	
	public void testInvalidUserName() {
		assertFalse(UserAccount.isUserNameValid("")); //empty
		assertFalse(UserAccount.isUserNameValid("1admin")); //first character must be letter
		assertFalse(UserAccount.isUserNameValid("admin!")); //cannot contain symbols
	}

}
