package BNU.data.database;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import BNU.data.Review;
import BNU.singleton.SingletonSession;

public abstract class AbstractDB {

	Connection con;
	Connection threadCon;

	protected abstract Connection getRemoteConnection() throws DatabaseConnectionException;

	protected abstract void deleteUserAccountImpl(String userId);

	protected abstract boolean validateUserImpl(String userName, String password) throws DatabaseOperationException;

	protected abstract String[] getAllProfessorsImpl() throws DatabaseOperationException;

	protected abstract String[] getAllClassesImpl() throws DatabaseOperationException;

	protected abstract String[] getAllProfessorsForClassImpl(String className) throws DatabaseOperationException;

	protected abstract String[] getAllClassesForProfessorImpl(String prof) throws DatabaseOperationException;

	protected abstract String[][] getAllCourseInfoByProfImpl(String profName) throws DatabaseOperationException;

	protected abstract String[][] getAllTeacherInfoByCourseImpl(String courseName) throws DatabaseOperationException;

	protected abstract boolean submitCredentialsImpl(String userName, String password);

	protected abstract String[][] getAllReviewsForTeacherClassImpl(String professorName, String className);

	protected abstract String[] getOverallProfessorRatingsImpl(String professorName);

	protected abstract String[][] getAllReviewsForUserImpl(String userName);

	// protected abstract String[][] getAllMessagesImpl(String receiver);

	protected abstract String getRecieverImpl();

	protected abstract String getSenderImpl();

	protected abstract String[] getAllUserMessagersImpl(String receiver) throws DatabaseConnectionException;

	protected abstract void upvoteImpl(String reviewId, String userId);

	protected abstract void downvoteImpl(String reviewID, String user);

	protected abstract String[] getAllFlaggedImpl();

	protected abstract Boolean sendMessageImpl(String string, String from, String to, BigInteger i);

	protected abstract Boolean isUpvoteValidImpl(String userId, String reviewId) throws DatabaseOperationException;

	protected abstract Boolean isDownvoteValidImpl(String reviewID, String user) throws DatabaseOperationException;

	protected abstract int getNumberOfMessagesForUserImpl(String user) throws DatabaseOperationException;

	protected abstract String[][] getAllMessagesImpl(String sender, String receiver);

