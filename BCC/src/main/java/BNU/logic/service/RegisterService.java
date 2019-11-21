package BNU.logic.service;

import BNU.logic.LoginController;
import BNU.logic.RegisterController;

public class RegisterService {
	public boolean checkCredentials(String userName, String password) {
		boolean exists = false;
		//confirm how I should be getting the db
		if(RegisterController.db.validateUser(userName,password)) {
			exists = true;
		}
		return exists;
	}
	
	public boolean insertCredentials(String userName, String password) {
		return RegisterController.db.submitCredentials(userName,password);
	}
}
