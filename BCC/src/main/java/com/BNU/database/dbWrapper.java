package com.BNU.database;

public interface dbWrapper {
	String[] getAllProfessors();
	
	String[] getAllClasses();
	
	String[] getPossibleClasses();
	
	String[] getAllProfessorsForClass(String className);

}
