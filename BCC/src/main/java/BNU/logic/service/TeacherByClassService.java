package BNU.logic.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.Course;
import BNU.data.Professor;
import BNU.data.database.DatabaseApi;
import BNU.data.database.DatabaseConnectionException;
import BNU.logic.ClassByTeacherController;
import BNU.logic.TeachersByClassController;

public class TeacherByClassService {

	private static final Logger LOGGER = Logger.getLogger(TeacherByClassService.class.getName());

	static {
		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getAllTeachersByClassService(String courseName) {

		return ClassByTeacherController.db.getAllProfessorsForClass(courseName);

	}

	public Professor[] getAllProfessorsByCourseService(String courseName) {
		String[][] professorObjs = null;
		professorObjs = TeachersByClassController.db.getAllTeacherInfoByCourse(courseName);
		Professor[] professors = new Professor[professorObjs.length];
		Double n, p;
		Integer nc;
		
		for (int i = 0; i < professorObjs.length; i++) {
			
			p = Double.parseDouble(professorObjs[i][1]);
			Double temp = BigDecimal.valueOf(p)
				    .setScale(1, RoundingMode.HALF_UP)
				    .doubleValue();
	        n = Double.parseDouble(professorObjs[i][2]);
			nc = n.intValue();
			professors[i] = new Professor(professorObjs[i][0], temp.toString(), nc.toString());
		}

		return professors;
	}

}
