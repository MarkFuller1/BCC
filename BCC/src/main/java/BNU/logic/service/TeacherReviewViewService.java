package BNU.logic.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.database.DatabaseConnectionException;
import BNU.logic.ReviewController;

public class TeacherReviewViewService {
	
private static final Logger LOGGER = Logger.getLogger(TeacherReviewViewService.class.getName());
	
	static {
		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[][] getReviewsForTeacherClass(String professorName,String className){
		return ReviewController.db.getAllReviewsForTeacherClass(professorName, className);
		
	}
	
	public String[] getProfessorOverallRatings(String professorName) {
		return ReviewController.db.getOverallProfessorRatings(professorName);
	}
	
	public void flagComment(String reviewId) {
		ReviewController.db.flagReview(reviewId);
	}
}
