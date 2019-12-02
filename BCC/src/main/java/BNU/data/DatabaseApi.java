package BNU.data;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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

			// stmt.close();

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
	protected boolean validateUserImpl(String userName, String password) throws DatabaseOperationException {
		String sql = "SELECT * FROM users WHERE users.user_name = \'" + userName + "\' AND users.password = \'"
				+ password + "\'";

		try (Statement stmt = con.createStatement();) {

			// Query
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return true;
			}

		} catch (

		SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			throw new DatabaseOperationException(sql);
		}

		return false;
	}

	@Override
	protected String[] getAllProfessorsImpl() throws DatabaseOperationException {
		String sql = "SELECT professor.last_name, professor.first_name FROM professor";
		ResultSet rs = null;
		String name = null;
		ArrayList<String> names = new ArrayList<String>();

		try (Statement stmt = con.createStatement()) {

			// Query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				name = rs.getString(rs.findColumn("first_name"));
				name += " " + rs.getString(rs.findColumn("last_name"));
				names.add(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + sql);
			throw new DatabaseOperationException(sql);
		}

		String[] finalval = new String[names.size()];
		finalval = names.toArray(finalval);
		return finalval;
	}

	@Override
	protected String[] getAllClassesImpl() throws DatabaseOperationException {
		String sql = "SELECT course.title FROM course";
		ResultSet rs = null;
		ArrayList<String> names = new ArrayList<String>();

		// establish connection
		try (Statement stmt = con.createStatement()) {

			// Query
			rs = stmt.executeQuery(sql);

			// stmt.close();

			while (rs.next()) {
				names.add(rs.getString("title"));
			}

			String[] finalval = new String[names.size()];
			finalval = names.toArray(finalval);
			return finalval;

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			throw new DatabaseOperationException(sql);
		}
	}

	@Override
	protected String[] getAllProfessorsForClassImpl(String className) throws DatabaseOperationException {
		String sql = "SELECT first_name, last_name from course, professor_course, professor"
				+ " WHERE course.title = \'" + className + "\'"
				+ " AND course.course_id_pk = professor_course.course_id"
				+ " AND professor.professor_id_pk = professor_course.professor_id";
		ResultSet rs = null;
		ArrayList<String> names = new ArrayList<String>();

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(sql);
			// Query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				names.add(rs.getString("first_name") + " " + rs.getString("last_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + sql);
			throw new DatabaseOperationException(sql);
		}

		String[] finalval = new String[names.size()];
		finalval = names.toArray(finalval);
		return finalval;
	}

	@Override
	protected String[] getAllClassesForProfessorImpl(String prof) throws DatabaseOperationException {
		String sql = "SELECT first_name, last_name from course, professor_course, professor"
				+ " WHERE course.title = \'" + prof + "\'" + " AND course.course_id_pk = professor_course.course_id"
				+ " AND professor.professor_id_pk = professor_course.professor_id";
		ResultSet rs = null;
		ArrayList<String> names = new ArrayList<String>();

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(sql);
			// Query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				names.add(rs.getString("first_name") + " " + rs.getString("last_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + sql);
			throw new DatabaseOperationException(sql);
		}

		String[] finalval = new String[names.size()];
		finalval = names.toArray(finalval);
		return finalval;
	}

	@Override
	protected String[][] getAllTeacherInfoByCourseImpl(String course) throws DatabaseOperationException {
		// name, rating, number of reviews
		String getNames = "select professor.first_name, professor.last_name, review.* "
				+ "FROM review, professor, course, professor_course "
				+ "WHERE professor.professor_id_pk = review.professor_id " + " AND course.title = \'" + course
				+ "\' AND course.course_id_pk = professor_course.course_id "
				+ " AND review.course_id = professor_course.course_id";
		ResultSet namesrs = null;
		String[][] finalVals = null;

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(getNames);
			// Query
			namesrs = stmt.executeQuery(getNames);

			Map<String, ArrayList<Integer>> profRanking = new HashMap<>();

			while (namesrs.next()) {
				String key = namesrs.getString("first_name") + " " + namesrs.getString("last_name");

				ArrayList<Integer> sum = profRanking.getOrDefault(key, new ArrayList<Integer>() {
					{
						add(0);
						add(0);
						add(0);
						add(0);
					}
				});

				sum.set(0, sum.get(0) + namesrs.getInt("teaching_ability"));
				sum.set(1, sum.get(1) + namesrs.getInt("workload"));
				sum.set(2, sum.get(2) + namesrs.getInt("helpfulness"));
				sum.set(3, sum.get(3) + 1);

				profRanking.put(key, sum);

			}

			finalVals = new String[profRanking.size()][4];

			int i = 0;
			for (Entry<String, ArrayList<Integer>> x : profRanking.entrySet()) {
				finalVals[i][0] = x.getKey();
				finalVals[i][1] = Double.toString(x.getValue().get(0) / x.getValue().get(3));
				finalVals[i][2] = Double.toString(x.getValue().get(1) / x.getValue().get(3));
				finalVals[i][3] = Double.toString(x.getValue().get(2) / x.getValue().get(3));
				finalVals[i][1] = Double.toString((Double.parseDouble(finalVals[i][1])
						+ Double.parseDouble(finalVals[i][2]) + Double.parseDouble(finalVals[i][3])) / 3.0);
				finalVals[i][2] = Double.toString(x.getValue().get(3));

				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + getNames);
			throw new DatabaseOperationException(getNames);
		}

		return finalVals;
	}

	@Override
	protected boolean submitCredentialsImpl(String userName, String password) {
		String qurey = "insert into users (user_name, password)" + "values (\'" + userName + "\', \'" + password
				+ "\')";

		try (Statement stmet = con.createStatement()) {
			int rs = stmet.executeUpdate(qurey);

			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected String[][] getAllReviewsForTeacherClassImpl(String professorName, String className) {
		String[][] vals = null;
		String query = "select review.content, (teaching_ability + workload + helpfulness) / 3 as score, user_name FROM review";

		try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			ResultSet rs = stmt.executeQuery(query);

			int rows = 0;
			rs.last();
			rows = rs.getRow();
			rs.beforeFirst();

			vals = new String[rows][3];

			int i = 0;
			while (rs.next()) {
				vals[i][0] = rs.getString("content");
				vals[i][1] = rs.getString("score");
				vals[i][2] = rs.getString("user_name");

				i++;
			}

		} catch (Exception e) {
			LOGGER.warning(query);
			e.printStackTrace();
		}

		return vals;
	}

	@Override
	protected String[] getOverallProfessorRatingsImpl(String professorName) {
		// name, rating, number of reviews
		String[] firstLast = professorName.split(" ");
		String[] result = new String[4];
		String getNames = "SELECT Avg(x.teaching_ability) as ta, Avg(x.workload) as w, "
				+ "       	Avg(x.helpfulness) as h, "
				+ "		  	((avg(x.teaching_ability) + avg(x.workload) + avg(x.helpfulness)) / 3) as avg "
				+ "			FROM   (SELECT review.professor_id,  " + "               review.teaching_ability,  "
				+ "               review.workload,  " + "               review.helpfulness  "
				+ "        FROM   review,  " + "               professor  "
				+ "        	WHERE  professor.first_name = \'" + firstLast[0] + "\'  "
				+ "               AND professor.last_name = \'" + firstLast[1] + "\'  "
				+ "               AND review.professor_id = professor.professor_id_pk) AS x ";
		ResultSet namesrs = null;
		String[][] finalVals = null;

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(getNames);
			// Query
			namesrs = stmt.executeQuery(getNames);
			if (namesrs.next()) {

				result[0] = namesrs.getString("avg");
				result[1] = namesrs.getString("ta");
				result[2] = namesrs.getString("w");
				result[3] = namesrs.getString("h");
			}
		} catch (Exception e) {
			LOGGER.warning(getNames);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	protected String[][] getAllReviewsForUserImpl(String userName) {
		// content score prof course name
		String query = "select content, (teaching_ability + helpfulness + workload) / 3 as avg,  course.title, first_name, last_name  from review, professor, course Where user_name = \'" + userName + "\'  AND review.professor_id = professor.professor_id_pk AND review.course_id = course.course_id_pk";
		ResultSet userReviews = null;
		ArrayList<ArrayList<String>> reviews = new ArrayList<new ArrayList<>()>();

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(query);
			// Query
			userReviews = stmt.executeQuery(query);

			int i = 0;
			if (userReviews.next()) {
				reviews.get(i).set(0, userReviews.getString("content"));
				reviews.get(i).set(1, userReviews.getString("avg"));
				reviews.get(i).set(2, userReviews.getString("first_name") + " " + userReviews.getString("last_name"));
				reviews.get(i).set(3, userReviews.getString("title"));

				i++;
			}
		} catch (Exception e) {
			LOGGER.warning(query);
			e.printStackTrace();
		}
		
		String[][] finalval = new String[reviews.size()][4];
		finalval = reviews.toArray(finalval);
		return finalval;
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

	@Override
	protected String[][] getAllCourseInfoByProfImpl(String profName) throws DatabaseOperationException {
		// name, rating, number of reviews
		String[] firstLast = profName.split(" ");
		String getNames = "select title, professor.first_name, professor.last_name, review.teaching_ability + review.workload + review.helpfulness / 3 as avg\r\n"
				+ "from review, professor, course\r\n" + "WHERE professor.first_name = \'" + firstLast[0] + "\'"
				+ "AND professor.last_name =  \'" + firstLast[1] + "\'"
				+ "AND professor.professor_id_pk = review.professor_id\r\n"
				+ "AND review.course_id = course.course_id_pk";
		ResultSet rs = null;
		String[][] finalVals = null;

		try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			LOGGER.info(getNames);
			// Query
			rs = stmt.executeQuery(getNames);

			int rows = 0;
			rs.last();
			rows = rs.getRow();
			rs.beforeFirst();

			Map<String, ArrayList<Integer>> profRanking = new HashMap<>();

			while (rs.next()) {
				String key = rs.getString("title");

				ArrayList<Integer> sum = profRanking.getOrDefault(key, new ArrayList<Integer>() {
					{
						add(0);
						add(0);
					}
				});

				sum.set(1, sum.get(1) + 1);
				sum.set(0, rs.getInt("avg"));

				profRanking.put(key, sum);

			}

			finalVals = new String[profRanking.size()][4];

			int i = 0;
			for (Entry<String, ArrayList<Integer>> x : profRanking.entrySet()) {
				finalVals[i][0] = x.getKey();
				finalVals[i][1] = Double.toString(x.getValue().get(0) / x.getValue().get(1));
				finalVals[i][2] = Integer.toString(x.getValue().get(1));

				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.warning("Query Failed: " + getNames);
			throw new DatabaseOperationException(getNames);
		}

		return finalVals;
	}

	@Override
	protected String[] getAllFlaggedImpl() {
		// TODO Auto-generated method stub
		return null;
	}

}
