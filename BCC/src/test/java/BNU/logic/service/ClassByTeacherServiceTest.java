package BNU.logic.service;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import BNU.data.Course;
import BNU.logic.WindowBuilder;

public class ClassByTeacherServiceTest {
	
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}
	
	@Test
	public void testGetAllCoursesByTeacher() throws Exception {
		ClassByTeacherService cbts = new ClassByTeacherService();
		Course[] classes = cbts.getAllCoursesByTeacherService("Eungee Song");
		assertTrue(classes[0].getCourse().equals("Software 2"));
		assertTrue(classes[1].getCourse().equals("Discrete Structures"));
	}

}
