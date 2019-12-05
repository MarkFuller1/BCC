package BNU.logic.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BNU.logic.WindowBuilder;

public class TeacherReviewViewServiceTest {
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}
	
	@Test
	public void testGetAllTeachersByClassService() throws Exception {
		TeacherReviewViewService trvs = new TeacherReviewViewService();
		String[][] reviews = trvs.getReviewsForTeacherClass("Bill Booth", "Algorithms");
		// 1 = score  2 = user_name
		assertTrue(reviews[0][1].equals("1"));
		assertTrue(reviews[0][2].equals("mac"));
		assertTrue(reviews[1][1].equals("1"));
		assertTrue(reviews[1][2].equals("ronald"));
		assertTrue(reviews[2][1].equals("0"));
		assertTrue(reviews[2][2].equals("ron"));
		assertTrue(reviews[3][1].equals("0"));
		assertTrue(reviews[3][2].equals("ron"));
	}
	
	@Test
	public void testGetOverallProfessorRating() throws Exception {
		TeacherReviewViewService trvs = new TeacherReviewViewService();
		String[] ratings = trvs.getProfessorOverallRatings("Bill Booth");
		assertTrue(ratings[0].equals("5.0138888888888889"));
		assertTrue(ratings[1].equals("4.9583333333333333"));
		assertTrue(ratings[2].equals("5.0833333333333333"));
		assertTrue(ratings[3].equals("5.0000000000000000"));

	}
}
