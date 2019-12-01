package BNU.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.singleton.SingletonSession;

public class DatabaseApi implements dbWrapper {
	private static final Logger LOGGER = Logger.getLogger(DatabaseApi.class.getName());

	static {

		try {
			LOGGER.addHandler(new FileHandler("database.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Connection getRemoteConnection() { 
		if (System.getenv("RDS_HOSTNAME") != null) {
			try {
				Class.forName("org.postgresql.Driver");
				String dbName = "postgres";
				String userName = "postgres";
				String password = "aspartame";
				String hostname = "postgres.c5lgn5tcwkdn.us-east-2.rds.amazonaws.com";
				String port = "5432";
				String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName
						+ "&password=" + password;
				LOGGER.fine("Establishing Connection");
				Connection con = DriverManager.getConnection(jdbcUrl);
				LOGGER.fine("Remote connection successful.");
				return con;
			} catch (ClassNotFoundException e) {
				LOGGER.warning(e.toString());
			} catch (SQLException e) {
				LOGGER.warning(e.toString());
			}
		}
		return null;
	}

	@Override
	public String[] getAllProfessors() {
		String[] prof = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT name FROM professors";
			ResultSet result = stmt.executeQuery(sql);

			// Parse Query into string array
			while (result.next()) {
				String entry = result.getString("name");
				prof = entry.split("\n");
				for (int i = 0; i < prof.length; i++) {
					System.out.println(prof[i]);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return prof;
	}

	@Override
	public String[] getAllClasses() {
		String[] courses = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT title FROM courses";
			ResultSet result = stmt.executeQuery(sql);

			// Parse Query into string array
			while (result.next()) {
				String entry = result.getString("title");
				courses = entry.split("\n");
				for (int i = 0; i < courses.length; i++) {
					System.out.println(courses[i]);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return courses;
	}

	@Override
	public String[] getAllProfessorsForClass(String className) {
		String[] professors = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT professor_course.idc FROM courses, professor_course WHERE course.idc = professor_course.idc AND course.name = "
					+ className; // the SQl here is logically correct but the names of tables and rows and
									// columns need to change
			ResultSet result = stmt.executeQuery(sql);

			// Parse Query into string array
			while (result.next()) {
				String entry = result.getString("name");
				professors = entry.split("\n");
				for (int i = 0; i < professors.length; i++) {
					System.out.println(professors[i]);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return professors;
	}

	@Override
	public Professor getProfessor(String Prof) {
		String professorData = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM professors WHERE professor.name = " + Prof; // the SQl here is logically correct
																					// but the names of tables and rows
																					// and columns need to change
			ResultSet result = stmt.executeQuery(sql);

			// Parse Query into string array
			String entry = result.getString("name");
			professorData = entry.split("\n")[0]; // this probably can be improved
			System.out.println(professorData);
			Professor retrieved = new Professor(result);

			stmt.close();
			con.close();
			
			return retrieved;
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return null;
	}

	@Override
	public String[] getAllClassesForProfessor(String professorName) {
		String[] courses = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT professor_course.idc FROM professors, professor_course WHERE professors.idc = professor_course.idc AND professors.name = "
					+ professorName; // the SQl here is logically correct but the names of tables and rows and
										// columns need to change
			ResultSet result = stmt.executeQuery(sql);

			// Parse Query into string array
			while (result.next()) {
				String entry = result.getString("courses");
				courses = entry.split("\n");
				for (int i = 0; i < courses.length; i++) {
					System.out.println(courses[i]);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return courses;
	}

	@Override
	public Course getCourse(String course) {
		String[] courses = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM courses "; // the SQl here is logically correct but the names of tables and rows and
										// columns need to change
			ResultSet result = stmt.executeQuery(sql);

			// Parse Query into string array
			while (result.next()) {
				String entry = result.getString("courses");
				courses = entry.split("\n");
				for (int i = 0; i < courses.length; i++) {
					System.out.println(courses[i]);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return null;
	}

	@Override
	public boolean validateUser(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override

	//public String[][] getAllCoursesByProf(String[] courses) {

	public String[][] getAllMessages(String sender, String receiver) {
		//ArrayList<Message> messages = new ArrayList<>();
		String[][] messages = null;
		
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// implement sql here
			// this returns an array of messages between the same two users, given a receiver and sender
			// message class has a sender, receiver (both referring to user names), timestamp, and the message itself

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return messages;
	}

	@Override
	public String[] getAllFlagged() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//public String[][] getAllTeachersByCourse(String[] professorNames) {
	public String[] getAllUserMessagers(String receiver) {
		
		String[] users = null;
		
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// implement sql here
			// this returns an array users that the receiver has messages between
			// will fill up the left column of the messageboard
			// message class has a sender, receiver (both referring to user names), timestamp, and the message itself

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return users;
	}

	@Override
	public String getReceiver() {
		return SingletonSession.getInstance().getUserName();
	}

	@Override

	public boolean submitCredentials(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	//public String[][] getAllReviewsForTeacherClass(String professorName, String className) {

	public String getSender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upvote() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downvote() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Review> getReviews(String prof, String c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

	//public String[] getOverallProfessorRatings(String professorName) {

	public Boolean isUpvoteValid() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override

	public String[][] getAllReviewsForUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isDownvoteValid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(Message m) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public java.lang.String[][] getAllTeachersByCourse(java.lang.String[] professorNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.lang.String[][] getAllReviewsForTeacherClass(java.lang.String professorName,
			java.lang.String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.lang.String[] getOverallProfessorRatings(java.lang.String professorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getAllCoursesByProf(String[] courses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNewReview(String userName, String professorName, String className, String content, String tA,
			String h, String wL) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAdmin(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

}
