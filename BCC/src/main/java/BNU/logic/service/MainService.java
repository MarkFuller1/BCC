package BNU.logic.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.database.DatabaseConnectionException;
import BNU.data.database.DatabaseOperationException;
import BNU.logic.MainController;

public class MainService {

	private static final Logger LOGGER = Logger.getLogger(MainService.class.getName());

	static {
		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getAllClassesOffered() {
		return MainController.db.getAllClasses();
	}

	public String[] getAllProfs() {
		return MainController.db.getAllProfessors();
	}
}
