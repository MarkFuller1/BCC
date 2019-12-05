package BNU.logic.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BNU.logic.WindowBuilder;
import BNU.singleton.SingletonSession;

public class MessageBoardServiceTest {
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}
	
	@Test
	public void testGetAllClassesOffered() throws Exception {
		SingletonSession session = SingletonSession.getInstance("User", true);
		MessageBoardService mbs = new MessageBoardService();
		String receiver = mbs.getReceiver();
		assertTrue(receiver.equals("User"));
	}
	
	@Test
	public void testRemoveDuplicates() throws Exception {
		MessageBoardService mbs = new MessageBoardService();
		String[] dups = {"hi","hi","hi"};
		String[] noDups = mbs.removeDuplicates(dups);
		assertTrue(noDups.length == 1);
		assertTrue(noDups[0].equals("hi"));
	}
}
