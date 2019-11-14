package BNU.data;

public interface dbWrapper {
	Professor[] getAllProfessors();
	
	Course[] getAllClasses();
	
	Professor[] getAllProfessorsForClass(String className);

	Professor getProfessor(String Prof);
	
	//Professor getProfessorById(String id);

	Course[] getAllClassesForProfessor(String professorName);

	Course getCourse(String course);

}
