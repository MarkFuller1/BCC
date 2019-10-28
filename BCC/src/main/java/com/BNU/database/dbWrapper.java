package com.BNU.database;

import java.awt.LayoutManager;

import com.BNU.pages.teachersByClass.Professor;

public interface dbWrapper {
	String[] getAllProfessors();
	
	String[] getAllClasses();
	
	String[] getPossibleClasses();
	
	String[] getAllProfessorsForClass(String className);

	Professor getProfessor(String Prof);

}
