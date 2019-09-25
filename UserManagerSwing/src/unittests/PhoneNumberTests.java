package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PhoneNumberTests extends TestCase {

	public void testValidPhoneNumber() {
		assertTrue(UserAccount.isPhoneNumberValid("8162356218"));
	}
	public void testInvalidPhoneNumber() {
		assertFalse(UserAccount.isPasswordValid("")); //empty
		assertFalse(UserAccount.isPhoneNumberValid("onetwofour"));  //letters
		assertFalse(UserAccount.isPhoneNumberValid("8!62356218")); //symbol
		assertFalse(UserAccount.isPhoneNumberValid("2356218")); //less than 10 digits
		assertFalse(UserAccount.isPhoneNumberValid("8162356218192")); //more than 10 digits
	}

}
