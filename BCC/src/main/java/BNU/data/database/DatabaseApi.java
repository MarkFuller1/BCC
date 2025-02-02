package BNU.data.database;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.SecureRandom;

import BNU.singleton.SingletonSession;

public class DatabaseApi extends AbstractDB {
	private static final Logger LOGGER = Logger.getLogger(DatabaseApi.class.getName());

	static {

		try {
			LOGGER.addHandler(new FileHandler("database.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
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
			LOGGER.info(sql);
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
			LOGGER.info(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				name = rs.getString(rs.findColumn("first_name"));
				name += " " + rs.getString(rs.findColumn("last_name"));
				names.add(name);
			}

		} catch (SQLException e) {
			LOGGER.warning(e.getMessage());
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
			LOGGER.info(sql);
			rs = stmt.executeQuery(sql);

			// stmt.close();

			while (rs.next()) {
				names.add(rs.getString("title"));
			}

			String[] finalval = new String[names.size()];
			finalval = names.toArray(finalval);
			return finalval;

		} catch (SQLException e) {
			LOGGER.warning(e.getMessage());
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

			// Query
			LOGGER.info(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				names.add(rs.getString("first_name") + " " + rs.getString("last_name"));
			}

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
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

			// Query
			LOGGER.info(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				names.add(rs.getString("first_name") + " " + rs.getString("last_name"));
			}

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(sql);
		}

		String[] finalval = new String[names.size()];
		finalval = names.toArray(finalval);
		return finalval;
	}

	@SuppressWarnings("serial")
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

			// Query
			LOGGER.info(getNames);
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
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(getNames);
		}

		return finalVals;
	}

	@Override
	protected boolean submitCredentialsImpl(String userName, String password) throws DatabaseOperationException {
		String qurey = "insert into users (user_name, password)" + "values (\'" + userName + "\', \'" + password
				+ "\')";

		try (Statement stmet = con.createStatement()) {
			LOGGER.info(qurey);
			int rs = stmet.executeUpdate(qurey);

			return rs > 0;
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(qurey);
		}
	}

	@Override
	protected String[][] getAllReviewsForTeacherClassImpl(String professorName, String className)
			throws DatabaseOperationException {
		String[][] vals = null;
		String firstLast[] = professorName.split(" ");
		String query = "select content, review.score as score, user_name, review_id_pk  "
				+ "FROM review, professor, course  " + "WHERE professor.first_name = \'" + firstLast[0] + "\'  "
				+ "AND professor.last_name = \'" + firstLast[1] + "\'  "
				+ "AND professor_id = professor.professor_id_pk  " + "AND course.title = \'" + className + "\'  "
				+ "AND review.course_id = course.course_id_pk";

		try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			LOGGER.info(query);
			ResultSet rs = stmt.executeQuery(query);

			int rows = 0;
			rs.last();
			rows = rs.getRow();
			rs.beforeFirst();

			vals = new String[rows][4];

			int i = 0;
			while (rs.next()) {
				vals[i][0] = rs.getString("content");
				vals[i][1] = rs.getString("score");
				vals[i][2] = rs.getString("user_name");
				vals[i][3] = rs.getString("review_id_pk");

				i++;
			}

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}

		return vals;
	}

	@SuppressWarnings("unused")
	@Override
	protected String[] getOverallProfessorRatingsImpl(String professorName) throws DatabaseOperationException {
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
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(getNames);
		}
		return result;
	}

	@Override
	protected String[][] getAllReviewsForUserImpl(String userName) throws DatabaseOperationException {
		// content score prof course name
		String query = "select content, (teaching_ability + helpfulness + workload) / 3 as avg,  course.title, first_name, last_name, review_id_pk  from review, professor, course Where user_name = \'"
				+ userName
				+ "\'  AND review.professor_id = professor.professor_id_pk AND review.course_id = course.course_id_pk";
		ResultSet userReviews = null;
		ArrayList<ArrayList<String>> reviews = new ArrayList<>();

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(query);
			// Query
			userReviews = stmt.executeQuery(query);

			int i = 0;
			while (userReviews.next()) {

				reviews.add(new ArrayList<String>());
				reviews.get(i).add(0, userReviews.getString("content"));
				reviews.get(i).add(1, userReviews.getString("avg"));
				reviews.get(i).add(2, userReviews.getString("first_name") + " " + userReviews.getString("last_name"));
				reviews.get(i).add(3, userReviews.getString("title"));
				reviews.get(i).add(4, userReviews.getString("review_id_pk"));

				i++;
			}
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}

		String[][] finalData;

		finalData = new String[reviews.size()][];

		for (int i = 0; i < reviews.size(); i++) {
			ArrayList<String> row = reviews.get(i);

			// Perform equivalent `toArray` operation
			String[] copy = new String[row.size()];
			for (int j = 0; j < row.size(); j++) {
				// Manually loop and set individually
				copy[j] = row.get(j);
			}

			finalData[i] = copy;
		}
		return finalData;
	}

	// @Override

