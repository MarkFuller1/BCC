package BNU.logic.service;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.DatabaseConnectionException;
import BNU.logic.LoginController;
import BNU.logic.RegisterController;

public class RegisterService {

	private static final Logger LOGGER = Logger.getLogger(RegisterService.class.getName());

	static {
		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkCredentials(String userName, String password) {
		boolean exists = false;
		if (RegisterController.db.validateUser(userName, password)) {
			exists = true;
		}
		return exists;
	}

	public boolean insertCredentials(String userName, String password) {
		return RegisterController.db.submitCredentials(userName, password);
	}
}
