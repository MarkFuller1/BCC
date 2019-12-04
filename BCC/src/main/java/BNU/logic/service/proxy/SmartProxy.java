package BNU.logic.service.proxy;

import java.math.BigInteger;

import BNU.data.Message;
import BNU.logic.LoginController;
import BNU.logic.MessageBoardController;
import BNU.logic.ReviewController;

public class SmartProxy {
		
	public String sanatizeInput(String input) {
		String clean = input.replaceAll("'", "");
		clean = clean.replaceAll("\\\\", "");
		clean = clean.replaceAll(";", "");
		clean = clean.replaceAll("`", "");
		return clean;
	}
	
	public boolean sanatizeAndCheckCreds(String userName, String password) {
		boolean isValidated = false;
		String cleanUN = sanatizeInput(userName);
		String cleanPW = sanatizeInput(password);
		System.out.println(cleanUN + " " + cleanPW);
		isValidated = LoginController.db.validateUser(cleanUN, cleanPW);
		return isValidated;
	}
	
	public boolean sanatizeAndCheckIsAdmin(String userName) {
		boolean isAdmin = false;
		String cleanUN = sanatizeInput(userName);
		//confirm how I should be getting the db
		if(LoginController.db.isAdmin(cleanUN)) {
			isAdmin = true;
		}
		return isAdmin;
	}
	
	public void sanatizeAndSendMessage(String message, String from, String to, BigInteger date) {
		message = sanatizeInput(message);
		MessageBoardController.db.sendMessage(message, from, to, date);
	}
	
	public void sanatizeAndCreateReview(String userName,String professorName,String className,
			String content,String TA, String H, String WL) {
		String cleanContent = sanatizeInput(content);
		ReviewController.db.setNewReview(userName, professorName, className, cleanContent, TA, H, WL);
	}
	

}
