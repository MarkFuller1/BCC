package BNU.logic.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.database.DatabaseConnectionException;
import BNU.logic.UserReviewController;

public class UserReviewService {

	private static final Logger LOGGER = Logger.getLogger(UserReviewService.class.getName());

	static {
		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[][] getReviewsForUser(String userName) {
		return UserReviewController.db.getAllReviewsForUser(userName);

	}
	//- deleteAccount which should delete user access and change name 
	//associated with the user to deleted therefore we dont have to 
	//delete all comments and upvotes associated with this account
	public void deleteAccount(String user) {
		UserReviewController.db.deleteUserAccount(user);
	}
	
	// changeReview has two parameters and should fulfill our use case 
	// of editing a review text which is the new text being passed
	public void changeReview(String reviewID, String text) {
		UserReviewController.db.editReview(reviewID, text);
	}

}
