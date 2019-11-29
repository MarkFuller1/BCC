package BNU.logic.service;

import java.util.List;

import javax.swing.JComponent;

import BNU.data.Course;
import BNU.logic.ClassByTeacherController;

public class ClassByTeacherService {
	
	public String[] getAllClassesByTeacherService(String professorName){
		 
		return ClassByTeacherController.db.getAllClassesForProfessor(professorName);
		
	}
	
	//TODO: why does classNames need to be passed into the function?
	public Course[] getAllCoursesByTeacherService(String[] classNames, String professorName) {
		String[][] courseObjs = ClassByTeacherController.db.getAllCoursesByProf(classNames);
		Course[] courses = new Course[classNames.length];
		String[] whyIsThisHere = null;
		
		for(int i = 0; i < courseObjs.length; i++) {
			courses[i] = new Course(courseObjs[i][0],courseObjs[i][1],courseObjs[i][2], whyIsThisHere);
		}
		
		return courses;
	}

}
