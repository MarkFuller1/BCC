package BNU.logic.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BNU.logic.WindowBuilder;

public class LoginServiceTest {
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}
	
	@Test
	public void testCheckCredentialsGoodCreds() throws Exception {
		LoginService ls = new LoginService();
		boolean goodCreds = ls.checkCredentials("user3", "kk");
		assertTrue(goodCreds);
	}
	
	@Test
	public void testCheckCredentialsBadCreds() throws Exception {
		LoginService ls = new LoginService();		
		boolean badCreds = ls.checkCredentials("admin", "admin");
		assertFalse(badCreds);
	}
	
	@Test
	public void testisUserAdminGoodCreds() throws Exception {
		LoginService ls = new LoginService();
		boolean isAdmin = ls.isUserAdmin("Admin");
		assertTrue(isAdmin);
	}
	
	@Test
	public void testisUserAdminBadCreds() throws Exception {
		LoginService ls = new LoginService();
		boolean isNotAdmin = ls.isUserAdmin("user1");
		assertTrue(isNotAdmin);

	}
}
