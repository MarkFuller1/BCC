package BNU.data;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
				LOGGER.info("Establishing Connection");
				Connection con = DriverManager.getConnection(jdbcUrl);
				LOGGER.info("Remote connection successful.");
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
	public Professor[] getAllProfessors() {
		List<Professor> proflist = new ArrayList<>();
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM professor";
			ResultSet result = stmt.executeQuery(sql);

			// A result set is an object that holds the 2d array of info, but not in a 2d
			// array

			while (result.next()) {
				int rsmd = result.getMetaData().getColumnCount();

				String first = result.getString(result.findColumn("first_name"));
				String last = result.getString(result.findColumn("last_name"));

				proflist.add(new Professor(first + " " + last));

			}
		} catch (

		SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return proflist.toArray(new Professor[0]);
	}

	@Override
	public Course[] getAllClasses() {
		List<Course> courlist = new ArrayList<>();
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM course";
			ResultSet result = stmt.executeQuery(sql);

			// Parse Query into string array
			while (result.next()) {
				int rsmd = result.getMetaData().getColumnCount();

				// tl;dr get the string at the column number(get the index of the column
				// named("title"))
				String title = result.getString(result.findColumn("title"));

				courlist.add(new Course(title));

			}

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return courlist.toArray(new Course[0]);
	}

	@Override
	public Professor[] getAllProfessorsForClass(String className) {
		LOGGER.info("searching for professors for class: " + className);
		List<Professor> proflist = new ArrayList<>();
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT professor_course.professor_id FROM course, professor_course WHERE course.course_id_pk = professor_course.course_id AND course.title = "
					+ className;
			// the SQl here is logically correct but the names of tables and
			// rows and
			// columns need to change
			ResultSet result = stmt.executeQuery(sql);

			printResultSet(result);

			while (result.next()) {
				int rsmd = result.getMetaData().getColumnCount();

				String professorid = result.getString(result.findColumn("professor_id"));

				Professor prof = this.getProfessor(professorid);

				proflist.add(prof);

			}

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return proflist.toArray(new Professor[0]);
	}

	@Override
	public Professor getProfessor(String Prof) {
		Professor prof = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM professors WHERE professor.name = " + Prof; // the SQl here is logically correct
																					// but the names of tables and rows
																					// and columns need to change
			ResultSet result = stmt.executeQuery(sql);

			String firstname = result.getString(result.findColumn("first_name"));
			String lastname = result.getString(result.findColumn("last_name"));

			prof = new Professor(firstname + " " + lastname);

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return prof;
	}

	public Professor getProfessorById(String id) {
		Professor prof = null;

		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM professors WHERE professor.professor_id_pk = " + id; // the SQl here is
																								// logically correct
			// but the names of tables and rows
			// and columns need to change
			ResultSet result = stmt.executeQuery(sql);

			String firstName = result.getString(result.findColumn("first_name"));
			String lastName = result.getString(result.findColumn("last_name"));

			prof = new Professor(firstName + " " + lastName);

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return prof;
	}

	@Override
	public Course[] getAllClassesForProfessor(String professorName) {
		List<Course> courses = new ArrayList<>();
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT professor_course.course_id FROM professors, professor_course WHERE professors.professors_id = professor_course.professor_id AND professors.name = "
					+ professorName; // the SQl here is logically correct but the names of tables and rows and
										// columns need to change
			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				int rsmd = result.getMetaData().getColumnCount();

				String courseid = result.getString(result.findColumn("course_id"));

				Course prof = this.getCourseById(courseid);

				courses.add(prof);

			}

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return courses.toArray(new Course[0]);
	}

	private Course getCourseById(String courseid) {
		Course course = null;

		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM professors WHERE professor.professor_id_pk = " + courseid; // the SQl here is
																									// logically correct
			// but the names of tables and rows
			// and columns need to change
			ResultSet result = stmt.executeQuery(sql);

			String title = result.getString(result.findColumn("title"));

			course = new Course(title);

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return course;
	}

	@Override
	public Course getCourse(String title) {
		Course course = null;
		// establish connection
		try (Connection con = getRemoteConnection(); Statement stmt = con.createStatement()) {

			// Query
			String sql = "SELECT * FROM course WHERE course.title = " + title; // the SQl here is logically correct
																				// but the names of tables and rows
																				// and columns need to change
			ResultSet result = stmt.executeQuery(sql);

			String firstname = result.getString(result.findColumn("title"));

			course = new Course(title);

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return course;
	}

	private void printResultSet(ResultSet rs) {
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			int columnsNumber;
			columnsNumber = rsmd.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
