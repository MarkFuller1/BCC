package BNU.data;

public interface dbWrapper {
	boolean validateUser(String userName, String password); //new
	
	String[] getAllProfessors();
	
	String[] getAllClasses();
	
	String[] getAllProfessorsForClass(String className);

	Professor getProfessor(String Prof);

	String[] getAllClassesForProfessor(String professorName);

	Course getCourse(String course);
	
	String[][] getAllCoursesByProf(String[] courses); //new

	String[][] getAllTeachersByCourse(String[] professorNames); //new
		
	boolean submitCredentials(String userName, String password); //new
	
	//return array of review content,score,reviewerID
	String[][] getAllReviewsForTeacherClass(String professorName,String className);
	
	// return in this order: overall score, helpfulness, teaching ability, workload
	String[] getOverallProfessorRatings(String professorName);
	
	// return review content, score, reviewerID, course name
	String[][] getAllReviewsForUser(String userName);

}
