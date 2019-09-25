package acceptancetests;

import business.UserAccount;
import business.UserAccountManager;
import junit.framework.TestCase;

public class LoginTests extends TestCase{
	private UserAccountManager userAccountManager;
	
	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
	}
	
	public void testSuccesfulLogin() {
		userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		UserAccount userAccount = userAccountManager.login("trump", "@White0House"); 
		System.out.println(userAccount.isValidCredential("trump", "@White0House"));
		assertNotNull(userAccount);
	}
	
	public void testUnsuccesfulLoginWithIncorrectPassword() {
		userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		UserAccount userAccount = userAccountManager.login("trump", "WhiteHouse");
		assertNull(userAccount);
	}
	
	public void testUnsuccesfulLoginWithIncorrectUserName() {
		userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		UserAccount userAccount = userAccountManager.login("trump2020", "@White0House"); 
		assertNull(userAccount);
	}
	public void testMultipleUserSuccessfulLogin() {
		userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		userAccountManager.registerNewUser("trumpjr", "@White0House", "@White0House", "donny", "Trump", "trump@gmail.com", "7024265734");
		userAccountManager.registerNewUser("etrump", "@White0House", "@White0House", "eric", "Trump", "trump@gmail.com", "7024265734");
		UserAccount userAccount = userAccountManager.login("trump", "@White0House");
		UserAccount userAccount2 = userAccountManager.login("trumpjr", "@White0House");
		UserAccount userAccount3 = userAccountManager.login("etrump", "@White0House");
		assertNotNull(userAccount);
		assertNotNull(userAccount2);
		assertNotNull(userAccount3);
	}
}
