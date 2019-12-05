package BNU.logic.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.logic.AdminController;
import BNU.logic.UserReviewController;

public class AdminService {
	private static final Logger LOGGER = Logger.getLogger(AdminService.class.getName());

	static {
		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getting all flagged should return me a 2d array holding the reviewID flagged
	// as well as the class, prof, and student associated with review ID
	public String[][] getAllFlagged() {
		return AdminController.getDb().getAllFlagged();
	}

	// this is for deleting review when admin deems the review as inappropriate
	public void deleteReview(String reviewId) {
		AdminController.getDb().deleteReivew(reviewId);
	}

	// this is for keeping review and removing the flag status
	public void removeFlagOnReview(String reviewId) {
		AdminController.getDb().removeFlagOnReview(reviewId);
	}

}
