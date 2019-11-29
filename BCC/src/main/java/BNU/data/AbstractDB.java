package BNU.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractDB {

	Connection con;

	protected abstract Connection getRemoteConnection() throws DatabaseConnectionException;

	protected abstract boolean validateUserImpl(String userName, String password);

	protected abstract String[] getAllProfessorsImpl();

	protected abstract String[] getAllClassesImpl();

	protected abstract String[] getAllProfessorsForClassImpl(String className);

	protected abstract String[] getAllClassesForProfessorImpl(String prof);

	protected abstract String[][] getAllCoursesByProfImpl();

	protected abstract String[][] getAllTeachersByCourseImpl(String[] professorNames);

	protected abstract boolean submitCredentialsImpl();

	protected abstract String[][] getAllReviewsForTeacherClassImpl(String professorName, String className);

	protected abstract String[] getOverallProfessorRatingsImpl(String professorName);

	protected abstract String[][] getAllReviewsForUserImpl(String userName);

	protected abstract Message[] getAllMessagesImpl(String sender, String receiver);

	protected abstract String getRecieverImpl();

	protected abstract String getSenderImpl();
	
	protected abstract String[] getAllUserMessagersImpl(String receiver);
	
	protected abstract void upvoteImpl();
	
	protected abstract void downvoteImpl();

	public final boolean validateUser(String userName, String password) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		boolean res = validateUserImpl( userName, password);

		con.close();

		return res;

	}

	public final String[] getAllProfessors() throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[] profList = getAllProfessorsImpl();

		con.close();

		return profList;
	}

	public final String[] getAllClasses() throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[] classList = getAllClassesImpl();

		con.close();

		return classList;
	}

	public final String[] getAllProfessorsForClass(String className) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[] profList = getAllProfessorsForClassImpl(className);

		con.close();

		return profList;
	}

//	Professor getProfessor(String Prof) {
//		con = getRemoteConnection();
//		
//		
//		
//		con.close();
//	}

	public final String[] getAllClassesForProfessor(String professorName) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[] classList = getAllClassesForProfessorImpl(professorName);

		con.close();

		return classList;

	}

//	Course getCourse(String course) {
//		return null;
//	}

	public final String[][] getAllCoursesByProf(String[] courseNames) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[][] courseslist = getAllCoursesByProfImpl();

		con.close();

		return courseslist;
	}

	public final String[][] getAllTeachersByCourse(String[] professorNames) throws DatabaseConnectionException, SQLException {
		con = getRemoteConnection();

		String[][] teachersByCourse = getAllTeachersByCourseImpl(professorNames);

		con.close();

		return teachersByCourse;
	}

	public final boolean submitCredentials(String userName, String password) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		boolean res = submitCredentialsImpl();

		con.close();

		return res;
	}

	// return array of review content,score,reviewerID
	public final String[][] getAllReviewsForTeacherClass(String professorName, String className) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[][] reviewList = getAllReviewsForTeacherClassImpl(professorName, className);

		con.close();

		return reviewList;
	}

	// return in this order: overall score, helpfulness, teaching ability, workload
	public final String[] getOverallProfessorRatings(String professorName) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[] profRating = getOverallProfessorRatingsImpl(professorName);

		con.close();

		return profRating;
	}

	// return review content, score, reviewerID, course name
	public final String[][] getAllReviewsForUser(String userName) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[][] reviews = getAllReviewsForUserImpl(userName);

		con.close();

		return reviews;
	}

	// my added functions
	public final ArrayList<Message> getAllMessages(String sender, String receiver) throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		Message[] reviews = getAllMessagesImpl(sender, receiver);

		con.close();

		return new ArrayList<Message>(Arrays.asList(reviews));
	}

	public final String[] getAllFlagged() throws SQLException, DatabaseConnectionException {
		con = getRemoteConnection();

		String[] flagged = getAllFlagged();

		con.close();

		return flagged;
	}

//	public final String getReceiver() throws SQLException {
//		con = getRemoteConnection();
//
//		String reciever = getRecieverImpl();
//
//		con.close();
//
//		return reciever;
//	}
//
//	public final String getSender() throws SQLException {
//		con = getRemoteConnection();
//
//		String sender = getSenderImpl();
//
//		con.close();
//
//		return sender;
//	}
//
//	public final String[] getAllUserMessagers(String receiver) throws SQLException {
//		con = getRemoteConnection();
//
//		String[] friends = getAllUserMessagersImpl(receiver);
//
//		con.close();
//
//		return friends;
//	}
//
//	
//
//	public final void upvote() throws SQLException {
//		con = getRemoteConnection();
//
//		upvoteImpl();
//
//		con.close();
//	}
//
//	
//
//	public final void downvote() throws SQLException {
//		con = getRemoteConnection();
//
//		downvoteImpl();
//
//		con.close();
//	}
//
//	public final void sendMessage(Message m) {
//		
//	}
//
//	public final ArrayList<Review> getReviews(String prof, String c);
//
//	public final Boolean isUpvoteValid();
//
//	public final Boolean isDownvoteValid();

}
