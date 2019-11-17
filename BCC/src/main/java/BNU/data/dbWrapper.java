package BNU.data;

public interface dbWrapper {
	boolean validateUser(String userName, String password); //new
	
	String[] getAllProfessors();
	
	String[] getAllClasses();
	
	String[] getAllProfessorsForClass(String className);

	Professor getProfessor(String Prof);

	String[] getAllClassesForProfessor(String professorName);

	Course getCourse(String course);

}
