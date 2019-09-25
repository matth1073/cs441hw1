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
	
	public void testUnsuccesfullLoginWithIncorrectUserName() {
		userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		UserAccount userAccount = userAccountManager.login("trump2020", "@White0House"); 
		assertNull(userAccount);
	}
	
}