//	protected String[][] getAllMessagesImpl(String receiver) {
////		// text timestamp sender reciever
////		String query = "select message.message, date_sent, from_user_name, to_user_name from message "
////				+ "where from_user_name = \'" + receiver + "\' OR to_user_name = \'" + receiver + "\'";
////		ResultSet userReviews = null;
////		ArrayList<ArrayList<String>> reviews = new ArrayList<>();
////
////		try (Statement stmt = con.createStatement()) {
////
////			LOGGER.info(query);
////			// Query
////			userReviews = stmt.executeQuery(query);
////
////			int i = 0;
////			while (userReviews.next()) {
////
////				reviews.add(new ArrayList<String>());
////				reviews.get(i).add(0, userReviews.getString("message"));
////				reviews.get(i).add(1, userReviews.getString("date_sent"));
////				reviews.get(i).add(2, userReviews.getString("from_user_name"));
////				reviews.get(i).add(3, userReviews.getString("to_user_name"));
////
////				i++;
////			}
////		} catch (Exception e) {
////			LOGGER.warning(query);
////			e.printStackTrace();
////		}
////
////		String[][] finalData;
////
////		finalData = new String[reviews.size()][];
////
////		for (int i = 0; i < reviews.size(); i++) {
////			ArrayList<String> row = reviews.get(i);
////
////			// Perform equivalent `toArray` operation
////			String[] copy = new String[row.size()];
////			for (int j = 0; j < row.size(); j++) {
////				// Manually loop and set individually
////				copy[j] = row.get(j);
////			}
////
////			finalData[i] = copy;
////		}
////		return finalData;
//	}

	@SuppressWarnings("static-access")
	@Override
	protected String getRecieverImpl() {
		return SingletonSession.getInstance().getUserName();
	}

	@Override
	protected String getSenderImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	protected String[] getAllUserMessagersImpl(String receiver) throws DatabaseOperationException {
		// text timestamp sender reciever
		String query = "select message.from_user_name, message.to_user_name from message " + "where to_user_name = \'"
				+ receiver + "\' OR message.from_user_name = \'" + receiver + "\'";
		ResultSet userReviews = null;
		ArrayList<String> names = new ArrayList<>();

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(query);
			// Query
			userReviews = stmt.executeQuery(query);

			int i = 0;
			while (userReviews.next()) {

				names.add(userReviews.getString("from_user_name"));
				names.add(userReviews.getString("to_user_name"));

				i++;
			}
		} catch (Exception e) {
//			con = getRemoteConnection();
//			return getAllUserMessagersImpl(receiver);

			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}

		String[] finalval = new String[names.size()];
		finalval = names.toArray(finalval);
		return finalval;
	}

	@SuppressWarnings("unused")
	@Override
	protected void downvoteImpl(String reviewId, String userId) throws DatabaseOperationException {
		LOGGER.warning("");
//		String query = "INSERT INTO user_review (user_id, review_id, up_dn) values (\'" + userId + "\', \'" + reviewId
//				+ "\', \'" + -1 + "\') ON conflict (user_id, review_id) do update set up_dn = excluded.up_dn - 1";
		LOGGER.warning("");
		boolean update = false;
//		String query = "INSERT INTO user_review (user_id, review_id, up_dn) values (\'" + userId + "\', \'" + reviewId + "\', \'" + 1 + "\') "
//				+ "ON conflict (user_id, review_id) do begin if(excluded.up_dn < 1) then update set up_dn = excluded.up_dn + 1; end if;";
		String query = "SELECT * from user_review WHERE user_id = \'" + userId + "\' AND review_id = \'" + reviewId
				+ "\'";
		String updateQ = null;
		String updateScore = "UPDATE review SET score = score - 1 WHERE review.review_id_pk = \'" + reviewId + "\'";
		LOGGER.info(query + "\n" + updateScore);

		try (Statement stmt = con.createStatement()) {

			// Query
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				int val;
				if ((val = rs.getInt("up_dn")) > -1) {
					update = true;
					updateQ = "update user_review set up_dn = " + (val - 1) + " where user_id = \'" + userId
							+ "\' AND review_id = \'" + reviewId + "\'";
				}
			} else {
				update = true;
				updateQ = "insert into user_review (user_id, review_id, up_dn) values (\'" + userId + "\', \'"
						+ reviewId + "\', -1)";
			}

			if (update) {
				PreparedStatement st = con.prepareStatement(updateQ);

				int val = st.executeUpdate();
				st.close();
			}

			LOGGER.warning("incrementing score");

			Statement state = con.createStatement();
			ResultSet worked = state.executeQuery(updateScore);
			if(worked != null) {
				LOGGER.info("query successful");
			}

			state.close();

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query + "\n" + updateQ + "\n" + updateScore);
		}
	}

	@SuppressWarnings({ "unused", "serial" })
	@Override
	protected String[][] getAllCourseInfoByProfImpl(String profName) throws DatabaseOperationException {
		// name, rating, number of reviews
		String[] firstLast = profName.split(" ");
		String getNames = "select title, professor.first_name, professor.last_name, review.teaching_ability + review.workload + review.helpfulness / 3 as avg "
				+ "from review, professor, course " + "WHERE professor.first_name = \'" + firstLast[0] + "\'"
				+ "AND professor.last_name =  \'" + firstLast[1] + "\'"
				+ "AND professor.professor_id_pk = review.professor_id " + "AND review.course_id = course.course_id_pk";
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
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(getNames);
		}

		return finalVals;
	}

	@Override
	protected String[][] getAllFlaggedImpl() throws DatabaseOperationException {
		String query = "select * from review, professor, course where is_flagged = true AND professor.professor_id_pk = review.professor_id AND course.course_id_pk = review.course_id";
		ArrayList<ArrayList<String>> reviews = new ArrayList<>();

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(query);
			ResultSet userReviews = stmt.executeQuery(query);

			int i = 0;
			while (userReviews.next()) {

				reviews.add(new ArrayList<String>());
				reviews.get(i).add(0, userReviews.getString("review_id_pk"));
				reviews.get(i).add(1, userReviews.getString("user_name"));
				reviews.get(i).add(2, userReviews.getString("first_name") + " " + userReviews.getString("last_name"));
				reviews.get(i).add(3, userReviews.getString("title"));
				reviews.get(i).add(4, userReviews.getString("content"));

				i++;
			}
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}

		String[][] finalData;

		finalData = new String[reviews.size()][];

		for (int i = 0; i < reviews.size(); i++) {
			ArrayList<String> row = reviews.get(i);

			// Perform equivalent `toArray` operation
			String[] copy = new String[row.size()];
			for (int j = 0; j < row.size(); j++) {
				// Manually loop and set individually
				copy[j] = row.get(j);
			}

			finalData[i] = copy;
		}
		return finalData;
	}

	@Override
	public boolean isAdminImpl(String userName) throws DatabaseOperationException {
		LOGGER.warning("");
		String query = "SELECT is_admin FROM users WHERE user_name = \'" + userName + "\'";
		ResultSet rs = null;

		try (Statement stmt = con.createStatement()) {

			// Query
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				return rs.getBoolean("is_admin");
			}

			LOGGER.warning(query);

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}
		return false;
	}

	@SuppressWarnings("unused")
	@Override
	protected void upvoteImpl(String reviewId, String userId) throws DatabaseOperationException {
		LOGGER.warning("");
		boolean update = false;
//		String query = "INSERT INTO user_review (user_id, review_id, up_dn) values (\'" + userId + "\', \'" + reviewId + "\', \'" + 1 + "\') "
//				+ "ON conflict (user_id, review_id) do begin if(excluded.up_dn < 1) then update set up_dn = excluded.up_dn + 1; end if;";
		String query = "SELECT * from user_review WHERE user_id = \'" + userId + "\' AND review_id = \'" + reviewId
				+ "\'";
		String updateQ = null;
		String updateScore = "UPDATE review SET score = score + 1 WHERE review.review_id_pk = \'" + reviewId + "\'";
		LOGGER.info(query + "\n" + updateScore);

		try (Statement stmt = con.createStatement()) {

			// Query
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				int val;
				if ((val = rs.getInt("up_dn")) < 1) {
					update = true;
					updateQ = "update user_review set up_dn = " + (val + 1) + " where user_id = \'" + userId
							+ "\' AND review_id = \'" + reviewId + "\'";
				}
			} else {
				update = true;
				updateQ = "insert into user_review (user_id, review_id, up_dn) values (\'" + userId + "\', \'"
						+ reviewId + "\', 1)";
			}

			if (update) {
				PreparedStatement st = con.prepareStatement(updateQ);

				int val = st.executeUpdate();
				st.close();
			}

			LOGGER.warning("incrementing score");

			Statement state = con.createStatement();
			ResultSet worked = state.executeQuery(updateScore);
			if(worked != null) {
				LOGGER.info("query worked");
			}

			state.close();

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query + "\n" + updateQ + "\n" + updateScore);
		}

	}

	@Override
	protected Boolean sendMessageImpl(String m, String from, String to, BigInteger i)
			throws DatabaseOperationException {
		// name, rating, number of reviews

		String sendMessage = "insert into message (message_id_pk, from_user_name, to_user_name, message, date_sent)"
				+ " values ( \'" + Integer.toString(new SecureRandom().nextInt()) + "\', \'" + from + "\', \'" + to + "\', \'"
				+ m + "\', \'" + i.toString() + "\')";
		int rs = 0;

		try (PreparedStatement stmt = con.prepareStatement(sendMessage)) {

			// Query
			LOGGER.info(sendMessage);
			rs = stmt.executeUpdate();

			if (rs > 0) {
				return true;
			}

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(sendMessage);
		}
		return false;
	}

	@Override
	protected Boolean isUpvoteValidImpl(String reviewId, String userId) throws DatabaseOperationException {
		LOGGER.warning(reviewId + " " + userId);
		String check = "select * from user_review, users WHERE user_review.review_id = \'" + reviewId
				+ "\' AND users.user_name = \'" + userId + "\'";

		try (Statement stmt = con.createStatement();) {

			// Query
			LOGGER.info(check);
			ResultSet rs = stmt.executeQuery(check);

			if (rs.next()) {
				if (rs.getInt("up_dn") < 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}

		} catch (

		SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(check);
		}
	}

	@Override
	protected Boolean isDownvoteValidImpl(String reviewId, String userId) throws DatabaseOperationException {
		LOGGER.warning(reviewId + " " + userId);
		String check = "select * from user_review, users WHERE user_review.review_id = \'" + reviewId
				+ "\' AND users.user_name = \'" + userId + "\'";

		try (Statement stmt = con.createStatement();) {

			// Query
			LOGGER.info(check);
			ResultSet rs = stmt.executeQuery(check);

			if (rs.next()) {
				if (rs.getInt("up_dn") > -1) {
					return true;
				} else {
					return false;
				}
			}
			{
				return true;
			}

		} catch (

		SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(check);
		}
	}

	@Override

	protected int getNumberOfMessagesForUserImpl(String user) throws DatabaseOperationException {
		String check = "select count(message.message_id_pk) as num from message where message.from_user_name = \'"
				+ user + "\' OR message.to_user_name = \'" + user + "\'";
		int num = 0;
		try (Statement stmt = threadCon.createStatement();) {

			// Query
			LOGGER.info(check);
			ResultSet rs = stmt.executeQuery(check);

			if (rs.next()) {
				num = rs.getInt("num");
			}

			return num;

		} catch (

		SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(check);
		}
	}

	@Override
	protected String[][] getAllMessagesImpl(String sender, String receiver) throws DatabaseOperationException {
		// text timestamp sender reciever
		String query = "select message.message, date_sent, from_user_name, to_user_name from message "
				+ "where (from_user_name = \'" + sender + "\' OR from_user_name = \'" + receiver
				+ "\') AND (to_user_name = \'" + sender + "\' OR to_user_name = \'" + receiver + "\')";
		ResultSet userReviews = null;
		ArrayList<ArrayList<String>> reviews = new ArrayList<>();

		try (Statement stmt = con.createStatement()) {

			LOGGER.info(query);
			// Query
			userReviews = stmt.executeQuery(query);

			int i = 0;
			while (userReviews.next()) {

				reviews.add(new ArrayList<String>());
				reviews.get(i).add(0, userReviews.getString("message"));
				reviews.get(i).add(1, userReviews.getString("date_sent"));
				reviews.get(i).add(2, userReviews.getString("from_user_name"));
				reviews.get(i).add(3, userReviews.getString("to_user_name"));

				i++;
			}
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}

		String[][] finalData;

		finalData = new String[reviews.size()][];

		for (int i = 0; i < reviews.size(); i++) {
			ArrayList<String> row = reviews.get(i);

			// Perform equivalent `toArray` operation
			String[] copy = new String[row.size()];
			for (int j = 0; j < row.size(); j++) {
				// Manually loop and set individually
				copy[j] = row.get(j);
			}

			finalData[i] = copy;
		}
		return finalData;
	}

	protected void deleteUserAccountImpl(String userId) throws DatabaseOperationException {
		String query = "update users set user_name = \'deleted" + Math.random() * 1000 + "\' where user_name = \'" + userId + "\'";

		try (PreparedStatement stmt = con.prepareStatement(query)) {
			int rs = stmt.executeUpdate();

			if (rs != 1) {
				con.rollback();
				throw new DatabaseOperationException(query);
			}

		} catch (SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}
	}

	@Override
	protected void flagReviewImpl(String reviewId) throws DatabaseOperationException {
		String query = "update review " + "set is_flagged = true " + "where review_id_pk = \'" + reviewId + "\'";

		try (PreparedStatement stmt = con.prepareStatement(query)) {

			LOGGER.info(query);
			int rs = stmt.executeUpdate();

			if (rs != 1) {
				con.rollback();
				throw new DatabaseOperationException(query);
			}

		} catch (SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}
	}

	@Override
	protected void deleteReviewImpl(String reviewId) throws DatabaseOperationException {
		String query = "delete from review where review.review_id_pk = \'" + reviewId + "\'";

		try (PreparedStatement stmt = con.prepareStatement(query)) {
			LOGGER.info(query);
			int rs = stmt.executeUpdate();

			if (rs != 1) {
				con.rollback();
				throw new DatabaseOperationException(query);
			}

		} catch (SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}
	}

	@Override
	protected void removeFlagOnReviewImpl(String reviewId) throws DatabaseOperationException {
		String query = "update review " + "set is_flagged = false " + "where review_id_pk = \'" + reviewId + "\'";

		try (PreparedStatement stmt = con.prepareStatement(query)) {
			LOGGER.info(query);
			int rs = stmt.executeUpdate();

			if (rs != 1) {
				con.rollback();
				throw new DatabaseOperationException(query);
			}

		} catch (SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}
	}

	@Override
	protected void editReviewImpl(String reviewId, String text) throws DatabaseOperationException {
		String query = "update review set content = \'" + text + "\' where review_id_pk = \'" + reviewId + "\'";

		try (PreparedStatement stmt = con.prepareStatement(query)) {
			LOGGER.info(query);
			int rs = stmt.executeUpdate();

			if (rs != 1) {
				con.rollback();
				throw new DatabaseOperationException(query);
			}

		} catch (SQLException e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(query);
		}
	}

	@SuppressWarnings("unused")
	@Override
	protected void setNewReviewImpl(String userName, String professorName, String className, String content, String tA,
			String h, String wL) throws DatabaseOperationException {

		int score = (Integer.parseInt(tA) + Integer.parseInt(h) + Integer.parseInt(wL)) / 3;

		String[] vals = convertProfNameAndClassName(professorName, className);

		String qurey = "insert into review (review_id_pk, professor_id, course_id, user_name, review_date, is_flagged, content, teaching_ability, workload, helpfulness, score)"
				+ "values (\'" + Math.random() * 10000 + "\', \'" + vals[0] + "\', \'" + vals[1] + "\', \'" + userName
				+ "\', \'" + System.currentTimeMillis() + "\', \'" + false + "\', \'" + content + "\', \'" + tA
				+ "\', \'" + wL + "\', \'" + h + "\', \'" + score + "\')";

		try (Statement stmet = con.createStatement()) {
			LOGGER.info(qurey);
			int rs = stmet.executeUpdate(qurey);

		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new DatabaseOperationException(qurey);
		}
	}

	private String[] convertProfNameAndClassName(String professorName, String className) {
		String[] firstLast = professorName.split(" ");

		String query = "select * from professor, course where professor.first_name = \'" + firstLast[0]
				+ "\' AND professor.last_name = \'" + firstLast[1] + "\' AND course.title = \'" + className + "\'";

		try (Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(query);

			String[] res = new String[2];

			if (rs.next()) {
				res[0] = rs.getString("professor_id_pk");
				res[1] = rs.getString("course_id_pk");
			}

			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String[2];
	}
}
