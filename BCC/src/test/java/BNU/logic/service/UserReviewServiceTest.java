package BNU.logic.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BNU.logic.WindowBuilder;

public class UserReviewServiceTest {
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}
	
	@Test
	public void testGetReviewsForUser() throws Exception {
		UserReviewService trvs = new UserReviewService();
		String[][] reviews = trvs.getReviewsForUser("user1");
		assertTrue(reviews[0][1].equals("3"));
		assertTrue(reviews[0][2].equals("Matthew Fendt"));
		assertTrue(reviews[0][3].equals("C++ Intro 1"));
		assertTrue(reviews[1][1].equals("5"));
		assertTrue(reviews[1][2].equals("Mathew Aars"));
		assertTrue(reviews[1][3].equals("C++ Intro 1"));
		assertTrue(reviews[2][1].equals("5"));
		assertTrue(reviews[2][2].equals("Mathew Aars"));
		assertTrue(reviews[2][3].equals("C++ Intro 1"));
	}
}
