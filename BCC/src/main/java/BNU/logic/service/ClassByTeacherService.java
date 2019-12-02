package BNU.logic.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.Course;
import BNU.data.DatabaseApi;
import BNU.data.DatabaseConnectionException;
import BNU.logic.ClassByTeacherController;

public class ClassByTeacherService {

	private static final Logger LOGGER = Logger.getLogger(DatabaseApi.class.getName());

	static {
		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO error box
			e.printStackTrace();
		}
	}

	public String[] getAllClassesByTeacherService(String professorName) {

		return ClassByTeacherController.db.getAllClassesForProfessor(professorName);
	}

	public Course[] getAllCoursesByTeacherService(String professorName) {
		String[][] courseObjs = null;

		courseObjs = ClassByTeacherController.db.getAllCoursesByProf(professorName);

		ArrayList<Course> courses = new ArrayList<Course>();
		String[] whyIsThisHere = null;

		for (int i = 0; i < courseObjs.length; i++) {
			courses.add(new Course(courseObjs[i][0], courseObjs[i][1], courseObjs[i][2]));
		}

		Course[] finalval = new Course[courses.size()];
		finalval = courses.toArray(finalval);
		return finalval;
	}

}
