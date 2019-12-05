package BNU.logic.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BNU.data.Professor;
import BNU.logic.WindowBuilder;

public class TeacherByClassServiceTest {
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}
	
	@Test
	public void testGetAllTeachersByClassService() throws Exception {
		TeacherByClassService tbcs = new TeacherByClassService();
		String[] professors = tbcs.getAllTeachersByClassService("Algorithms");
		assertTrue(professors[0].equals("Bill Booth"));
	}
	
	@Test
	public void testGetAllProfessorsByCourseService() throws Exception {
		TeacherByClassService tbcs = new TeacherByClassService();
		Professor[] professors = tbcs.getAllProfessorsByCourseService("Algorithms");
		assertTrue(professors[0].getProfessor().equals("Bill Booth"));
		assertTrue(professors[0].getRating().equals("4.7"));
		assertTrue(professors[0].getNumberOfReviews().equals("12"));
	}
}
