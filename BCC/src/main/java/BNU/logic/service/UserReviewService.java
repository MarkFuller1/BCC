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
	
	public void deleteAccount(String user) {
		//UserReviewController.db.deleteUserAccount(user);
	}
	

}
