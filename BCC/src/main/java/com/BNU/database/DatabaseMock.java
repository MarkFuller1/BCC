package com.BNU.database;

import java.awt.LayoutManager;
import java.util.ArrayList;

import com.BNU.pages.classesByTeacher.Course;
import com.BNU.pages.teachersByClass.Professor;

public class DatabaseMock implements dbWrapper{
	
	@Override
	public String[] getAllProfessors() {
		String [] professors = new String[3];
		professors[0] = "Professor one";
		professors[1] = "Professor two";
		professors[2] = "Professor three";
		
		return professors;
	}

	@Override
	public String[] getAllClasses() {
		String [] classes = new String[3];
		classes[0] = "class one";
		classes[1] = "class two";
		classes[2] = "class three";
		
		return classes;
	}

	@Override
	public String[] getPossibleClasses() {
		String [] classes = new String[16];
		classes[0] = "CSI 1430";
		classes[1] = "CSI 1440";
		classes[2] = "CSI 2350";		
		classes[3] = "CSI 2334";
		classes[4] = "CSI 3334";
		classes[5] = "CSI 3471";		
		classes[6] = "CSI 3344";
		classes[7] = "CSI 3336";
		classes[8] = "CSI 3335";		
		classes[9] = "CSI 3372";
		classes[10] = "CSI 3439";
		classes[11] = "CSI 4337";	
		classes[12] = "CSI 4321";
		classes[13] = "PHI 1310";
		classes[14] = "CSI 43C9";
		classes[15] = "CSI 4330";
		return classes;
	}

	public String[] getAllProfessorsForClass(String className) {
		String [] a = {"Professor one", "Professor two", "Professor three"};
		String [] b = {"Professor one", "Professor two", "Professor three"};
		String [] c = {"Professor one", "Professor two", "Professor three"};
		
		switch(className) {
		case "class one":
			return a;
		case "class two":
			return b;
		case "class three":
			return c;
		}
		return null;
	}

	@Override
	public Professor getProfessor(String prof) {
		ArrayList<Professor> profs = new ArrayList<>();
		String [] courses = {"class one", "class two", "class three"};
		
		profs.add(new Professor("Professor one",  "99", "4", courses));
		profs.add(new Professor("Professor two",  "99", "4", courses));
		profs.add(new Professor("Professor three",  "99", "4", courses));
		
		switch(prof) {
		case "Professor one":
			return profs.get(0);
		case "Professor two":
			return profs.get(1);
		case "Professor three":
			return profs.get(2);
			
		}
		return null;
	}

	@Override
	public String[] getAllClassesForProfessor(String professorName) {
		String [] a = {"class one", "class two", "class three"};
		String [] b = {"class one", "class two", "class three"};
		String [] c = {"class one", "class two", "class three"};
		System.out.println(professorName);
		switch(professorName) {
		case "class one":
			return a;
		case "Professor two":
			return b;
		case "Professor three":
			return c;
		}
		return null;
	}
	
	@Override
	public Course getCourse(String course) {
		ArrayList<Course> courses = new ArrayList<>();
		String [] profs = {"Professor one", "Professor two", "Professor three"};
		
		courses.add(new Course("class one",  "99", "4", profs));
		courses.add(new Course("class two",  "99", "4", profs));
		courses.add(new Course("class three",  "99", "4", profs));
		
		switch(course) {
		case "class one":
			return courses.get(0);
		case "class two":
			return courses.get(1);
		case "class three":
			return courses.get(2);
			
		}
		return null;
	}
}
