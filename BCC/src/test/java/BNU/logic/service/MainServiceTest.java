package BNU.logic.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BNU.logic.WindowBuilder;

public class MainServiceTest {
	WindowBuilder window;
	@Before
	public void setUp() {
		window = new WindowBuilder();
	}
	
	@Test
	public void testGetAllClassesOffered() throws Exception {
		MainService ms = new MainService();
		String[] classes = ms.getAllClassesOffered();
		assertTrue(classes[0].equals("C++ Intro 2"));
		assertTrue(classes[1].equals("Discrete Structures"));
		assertTrue(classes[2].equals("Intro to Computer Systems"));
		assertTrue(classes[3].equals("Data Structures"));
		assertTrue(classes[4].equals("Software 1"));
		assertTrue(classes[5].equals("Algorithms"));
		assertTrue(classes[6].equals("Systems Programming"));
		assertTrue(classes[7].equals("Database Design"));
		assertTrue(classes[8].equals("Software 2"));
		assertTrue(classes[9].equals("Computer Architecture"));
		assertTrue(classes[10].equals("Operating Systems"));
		assertTrue(classes[11].equals("Data Communications"));
		assertTrue(classes[12].equals("Computer Ethics"));
		assertTrue(classes[13].equals("Capstone Design"));
		assertTrue(classes[14].equals("Foundation of Comp"));
		assertTrue(classes[15].equals("C++ Intro 1"));
	}
	
	@Test
	public void testGetAllProfs() throws Exception {
		MainService ms = new MainService();
		String[] classes = ms.getAllProfs();
		assertTrue(classes[0].equals("Cindy Fry"));
		assertTrue(classes[1].equals("Greg Hamerly"));
		assertTrue(classes[2].equals("Tomas Cerny"));
		assertTrue(classes[3].equals("Bill Booth"));
		assertTrue(classes[4].equals("Eungee Song"));
		assertTrue(classes[5].equals("Jeff Donahoo"));
		assertTrue(classes[6].equals("Greg Speegle"));
		assertTrue(classes[7].equals("K Lin"));
		assertTrue(classes[8].equals("Michael Poor"));
		assertTrue(classes[9].equals("Erich Baker"));
		assertTrue(classes[10].equals("Matthew Fendt"));
		assertTrue(classes[11].equals("Peter Maurer"));
		assertTrue(classes[12].equals("William Poucher"));
		assertTrue(classes[13].equals("Michael Aars"));
		assertTrue(classes[14].equals("Richard Sneed"));
		assertTrue(classes[15].equals("Mathew Aars"));
	}
}
