package BNU.logic.service;

import BNU.logic.SetReviewController;
import BNU.logic.service.proxy.SmartProxy;

public class SetReviewService {
	
	public void createReview(String userName,String professorName,String className,String content,String TA, String H, String WL){
		SmartProxy sp = new SmartProxy();
		sp.sanatizeAndCreateReview(userName, professorName, className, content, TA, H, WL);
	}

}
