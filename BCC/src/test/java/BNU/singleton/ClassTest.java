package BNU.singleton;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import org.junit.Test;



public class ClassTest {
	
	@Before
	public void setUp() {
		SingletonSession session = SingletonSession.getInstance("User", true);
	}
	
	@Test
	public void testSingletonGetInstance() throws Exception {
		SingletonSession.getInstance();
		//SingletonSession session = SingletonSession.getInstance("User", true);
		assertTrue(SingletonSession.getUserName().equals("User"));
		SingletonSession.getInstance();
		assertTrue(SingletonSession.isAdmin());
	}
	
	@Test
	public void testGetUserName() throws Exception {
		SingletonSession.getInstance();
		assertTrue(SingletonSession.getUserName().equals("User"));
	}
	
	@Test
	public void testGetAdmin() throws Exception {
		SingletonSession.getInstance();
		assertTrue(SingletonSession.isAdmin());
	}

	@Test
	public void testSetUserName() throws Exception {
		SingletonSession.setUserName("changed");
		SingletonSession.getInstance();
		assertTrue(SingletonSession.getUserName().equals("changed"));
	}
	
	@Test
	public void testSetAdmin() throws Exception {
		SingletonSession.setAdmin(false);
		SingletonSession.getInstance();
		assertFalse(SingletonSession.isAdmin());
	}
}
