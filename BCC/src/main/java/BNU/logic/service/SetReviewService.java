package BNU.logic.service;

import BNU.logic.SetReviewController;

public class SetReviewService {
	
	public void createReview(String userName,String professorName,String className,String content,String TA, String H, String WL){
		SetReviewController.db.setNewReview(userName,professorName,className,content,TA,H,WL);
		
	}

}
