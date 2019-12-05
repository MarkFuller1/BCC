package BNU.logic.service.proxy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BNU.logic.WindowBuilder;
import BNU.logic.service.proxy.SmartProxy;


public class ClassTest {
	
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}

	@Test
	public void testSanatizeInput() throws Exception {
		SmartProxy sp = new SmartProxy();
		String unClean = "good\'\'\'\\\\;;;";
		assertFalse(unClean.equals("good"));
		String clean = sp.sanatizeInput(unClean);
		assertTrue(clean.contentEquals("good"));
	}
	
	@Test
	public void testSanatizeAndCheckCreds() throws Exception {
		SmartProxy sp = new SmartProxy();
		String badUser = "user3\'\'\'\\\\;;;";
		String badPW = "kk\'\'\'\\\\;;;";
		boolean isValidated = true;
		isValidated = sp.sanatizeAndCheckCreds(badUser, badPW);
		assertTrue(isValidated);
	}
	
	@Test
	public void testSanatizeAndCheckIsAdmin() throws Exception {
		SmartProxy sp = new SmartProxy();
		String badUser = "Admin\'\'\'\\\\;;;";
		String badPW = "aspartame\'\'\'\\\\;;;";
		boolean isValidated = true;
		isValidated = sp.sanatizeAndCheckIsAdmin(badUser);
		assertTrue(isValidated);
	}
	
	
	
}
