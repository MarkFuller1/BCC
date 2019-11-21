package BNU.logic.service;

import BNU.logic.MainController;

public class MainService {

	public String[] getAllClassesOffered() {
		return MainController.db.getAllClasses();
	}
	
	public String[] getAllProfs() {
		return MainController.db.getAllProfessors();
	}
}
