package BNU.logic.service;

import BNU.logic.LoginController;//need this to get db

public class LoginService {
	public boolean checkCredentials(String userName, String password) {
		boolean isValidated = false;
		//confirm how I should be getting the db
		if(LoginController.db.validateUser(userName,password)) {
			isValidated = true;
		}
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
