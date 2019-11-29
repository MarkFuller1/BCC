package BNU.data;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseApi extends AbstractDB {
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

	private final ResultSet executeStatement(String query) throws DatabaseOperationException {
		ResultSet result = null;
		// establish connection
		try (Statement stmt = con.createStatement()) {

			// Query
			result = stmt.executeQuery(query);

			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			throw new DatabaseOperationException(query);
		}

		return result;
	}

	@Override
	protected Connection getRemoteConnection() throws DatabaseConnectionException {

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
			throw new DatabaseConnectionException("Java JDBC Driver is not Found");
		} catch (SQLException e) {
			LOGGER.warning(e.toString());
			throw new DatabaseConnectionException(
					"The database connection was unsuccessful, please contact your system admin");
		}
	}

	@Override
	protected boolean validateUserImpl(String userName, String password) {

		String sql = "SELECT * FROM users WHERE user.username = \'" + userName + "\' AND user.password = \'" + password
				+ "\'";
		ResultSet rs = null;

		try {
			rs = executeStatement(sql);

			if (rs.next()) {
				return true;
			}

		} catch (DatabaseOperationException | SQLException e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + sql);
		}

		return false;
	}

	@Override
	protected String[] getAllProfessorsImpl() {
		String sql = "SELECT professor.last_name, professor.first_name FROM professor";
		ResultSet rs = null;
		String name = null;
		ArrayList<String> names = new ArrayList<String>();

		try {
			rs = executeStatement(sql);

			while(rs.next()) {
				name = rs.getString(rs.findColumn("first_name"));
				name += rs.getString(rs.findColumn("last_name"));
				names.add(name);
			}

		} catch (DatabaseOperationException | SQLException e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + sql);
		}

		return (String[]) names.toArray();
	}

	@Override
	protected String[] getAllClassesImpl() {
		String sql = "SELECT course.title FROM course";
		ResultSet rs = null;
		ArrayList<String> names = new ArrayList<String>();

		try {
			rs = executeStatement(sql);

			while(rs.next()) {
				  names.add(rs.getString("title"));
				}	

		} catch (DatabaseOperationException | SQLException e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + sql);
		}

		return (String[]) names.toArray();
	}

	@Override
	protected String[] getAllProfessorsForClassImpl(String className) {
		String sql = "SELECT first_name, last_name from course, professor_course, professor" + 
				"WHERE course.title = \'" + className + "\'" +  
				"AND course.course_id_pk = professor_course.course_id" + 
				"AND professor.professor_id_pk = professor_course.professor_id";
		ResultSet rs = null;
		ArrayList<String> names = new ArrayList<String>();

		try {
			rs = executeStatement(sql);

			while(rs.next()) {
				  names.add(rs.getString("first_name") + " " + rs.getString("last_name"));
				}	

		} catch (DatabaseOperationException | SQLException e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + sql);
		}

		return (String[]) names.toArray();
	}

	@Override
	protected String[] getAllClassesForProfessorImpl(String prof) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[][] getAllCoursesByProfImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[][] getAllTeachersByCourseImpl(String[] professorNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean submitCredentialsImpl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String[][] getAllReviewsForTeacherClassImpl(String professorName, String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getOverallProfessorRatingsImpl(String professorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[][] getAllReviewsForUserImpl(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Message[] getAllMessagesImpl(String sender, String receiver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getRecieverImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSenderImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getAllUserMessagersImpl(String receiver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void upvoteImpl() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void downvoteImpl() {
		// TODO Auto-generated method stub

	}

}
