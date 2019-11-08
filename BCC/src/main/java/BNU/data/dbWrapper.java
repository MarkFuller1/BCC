package BNU.data;

import java.awt.LayoutManager;

public interface dbWrapper {
	String[] getAllProfessors();
	
	String[] getAllClasses();
	
	String[] getPossibleClasses();
	
	String[] getAllProfessorsForClass(String className);

	Professor getProfessor(String Prof);

	String[] getAllClassesForProfessor(String professorName);

	Course getCourse(String course);

}
