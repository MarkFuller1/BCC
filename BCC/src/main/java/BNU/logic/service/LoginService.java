package BNU.logic.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.database.DatabaseApi;
import BNU.logic.LoginController;//need this to get db

public class LoginService {

	private static final Logger LOGGER = Logger.getLogger(DatabaseApi.class.getName());

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
		boolean isValidated = false;
		isValidated = LoginController.db.validateUser(userName, password);
		return isValidated;
	}
	
	public boolean isUserAdmin(String userName) {
		boolean isAdmin = false;
		//confirm how I should be getting the db
		if(LoginController.db.isAdmin(userName)) {
			isAdmin = true;
		}
		return isAdmin;
	}
}