	public final boolean validateUser(String userName, String password) {
		try {

			con = getRemoteConnection();

			boolean res = validateUserImpl(userName, password);

			if (con != null) {
				con.close();
			}

			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public final String[] getAllProfessors() {
		try {
			con = getRemoteConnection();

			String[] profList = getAllProfessorsImpl();

			if (con != null) {
				con.close();
			}

			return profList;
		} catch (DatabaseConnectionException | SQLException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final String[] getAllClasses() {
		try {
			con = getRemoteConnection();

			String[] classList = getAllClassesImpl();

			if (con != null) {
				con.close();
			}

			return classList;
		} catch (SQLException | DatabaseConnectionException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new String[1];
		}
	}

	public final String[] getAllProfessorsForClass(String className) {
		try {
			con = getRemoteConnection();

			String[] profList = getAllProfessorsForClassImpl(className);

			if (con != null) {
				con.close();
			}

			return profList;

		} catch (DatabaseOperationException | DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	Professor getProfessor(String Prof) {
//		con = getRemoteConnection();
//		
//		
//		
//		if(con != null) {if(con != null) {con.close();}};
//	}

	public final String[] getAllClassesForProfessor(String professorName) {
		try {
			con = getRemoteConnection();

			String[] classList = getAllClassesForProfessorImpl(professorName);

			if (con != null) {
				con.close();
			}

			return classList;

		} catch (DatabaseConnectionException | SQLException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

//	Course getCourse(String course) {
//		return null;
//	}

	public final String[][] getAllCoursesByProf(String courseNames) {
		try {
			con = getRemoteConnection();

			String[][] courseslist = getAllCourseInfoByProfImpl(courseNames);

			if (con != null) {
				con.close();
			}

			return courseslist;

		} catch (DatabaseConnectionException | SQLException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final String[][] getAllTeacherInfoByCourse(String professorNames) {
		try {
			con = getRemoteConnection();

			String[][] teachersByCourse = getAllTeacherInfoByCourseImpl(professorNames);

			if (con != null) {
				con.close();
			}

			return teachersByCourse;
		} catch (DatabaseConnectionException | SQLException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public final boolean submitCredentials(String userName, String password) {
		try {
			con = getRemoteConnection();

			boolean res = submitCredentialsImpl(userName, password);

			if (con != null) {
				con.close();
			}

			return res;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// return array of review content,score,reviewerID
	public final String[][] getAllReviewsForTeacherClass(String professorName, String className) {
		try {
			con = getRemoteConnection();

			String[][] reviewList = getAllReviewsForTeacherClassImpl(professorName, className);

			if (con != null) {
				con.close();
			}

			return reviewList;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// return in this order: overall score, helpfulness, teaching ability, workload
	public final String[] getOverallProfessorRatings(String professorName) {
		try {
			con = getRemoteConnection();

			String[] profRating = getOverallProfessorRatingsImpl(professorName);

			if (con != null) {
				con.close();
			}

			return profRating;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// return review content, score, reviewerID, course name
	public final String[][] getAllReviewsForUser(String userName) {
		try {
			con = getRemoteConnection();

			String[][] reviews = getAllReviewsForUserImpl(userName);

			if (con != null) {
				con.close();
			}

			return reviews;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// my added functions
	public final String[][] getAllMessages(String sender, String receiver) {
		try {
			con = getRemoteConnection();

			// why is the Impl version being called here? See Mark.
			String[][] messages = getAllMessagesImpl(sender, receiver);
			if (con != null) {
				con.close();
			}
			return messages; // added

		} catch (SQLException | DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public final String[] getAllFlagged() {
		try {
			con = getRemoteConnection();

			String[] flagged = getAllFlaggedImpl();

			if (con != null) {
				con.close();
			}

			return flagged;

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final String getReceiver() {
		try {
			con = getRemoteConnection();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String reciever = getRecieverImpl();

		try {
			if (con != null) {
				if (con != null) {
					con.close();
				}
			}
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reciever;
	}

//	public final String getSender() throws SQLException {
//		con = getRemoteConnection();
//
//		String sender = getSenderImpl();
//
//		if(con != null) {if(con != null) {con.close();}};
//
//		return sender;
//	}
//
	public final String[] getAllUserMessagers(String receiver) {

		try {
			con = getRemoteConnection();

			String[] friends = getAllUserMessagersImpl(receiver);

			if (con != null) {
				con.close();
			}

			return friends;

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final void upvote(String ReviewID, String user) throws SQLException {
		try {
			con = getRemoteConnection();

			upvoteImpl(ReviewID, user);

			if (con != null) {
				con.close();
			}

		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void downvote(String ReviewID, String user) throws SQLException {
		try {
			con = getRemoteConnection();

			downvoteImpl(ReviewID, user);

			if (con != null) {
				con.close();
			}

		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final Boolean sendMessage(String string, String from, String to, BigInteger i) {
		try {
			con = getRemoteConnection();

			Boolean friends = sendMessageImpl(string, from, to, i);

			if (con != null) {
				con.close();
			}

			return friends;

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//
	public final ArrayList<Review> getReviews(String prof, String c) {
		return null;
	}

	public final Boolean isUpvoteValid(String ReviewID, String user) {
		try {
			con = getRemoteConnection();

			Boolean friends = isUpvoteValidImpl(ReviewID, user);

			if (con != null) {
				con.close();
			}

			return friends;

		} catch (DatabaseConnectionException | SQLException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final Boolean isDownvoteValid(String ReviewID, String user) {
		try {
			con = getRemoteConnection();

			Boolean friends = isDownvoteValidImpl(ReviewID, user);

			if (con != null) {
				con.close();
			}

			return friends;

		} catch (DatabaseConnectionException | SQLException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setNewReview(String userName, String professorName, String className, String content, String tA,
			String h, String wL) {

	}

	public boolean isAdmin(String userName) {
		return false;
	}

	public int getNumberOfMessagesForUser(String user) {
		try {
			threadCon = getRemoteConnection();

			int num = getNumberOfMessagesForUserImpl(user);

			if (threadCon != null) {
				threadCon.close();
			}

			return num;

		} catch (DatabaseConnectionException | SQLException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public final void deleteUserAccount(String user) {
		try {
			con = getRemoteConnection();

			deleteUserAccountImpl(user);

			if (con != null) {
				con.close();
			}

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
