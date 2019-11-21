package BNU.logic.service;

import BNU.data.Course;
import BNU.data.Professor;
import BNU.logic.ClassByTeacherController;
import BNU.logic.TeachersByClassController;

public class TeacherByClassService {

	public String[] getAllTeachersByClassService(String courseName){
		 
		return ClassByTeacherController.db.getAllProfessorsForClass(courseName);
		
	}
	
	public Professor[] getAllProfessorsByCourseService(String[] professorNames, String courseName) {
		String[][] professorObjs = TeachersByClassController.db.getAllTeachersByCourse(professorNames);
		Professor[] professors = new Professor[professorNames.length];
		String[] whyIsThisHere = null;
		
		
		for(int i = 0; i < professorObjs.length; i++) {
			professors[i] = new Professor(professorObjs[i][0],professorObjs[i][1],professorObjs[i][2], whyIsThisHere);
		}
		
		return professors;
	}
	
}
