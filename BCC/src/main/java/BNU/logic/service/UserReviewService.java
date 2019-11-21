package BNU.logic.service;

import BNU.logic.UserReviewController;

public class UserReviewService {
	
	public String[][] getReviewsForUser(String userName){
		return UserReviewController.db.getAllReviewsForUser(userName);
		
	}
	
//	
//	public String[] getProfessorOverallRatings(String professorName) {
//		return UserReviewController.db.getOverallProfessorRatings(professorName);
//	}

}
