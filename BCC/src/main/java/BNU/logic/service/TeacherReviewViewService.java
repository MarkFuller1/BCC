package BNU.logic.service;

import BNU.logic.ReviewController;

public class TeacherReviewViewService {

	public String[][] getReviewsForTeacherClass(String professorName,String className){
		return ReviewController.db.getAllReviewsForTeacherClass(professorName, className);
		
	}
	
	public String[] getProfessorOverallRatings(String professorName) {
		return ReviewController.db.getOverallProfessorRatings(professorName);
	}
}
