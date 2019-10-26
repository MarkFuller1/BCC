package com.BNU.database;

public class DatabaseMock implements dbWrapper{
	
	@Override
	public String[] getAllProfessors() {
		String [] professors = new String[3];
		professors[0] = "Professor one";
		professors[1] = "Professor two";
		professors[2] = "Professor three";
		
		return professors;
	}

	@Override
	public String[] getAllClasses() {
		String [] classes = new String[3];
		classes[0] = "class one";
		classes[1] = "class two";
		classes[2] = "class three";
		
		return classes;
	}
}
