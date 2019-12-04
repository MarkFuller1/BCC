package BNU.logic.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import BNU.data.database.DatabaseApi;
import BNU.logic.LoginController;//need this to get db
import BNU.logic.service.proxy.SmartProxy;

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
		SmartProxy sp = new SmartProxy();
		boolean isValidated = false;
		//isValidated = LoginController.db.validateUser(userName, password);
		isValidated = sp.sanatizeAndCheckCreds(userName,password);
		return isValidated;
	}
	
	public boolean isUserAdmin(String userName) {
		SmartProxy sp = new SmartProxy();
		boolean isAdmin = false;
		//confirm how I should be getting the db
		if(sp.sanatizeAndCheckIsAdmin(userName)) {
			isAdmin = true;
		}
		return isAdmin;
	}
}
