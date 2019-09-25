package acceptancetests;

import business.UserAccount;
import business.UserAccountManager;
import junit.framework.TestCase;

public class RegisterNewUserTests extends TestCase{
	
	private UserAccountManager userAccountManager;
	
	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
	}

	public void testSuccessfulRegistration(){
		String registrationResult = userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("trump", "@White0House"); 
		assertNotNull(userAccount);
		userAccount.getUserName().equalsIgnoreCase("trump");
		userAccount.getPassword().equalsIgnoreCase("@White0House");
		userAccount.getFirstName().equalsIgnoreCase("Don");
		userAccount.getLastName().equalsIgnoreCase("Trump");
		userAccount.getEmail().equalsIgnoreCase("trump@gmail.com");
		userAccount.getPhoneNumber().equalsIgnoreCase("7024265734");
	}
	
	public void testRegistrationWithInvalidUserName(){
		String registrationResult = userAccountManager.registerNewUser("2016trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationWithInvalidUserName: " + registrationResult);
		assertFalse(userAccountManager.doesUserNameExist("2016trump"));
	}
	
	public void testRegistrationWithInvalidPassword() {
		String registrationResult = userAccountManager.registerNewUser("trump2020", "WhiteHouse", "WhiteHouse", "Don", "Trump", "trump@gmail.com", "7024265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationWithInvalidPassword: " + registrationResult);
		assertFalse(userAccountManager.doesUserNameExist("trump2020"));
	}
	
	public void testRegistrationWithInvalidFirstName() {
		String registrationResult = userAccountManager.registerNewUser("trump2016", "@White0House", "@White0House", "D0n", "Trump", "trump@gmail.com", "7024265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationWithFirstName: " + registrationResult);
		assertFalse(userAccountManager.doesUserNameExist("trump2016"));
	}
	
	public void testRegistrationWithInvalidLastName() {
		String registrationResult = userAccountManager.registerNewUser("trump2000", "@White0House", "@White0House", "Don", "Tr$mp", "trump@gmail.com", "7024265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationWithLastName: " + registrationResult);
		assertFalse(userAccountManager.doesUserNameExist("trump2000"));
	}
	public void testRegistrationWithInvalidReenteredPassword() {
		String registrationResult = userAccountManager.registerNewUser("trump2024", "@White0House", "@WhiteHouse0", "Don", "Trump", "trump@gmail.com", "7024265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationWithInvalidReenteredPassword: " + registrationResult);
		assertFalse(userAccountManager.doesUserNameExist("trump2024"));
	}
	
	public void testRegistrationWithInvalidEmail() {
		String registrationResult = userAccountManager.registerNewUser("trump2050", "@White0House", "@White0House", "Don", "Trump", "trump@gmail..com", "7024265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationWithInvalidEmail: " + registrationResult);
		assertFalse(userAccountManager.doesUserNameExist("trump2050"));
	}

	public void testRegistrationWithInvalidPhoneNumber() {
		String registrationResult = userAccountManager.registerNewUser("trump2100", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "4265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationWithInvalidEmail: " + registrationResult);
		assertFalse(userAccountManager.doesUserNameExist("trump2100"));
	}
	
	public void testRegistrationsWithUserNameAlreadyChosen() {
		String registrationResult = userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		String registrationResult2 = userAccountManager.registerNewUser("trump", "Pre$identson1", "Pre$identson1", "Eric", "Trump", "erictrump@gmail.com", "8587452135");
		assertTrue(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		assertFalse(registrationResult2.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		System.out.println("testRegistrationsWithUserNameAlreadyChosen: " + registrationResult2);
	}
}
